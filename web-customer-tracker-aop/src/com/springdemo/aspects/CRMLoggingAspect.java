package com.springdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut decorations
	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n =====> In @Before: calling method:" + theMethod);
		
		//display the args to the method
		
		//get the arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru and display args
		for (Object tempArg: args) {
			myLogger.info("\n ====>> argument:"+tempArg);
			
		}
	}
	
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n =====> In @AfterReturning: from method:" + theMethod);
		
		
		
		//display the object
		myLogger.info("\n =====> Returned obejct @AfterReturning advice:"+theResult);
		
		
				
		
	}
	
}
