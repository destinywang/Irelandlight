package com.irelandlight.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * Created by mac on 2016/12/6.
 */
@Component(value = "adminOperatedLog")
@Aspect
public class AdminOperatedLog{
    @Pointcut()     //service层的切入点
    public void serviceAspect(){}
    @Pointcut()     //controller层的切入点
    public void controllerAspect(){}


    @Before(value = "serviceAspect")
    //前置通知，在连接点方法执行之前执行
    public void doBefore(JoinPoint jp){}

    //后置通知，在连接点方法正常执行完成之后执行，若产生异常则不执行
    public void doAfterReturing(JoinPoint jp,Object val){}

    //最终通知，在连接点方法执行完成之后执行
    public void doAfter(JoinPoint jp){}

    //异常通知，在连接点方法体抛出异常后执行
    public void doAfterThrowing(JoinPoint jp,Throwable ex){}

    //环绕通知，在连接点方法体执行外围执行
    public void doAround(ProceedingJoinPoint pjp){

    }


}
