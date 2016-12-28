package com.irelandlight.aop;

import com.alibaba.fastjson.JSON;
import com.irelandlight.dao.OperationLogDao;
import com.irelandlight.exception.ProductorLogException;
import com.irelandlight.model.Productor;
import com.irelandlight.vo.ProductorLogCustom;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.ClientEndpoint;

/**
 * Created by lenovo on 2016/12/19.
 */
@Component(value = "adminOperationLog")
@Aspect
public class AdminOperationLog {

    @Autowired
    private OperationLogDao operationLogDao;

    private static final Logger logger = LoggerFactory.getLogger(AdminOperationLog.class);  //打印日志信息

    @Pointcut("execution(* com.irelandlight.service..*.*(..))")  //设置service层的切入点
    public void serviceAspect(){}

    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); //为获取request和session做准备
        if(servletRequestAttributes == null){
            throw new ProductorLogException("日志文件插入异常");
        }else{
            HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();  //获取request对象,从而获得session对象
            HttpSession httpSession = httpServletRequest.getSession();  //获取session对象
            Productor productor = (Productor) httpSession.getAttribute("CURRENT_PRODUCTOR");    //获取productor对象
            if(productor != null){
                String ip = httpServletRequest.getRemoteAddr();
                String operation = joinPoint.getSignature().getName();
                StringBuffer parameters = new StringBuffer();
                if(joinPoint.getArgs() != null && joinPoint.getArgs().length>0){
                    for (int i = 0;i < joinPoint.getArgs().length;i++){
                        parameters.append(JSON.toJSONString(joinPoint.getArgs()[i]) + "+");
                    }
                }
                String content = "Admin" + productor.getUserName() + "Address" + ip + "Operation" + operation
                                + "Parameters" + parameters;
                ProductorLogCustom productorLogCustom = new ProductorLogCustom();
                productorLogCustom.setContent(content);
                productorLogCustom.setProductorId(productor.getId());
                operationLogDao.insertOperationLog(productorLogCustom);
            }
        }
    }



}
