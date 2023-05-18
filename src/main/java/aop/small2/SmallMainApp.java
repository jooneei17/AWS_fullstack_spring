package aop.small2;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import aop.aop3.SimpleAdv;
import aop.aop3.SimplePc;

public class SmallMainApp {
	public static void main(String[] args) throws Exception {
		SmallMart mart = new SmallMartImpl();
		mart.getProduct("츄르");
		mart.getProduct2("사료");
		
		System.out.println("===========================");
		
		ProxyFactory pf = new ProxyFactory();
//		pf.addAdvice(new BeforeLoggingAdv());
//		pf.addAdvice(new AfterLoggingAdv());
//		pf.addAdvice(new ThrowLoggingAdv());
//		pf.addAdvice(new AroundLoggingAdv());
//		pf.addAdvice((MethodInterceptor)invo -> {System.out.println("람다"); return invo.proceed();});
//		MethodInterceptor mi = (invo) -> {
//			System.out.println("람다");
//			return invo.proceed();
//		};
		
//		Advisor adv = new DefaultPointcutAdvisor(new SmallMartPc(), new BeforeLoggingAdv());
//		pf.addAdvisor(adv);
		
		
//		pointcut 정의 advs의 adv는 before만 정의…
		pf.addAdvisor(new DefaultPointcutAdvisor(new StaticMethodMatcherPointcut() {
			public boolean matches(Method method, Class<?> targetClass) {
				// TODO Auto-generated method stub
				return method.getName().equals("getProduct2");
			}
		} ,new BeforeLoggingAdv()));
		pf.setTarget(mart);
		SmallMart mart2 = (SmallMart) pf.getProxy();
//		mart2.getProduct("고양이 모래");
		
		mart2.getProduct("고양이 모래");
		mart2.getProduct2("고양이 장난감");
		
	}
}
