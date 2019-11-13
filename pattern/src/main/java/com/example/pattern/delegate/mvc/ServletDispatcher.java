package com.example.pattern.delegate.mvc;

import com.example.pattern.delegate.mvc.controller.MemberAction;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangliang
 * @date 2019/11/13 17:00
 */
public class ServletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<>();

    public ServletDispatcher(){
        try {
            Class<?> memberActionClazz = MemberAction.class;
            Handler handler = new Handler();
            handler.setController(memberActionClazz.newInstance());
            handler.setMethod(memberActionClazz.getMethod("getMemberById", new Class[]{String.class}));
            handler.setUrl("/web/getMemberById.json");
            handlerMapping.add(handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }

    public void doDispatch(HttpServletRequest request, HttpServletResponse response){
        //获取用户请求的url
        String uri = request.getRequestURI();

        //Servlet拿到url后，去判断，去选择
        //3、通过拿到的URL去handlerMapping（我们把它认为是策略常量）
        Handler handle = null;
        for (Handler h:
             handlerMapping) {
            if (StringUtils.equals(uri,h.getUrl())){
                handle = h;
                break;
            }
        }
        //4.将具体的任务分发给method（通过反射去调用其他方法）
        Object object = null;
        try {
            object = handle.getMethod().invoke(handle.getController(),request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5、获取到Method执行的结果，通过Response返回出去
        try {
                response.getWriter().write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
