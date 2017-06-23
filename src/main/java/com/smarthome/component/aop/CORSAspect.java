package com.smarthome.component.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by radishmaster on 10/04/17.
 * 使用AOP来实现CORS
 */
@Aspect
@Component
public class CORSAspect {

    private final static Logger logger = LoggerFactory.getLogger(CORSAspect.class);

    @Pointcut("execution(public * com.smarthome.component.controller.*.*(..))")
    public void pointCut() {}

    /**
     * 对Controller做跨域处理
     * @param joinPoint
     */
    @Around("pointCut()")
    public Object beforeServiceImpl(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        Object result = null;
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info("Error： {}", throwable);
        }
        return result;
    }
}
