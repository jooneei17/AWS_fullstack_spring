package aop.small1;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactory;

public class SmallMainApp {
	public static void main(String[] args) throws Exception {
		SmallMart mart = new SmallMartImpl();
		mart.getProduct("츄르");
		
		System.out.println("===========================");
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BeforeLoggingAdv());
		pf.addAdvice(new AfterLoggingAdv());
		pf.addAdvice(new ThrowLoggingAdv());
		pf.addAdvice(new AroundLoggingAdv());
		pf.addAdvice((MethodInterceptor)invo -> {System.out.println("람다"); return invo.proceed();});
//		MethodInterceptor mi = (invo) -> {
//			System.out.println("람다");
//			return invo.proceed();
//		};
		pf.setTarget(mart);
		
		SmallMart mart2 = (SmallMart) pf.getProxy();
//		mart2.getProduct("고양이 모래");
		mart2.getProduct("stop");
		
	}
}
