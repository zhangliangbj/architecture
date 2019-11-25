package com.example.spring.servlet;

import com.example.spring.annotation.Autowried;
import com.example.spring.annotation.Controller;
import com.example.spring.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangliang
 * @date 2019/11/24 15:19
 */
public class DispatchServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private Map<String,Object> beanMap = new ConcurrentHashMap<String,Object>();

    private List<String> classNames = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---------- 调用post -----------");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //开始初始化的进程

        //定位
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //加载
        doScan(contextConfig.getProperty("scanPackage"));

        //注册
        doRegistry();

        //自动依赖注入
        //在spring中是通过调用getBean方法才触发依赖注入的
        doAutowired();

        //如果是springMVC会多一个设计叫handlerMapping
        //将@ResuestMapping中配置的url和一个method关联上
        //以便于从浏览器获得用户输入的url以后，能够找到具体执行的method通过反射去调用
        initHandlerMapping();

    }
    private void doLoadConfig(String location){
        //在spring中是通过Reader去查找定位
        String s = location.replace("classpath:","");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(s);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScan(String packageName){
        URL url = this.getClass().getClassLoader().getResource("/"+ packageName.replaceAll("\\.","/"));

        File classDir = new File(url.getFile());

        for (File file:
             classDir.listFiles()) {
            if (file.isDirectory()){
                doScan(packageName+"."+file.getName());
            }else {
                classNames.add(packageName + "." + file.getName().replace(".class",""));
            }
        }

    }

    private void doRegistry(){

        if (classNames.isEmpty()){
            return;
        }

        for (String className:
             classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                //在spring中用的多个子方法来处理，不是if else
                if (clazz.isAnnotationPresent(Controller.class)){
                    String beanName = lowerFirstCase(clazz.getSimpleName());
                    //在Spring中这个阶段是不会直接put instance,这里put的是BeanDefinition
                    beanMap.put(beanName,clazz.newInstance());
                }else if (clazz.isAnnotationPresent(Service.class)){
                    Service service = clazz.getAnnotation(Service.class);
                    //默认用类名首字母注入
                    //如果自己定义了beanName,那么优先使用自己定义的beanName
                    //如果是一个接口，使用接口的类型自动注入

                    //在spring中同样会分别调用不同的方法autowiredByName  autowiredByType

                    String beanName = service.value();
                    if ("".equals(beanName.trim())){
                        beanName = lowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    beanMap.put(beanName,instance);

                    Class<?>[] interfaces = clazz.getInterfaces();

                    for (Class<?> i:
                            interfaces) {
                        beanMap.put(i.getName(),instance);
                    }

                }else {
                    continue;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private void doAutowired(){
        if (beanMap.isEmpty()){
            return;
        }
        for (Map.Entry<String,Object> entry:
             beanMap.entrySet()) {
            Field [] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field:
                 fields) {
                if (field.isAnnotationPresent(Autowried.class)){
                    continue;
                }
                Autowried autowried = field.getAnnotation(Autowried.class);
                String beanName = autowried.value().trim();
                if ("".equals(beanName)){
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(),beanMap.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private void initHandlerMapping() {

    }

    private String lowerFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
