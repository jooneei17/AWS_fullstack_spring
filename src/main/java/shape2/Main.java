package shape2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("shape2.xml");
		Circle circle = (Circle)ctx.getBean("c");
		System.out.println(circle);
		//xml 기반의 circle : DL, point : DI (setter)
		ctx.close();
	}
}
