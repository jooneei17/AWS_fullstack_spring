package aop.aop6;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
	@Before("execution(* hello(..)) and args(intValue)")
	@After("execution(* hello(..)) and args(intValue)")
	public void simple(JoinPoint joinpoint, int intValue) {
		if(intValue > 5000) {
			System.out.println("advice 적용 :: " + joinpoint.getSignature().getName() + " : " + intValue);
		}
	}
	
//	@After("execution(* hello(..))")
	@Around("bean(myDependency)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around() :: " + joinPoint.getSignature().getName());
		Object o = joinPoint.proceed();
		System.out.println("around() :: " + joinPoint.getSignature().getName());
		return o;
	}
	
}
