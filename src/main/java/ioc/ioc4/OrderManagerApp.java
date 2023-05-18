package ioc.ioc4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {
	public static void main(String[] args) {
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/ioc4.xml")); //XmlBeanFactory(2.0등장)는 어노테이션(2.5?등장)을 지원하지 않음
//		OrderManager manager = (OrderManager)factory.getBean("orderManager");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc4.xml");
		OrderManager manager = ctx.getBean(OrderManager.class, "orderManager"); //OrderManager 클래스로 찾아서 가져와..
		// 스트링으로 선언되어 있는 부분을 직접 찾음 -> 컨텍스트 파일과 연관이 깊어짐. 
		manager.order();
		ctx.close();
	}
}