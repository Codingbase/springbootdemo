package com.example.aspct;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * Created by shen on 2018/1/7.
 * AOP的实现
 */
@Aspect
@Component
public class HTTPAspect {
//   使用spring boot 自带的log方法import org.slf4j.Logger;
    private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);

    // 在Pointcut中添加要拦截的方法,如果要拦截整个类直接后面跟上*就可以
    @Pointcut(" execution(public * com.example.Controller.GirlController.*(..))")
    public void log() {
    }
//    Before是在执行前执行,调用log()方法,记录请求的内容
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
//        记录请求的 url method IP 类方法 参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取url
        logger.info("url={}", request.getRequestURI());
        //获取method
        logger.info("method={}", request.getMethod());
        //获取ip
        logger.info("IP={}", request.getRemoteAddr());
        //获取类方法
        logger.info("Class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //获取参数
        logger.info("args={}", joinPoint.getArgs());
    }
    // After是在执行后处理的,
    @After("log()")
    public void doAfter(){
        logger.info("2222222222");
    }
//    获取返回的内容,传一个object对象.现在实体中添加一个toString方法 ,在把对象调用toString方法
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}

