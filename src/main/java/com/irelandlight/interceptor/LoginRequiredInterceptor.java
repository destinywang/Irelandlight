package com.irelandlight.interceptor;

import com.irelandlight.model.HostHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>LoginRequiredInterceptor based implementation of the
 * <tt>HandlerInterceptor</tt>.
 *
 * This implementation is used to <strong>judge the
 * login-status of current thread</strong></p>
 *
 * <p>In this Interceptor,
 * we can judge the status in preHandler,
 * and we just do nothing in postHandler and afterCompletion</p>
 *
 * @author destiny
 * @see org.springframework.web.servlet.HandlerInterceptor
 * @see org.springframework.web.servlet.ModelAndView
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @since 2016-12-14 on jdk 1.8
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor{

    @Resource
    private HostHolder hostHolder;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRequiredInterceptor.class);

    /**
     * @param request       model of HttpServletRequest
     * @param response      model of HttpServletResponse
     * @param handler
     * @return              status of whether already login
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        if (hostHolder.getConsumer() == null) {
            LOGGER.info("检测到未登录的请求");
            // TODO redirect to login page
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView)
            throws Exception {

    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {

    }
}
