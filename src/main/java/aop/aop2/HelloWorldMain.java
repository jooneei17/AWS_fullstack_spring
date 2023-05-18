package aop.aop2;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class HelloWorldMain {
	public static void main(String[] args) {
		Hello target = new HelloWorld();
		target.sayHello("target");
		
//		PointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut ) 
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MsgDecorator());
		pf.setTarget(target);
		
		Hello proxy = (Hello) pf.getProxy();
		proxy.sayHello("proxy");
		
		System.out.println(target);
		System.out.println(proxy);
		System.out.println(target == proxy);
	}
}
