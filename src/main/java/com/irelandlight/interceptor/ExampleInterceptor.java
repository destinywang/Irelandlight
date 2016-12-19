package com.irelandlight.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>This is a Example for Interceptor with detailed comment</p>
 *
 * <p>
 *     the implement of Interceptor:
 *     1. create an Interceptor class which is implement from HandlerInterceptor
 *     2. make the Interceptor registered in SpringMVC(in configuration file of SpringMVC)
 *     3. set up the intercept rule of Interceptor
 * </p>
 *
 * @author destiny
 * @see org.springframework.web.servlet.HandlerInterceptor
 * @since 2016-12-18 on jdk 1.8
 */
public class ExampleInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前被调用
     *
     * @param request       封装的Http请求对象
     * @param response      封装的Http响应对象
     * @param handler       本质上是被拦截的请求的目标，其实就是一个被拦截的controller实例
     * @return              是否要将当前的请求拦截下来
     *                          如果返回false，请求将被终止。
     *                          如果返回true，请求将会继续进行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        request.setCharacterEncoding("utf-8");
        System.out.println("ExampleInterceptor.preHandle");
        return true;
    }

    /**
     * 在请求处理之后被调用
     *
     * @param request       封装的Http请求对象
     * @param response      封装的Http响应对象
     * @param handler       本质上是被拦截的请求的目标，其实就是一个被拦截的controller实例
     * @param modelAndView  可以通过modelAndView参数来改变显示的视图或给发往视图的方法增加对象
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView)
            throws Exception {
        System.out.println("ExampleInterceptor.postHandle");
    }

    /**
     * 在请求结束之后被调用
     * 主要用来关闭资源
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
            throws Exception {
        System.out.println("ExampleInterceptor.afterCompletion");
    }
}
