package shape;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("shape.xml");
//		Circle circle = (Circle)ctx.getBean("circle");
////		System.out.println(circle); //바로 출력하면 null이 뜬다. point가 초기화 안되어 있기 때문
//		Point point = new Point();
//		point.setX(10);
//		point.setY(20);
//		circle.setPoint(point);
//		circle.setR(5);
//		System.out.println(circle);
		
		Circle circle = ctx.getBean(Circle.class);
		System.out.println(circle);
		//xml 기반의 circle : DL, point : DI (setter)
		ctx.close();
	}
}
