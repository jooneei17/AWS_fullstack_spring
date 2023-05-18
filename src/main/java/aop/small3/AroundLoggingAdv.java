package aop.small3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdv implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("around before :: " + invocation.getArguments()[0]);
		Object obj = invocation.proceed();
		System.out.println("around after :: " + invocation.getMethod().getReturnType());
		return obj;
	}
	
}
