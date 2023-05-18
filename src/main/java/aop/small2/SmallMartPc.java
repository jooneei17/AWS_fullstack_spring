package aop.small2;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import aop.aop3.First;

public class SmallMartPc extends StaticMethodMatcherPointcut{

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return targetClass == BeforeLoggingAdv.class && method.getName().equals("before");
	} 
	
}
