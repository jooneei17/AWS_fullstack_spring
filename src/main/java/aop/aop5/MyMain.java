package aop.aop5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop5.xml");
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.run();
		
		ctx.close();
	}
}
