package aop.aop3;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class SimpleMain {
	public static void main(String[] args) {
		First first = new First();
		Second second = new Second();
		
		first.one();
		first.two();
		second.one();
		second.two();
		
		System.out.println("========================");
		
		ProxyFactory pf = new ProxyFactory();
		Advisor adv = new DefaultPointcutAdvisor(new SimplePc(), new SimpleAdv());
		pf.addAdvisor(adv);
		pf.setTarget(first);
		
		First first2 = (First) pf.getProxy();
		pf = new ProxyFactory();
		pf.addAdvisor(adv);
		pf.setTarget(second);
		
		Second second2 = (Second) pf.getProxy();

		first2.one();
		first2.two();
		second2.one();
		second2.two();
	}
}
