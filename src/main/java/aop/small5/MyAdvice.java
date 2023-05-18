package aop.small5;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	public void simple(JoinPoint joinpoint) {
		System.out.println("advice 적용 :: " + joinpoint.getSignature().getName());
	}
	
	@Around("execution(* getPro*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around() :: " + joinPoint.getSignature().getName());
		Object o = joinPoint.proceed();
		System.out.println("around() :: " + joinPoint.getSignature().getName());
		return o;
	}
	
}
