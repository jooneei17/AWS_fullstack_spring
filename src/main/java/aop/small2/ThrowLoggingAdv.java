package aop.small2;

import org.springframework.aop.ThrowsAdvice;

public class ThrowLoggingAdv implements ThrowsAdvice{
	public void afterThrowing(Throwable throwable) {
		System.out.println("afterThrowing :: " + throwable.getMessage());
	}
}
