package com.cidp.aoplog.service;

import com.cidp.aoplog.mapper.logMapper;
import com.cidp.aoplog.model.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.lang.reflect.Method;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class LogService {
    @Autowired
    logMapper logMapper;
    @Async
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //通过反射机制 拿到注解中的操作名description
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.cidp.aoplog.aop.Log description = method.getAnnotation(com.cidp.aoplog.aop.Log.class);

        //方法路径 例如：com.cidp.aoplog.controller.getUserName() 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";
        if (log !=null){
            log.setDescription(description.value());
            log.setRequestIp(ip);
        }
        log.setAddress(StringUtils.getCityInfo(log.getRequestIp()));
        log.setMethod(methodName);
        log.setUsername(username);
        log.setBrowser(browser);
        log.setCreateDate(dateFormat.format(new Date()));
        logMapper.InsertLog(log);
    }

}
