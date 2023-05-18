package aop.small3;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterLoggingAdv implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("after returning :: " + returnValue);
	}
	
}
