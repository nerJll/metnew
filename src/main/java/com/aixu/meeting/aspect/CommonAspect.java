package com.aixu.meeting.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* @desc		登陆切面
* @author jianglinle
* @date 2017年12月6日
*/
@Aspect
@Component
public class CommonAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(CommonAspect.class);
	
	@Pointcut("execution(public * com.aixu.meeting.controller.MeetController.*(..))")
	public void log() {
	}
	
	@Before("log()")
	public void login() {
		logger.info("mc方法执行前。。。");
	}
	
	@After("log()")
	public void logout() {
		logger.info("mc方法执行后。。");
	}
}
