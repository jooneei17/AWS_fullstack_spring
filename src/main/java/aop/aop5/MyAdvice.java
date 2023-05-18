package aop.aop5;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

public class MyAdvice {
	public void simple(JoinPoint joinpoint, int intValue) {
		if(intValue > 5000) {
			System.out.println("advice 적용 :: " + joinpoint.getSignature().getName() + " : " + intValue);
		}
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around() :: " + joinPoint.getSignature().getName());
		Object o = joinPoint.proceed();
		System.out.println("around() :: " + joinPoint.getSignature().getName());
		return o;
	}
	
}
