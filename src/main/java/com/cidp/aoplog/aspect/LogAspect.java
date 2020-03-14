package com.cidp.aoplog.aspect;

import com.cidp.aoplog.aop.Log;
import com.cidp.aoplog.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import utils.RequestUtils;
import utils.SecurityUtils;
import utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 切面
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private LogService logService;


//    public LogAspect(LogService logService) {
//        this.logService = logService;
//    }
    @Pointcut("@annotation(com.cidp.aoplog.aop.Log)")
    public void logPointcut(){
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        result = joinPoint.proceed(); //获取目标方法的返回值
        com.cidp.aoplog.model.Log log  = new com.cidp.aoplog.model.Log("INFO");
        HttpServletRequest req = RequestUtils.getHttpServletRequest();
        logService.save(getUsername(), StringUtils.getBrowser(req),StringUtils.getIp(req),joinPoint,log);
        return result;
    }

    public String getUsername() {
        try {
            return SecurityUtils.getUsername();
        }catch (Exception e){
            return "";
        }
    }
}
