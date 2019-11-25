package com.example.spring.framework.context;

import com.example.spring.framework.beans.BeanDefinition;
import com.example.spring.framework.beans.BeanPostProcessor;
import com.example.spring.framework.beans.BeanWrapper;
import com.example.spring.framework.context.support.BeanDefinitionReader;
import com.example.spring.framework.core.BeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangliang
 * @date 2019/11/25 15:22
 */
public class ZLApplicationContext implements BeanFactory {

    private String[] configLocations;

    private BeanDefinitionReader reader;

    //beanDefinitionMap用来保存配置信息
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

    //用来保证注册si单例的容器
    private Map<String,Object> beanCacheMap = new HashMap<String, Object>();

    //用来存储所有的被代理过的对象
    private Map<String,BeanWrapper> beanWrapperMap = new ConcurrentHashMap<String, BeanWrapper>();

    public ZLApplicationContext(String... configLocations){

        this.configLocations = configLocations;

        this.refresh();
    }

    public void refresh(){
        //定位
        this.reader = new BeanDefinitionReader(configLocations);


        //加载
        List<String> beanDefinitions = reader.loadBeanDefinitions();

        //注册
        doRegisty(beanDefinitions);

        //依赖注入(lazy-init=false的时候要执行依赖注入，在这里自动调用getBean方法)
        doAutowired();

    }

    //开始执行自动化的依赖注入
    private void doAutowired(){

        for (Map.Entry<String,BeanDefinition> beanDefinitionEntry : this.beanDefinitionMap.entrySet()){
            String beanName = beanDefinitionEntry.getKey();

            if (beanDefinitionEntry.getValue().isLazyInit()){
                getBean(beanName);
            }

        }


    }

    //真正的将我们的BeanDefinitions注册到beanDefinitionMap中
    private void doRegisty(List<String> beanDefinitions){
        for (String className:
             beanDefinitions) {

            try {
                Class<?> beanClass = Class.forName(className);
                //如果是一个接口，是不能实例化的
                //用它的实现类实例化
                if (beanClass.isInterface()){
                    continue;
                }

                BeanDefinition beanDefinition = reader.registerBean(className);
                if (beanDefinition != null){
                    this.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
                }


                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> i:
                     interfaces) {
                    //如果是多个实现类，只能覆盖，这时候可以自定义名字
                    this.beanDefinitionMap.put(i.getName(),beanDefinition);
                }

                //到这里为止，容器初始化完毕
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }

    //依赖注入，从这里开始。通过读取BeanDefinition中的信息
    //然后，通过反射机制创建一个实例并返回
    //spring做法是，不会把最原始的对象放出去，会用一个BeanWrapper来进行一次包装
    //装饰器模式
    //1.保留原来的oop关系
    //2.我需要对他进行扩展，增强（为以后的AOP打基础）
    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        String className = beanDefinition.getBeanClassName();

        //生成通知事件
        BeanPostProcessor beanPostProcessor = new BeanPostProcessor();

        Object instance = instantionBean(beanDefinition);
        if (null == instance){
            return null;
        }

        //在实例初始化以前调用一次
        beanPostProcessor.postProcessBeforeInitialization(instance,beanName);

        BeanWrapper beanWrapper = new BeanWrapper(instance);
        beanWrapper.setBeanPostProcessor(beanPostProcessor);
        this.beanWrapperMap.put(beanName,beanWrapper);

        //在实例初始化后调用一次
        beanPostProcessor.postProcessAfterInitialization(instance,beanName);

        //通过这样调用，相当于给我们自己留有了可操作的空间
        return this.beanWrapperMap.get(beanName).getWrappedInstance();
    }

    //传一个BeanDefinition,就返回一个实例Bean
    private Object instantionBean(BeanDefinition beanDefinition){
        Object instance = null;
        String className = beanDefinition.getBeanClassName();
        try {
            Class<?> clazz = Class.forName(className);
            //因为根据class才能确定一个类是否有实例
            if (this.beanCacheMap.containsKey(className)){
                instance = this.beanCacheMap.get(className);
             }else {
                instance = clazz.newInstance();
                this.beanCacheMap.put(className,instance);
                return instance;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
