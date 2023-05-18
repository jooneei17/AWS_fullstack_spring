package aop.aop3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdv implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("전처리");
		Object o = invocation.proceed();
		System.out.println("후처리");
		return o;
	}
	
}
