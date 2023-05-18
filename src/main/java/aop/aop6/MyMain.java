package aop.aop6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop6.xml");
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.run();
		
		ctx.close();
	}
}
