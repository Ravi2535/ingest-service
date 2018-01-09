package com.iat.epoints.ingestservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*
 * Logging Aspect
 * 
 */

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/*
	 * Method to log entry of each method and to calculate logExcecutionTime
	 * 
	 * @param joinPoint
	 */
	@Around("@annotation(LogExecutionTime)")
	public Object logExcecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() : " + joinPoint.getSignature() + "()");

		Object proceed = joinPoint.proceed();
		long start = System.currentTimeMillis();
		long executionTime = System.currentTimeMillis() - start;
		logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

		return proceed;
	}

	/*
	 * @Before Method to log entry of each method
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.iat.epoints..*(..))")
	public void beforeLogging(JoinPoint joinpoint) {
		logger.info("logBefore() is running : " + joinpoint.getSignature() + "()");
	}

	/*
	 * @After Method to log entry of each method
	 * 
	 * @param joinPoint
	 */
	@After("execution(* com.iat.epoints..*(..))")
	public void afterLogging(JoinPoint joinpoint) {
		logger.info("logAfter() is running! " + joinpoint.getSignature() + "()");

	}


}
