package aop.aop4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop4.xml");
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		MyBean myBean1 = (MyBean) ctx.getBean("myBean1");
		MyBean myBean2 = (MyBean) ctx.getBean("myBean2");
		
		System.out.println("============ target ============");
		myBean.run();
		System.out.println("============ advice 적용 ============");
		myBean1.run();
		System.out.println("============ advisor 적용 ============");
		myBean2.run();
		
		ctx.close();
	}
}
