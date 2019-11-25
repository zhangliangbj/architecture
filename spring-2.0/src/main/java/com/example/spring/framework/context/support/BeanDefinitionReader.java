package com.example.spring.framework.context.support;

import com.example.spring.framework.beans.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zhangliang
 * @date 2019/11/25 15:40
 */
//对配置文件进行查找，读取，解析
public class BeanDefinitionReader {

    private Properties config  = new Properties();

    private List<String> registyBeanClasses = new ArrayList<String>();

    //在配置文件中，用来需要获取自动扫描的包名的key
    private final String SCAN_PACKAGE = "scanPackage";

    public BeanDefinitionReader(String... locations){
        //在spring中是通过Reader去查找定位
        String s = locations[0].replace("classpath:","");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(s);
        try {
            config.load(is);
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
        doScan(config.getProperty(SCAN_PACKAGE));
    }

    public List<String> loadBeanDefinitions(){
        return this.registyBeanClasses;
    }

    //没注册一个className,就返回一个BeanDefinition，我自己包装
    //只是为了对配置信息进行一个包装
    public BeanDefinition registerBean(String className){

        if (this.registyBeanClasses.contains(className)){
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryBeanName(lowerFirstCase(className.substring(className.lastIndexOf(".")+1)));
            return beanDefinition;
        }

        return null;
    }

    public Properties getConfig(){
        return this.config;
    }

    //递归扫描所有的相关联的class，并且保存到一个list中
    private void doScan(String packageName){
        URL url = this.getClass().getClassLoader().getResource("/"+ packageName.replaceAll("\\.","/"));

        File classDir = new File(url.getFile());

        for (File file:
                classDir.listFiles()) {
            if (file.isDirectory()){
                doScan(packageName+"."+file.getName());
            }else {
                registyBeanClasses.add(packageName + "." + file.getName().replace(".class",""));
            }
        }

    }

    private String lowerFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
