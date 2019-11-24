package com.example.spring.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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

    private Map<String,Object> iocMap = new ConcurrentHashMap<String,Object>();

    private List<String> beanNames = new ArrayList<String>();

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
        doScan();

        //注册
        doRegistry();

        //自动依赖注入
        doAutowired();

        //如果是springMVC会多一个设计叫handlerMapping
        //将@ResuestMapping中配置的url和一个method关联上
        //以便于从浏览器获得用户输入的url以后，能够找到具体执行的method通过反射去调用
        initHandlerMapping();

    }
    private void doLoadConfig(String location){
        //在spring中是通过Reader去查找定位
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location.replace("classpath",""));
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

    private void doScan(){

    }

    private void doRegistry(){

    }

    private void doAutowired(){

    }

    private void initHandlerMapping() {

    }
}
