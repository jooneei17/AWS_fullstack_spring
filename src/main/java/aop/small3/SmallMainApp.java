package aop.small3;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.aop3.SimpleAdv;
import aop.aop3.SimplePc;

public class SmallMainApp {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small3.xml");
		SmallMart smallMart = (SmallMart) ctx.getBean("smallMart");
		SmallMart smallMart1 = (SmallMart) ctx.getBean("smallMart1");
		SmallMart smallMart2 = (SmallMart) ctx.getBean("smallMart2");
		
		System.out.println("======== target ========");
		smallMart.getProduct("츄르");
		
		System.out.println("============ advice 적용 ============");
		smallMart1.getProduct("사료");
		
		System.out.println("============ advisor 적용 ============");
		smallMart2.getProduct("캣타워");
		
		
		
		
		
		
//		SmallMart mart = new SmallMartImpl();
//		mart.getProduct("츄르");
//		mart.getProduct2("사료");
//		
//		System.out.println("===========================");
//		
//		ProxyFactory pf = new ProxyFactory();
////		pf.addAdvice(new BeforeLoggingAdv());
////		pf.addAdvice(new AfterLoggingAdv());
////		pf.addAdvice(new ThrowLoggingAdv());
////		pf.addAdvice(new AroundLoggingAdv());
////		pf.addAdvice((MethodInterceptor)invo -> {System.out.println("람다"); return invo.proceed();});
////		MethodInterceptor mi = (invo) -> {
////			System.out.println("람다");
////			return invo.proceed();
////		};
//		
////		Advisor adv = new DefaultPointcutAdvisor(new SmallMartPc(), new BeforeLoggingAdv());
////		pf.addAdvisor(adv);
//		
//		
////		pointcut 정의 advs의 adv는 before만 정의…
//		pf.addAdvisor(new DefaultPointcutAdvisor(new StaticMethodMatcherPointcut() {
//			public boolean matches(Method method, Class<?> targetClass) {
//				// TODO Auto-generated method stub
//				return method.getName().equals("getProduct2");
//			}
//		} ,new BeforeLoggingAdv()));
//		pf.setTarget(mart);
//		SmallMart mart2 = (SmallMart) pf.getProxy();
////		mart2.getProduct("고양이 모래");
//		
//		mart2.getProduct("고양이 모래");
//		mart2.getProduct2("고양이 장난감");
		
		ctx.close();
		
	}
}
