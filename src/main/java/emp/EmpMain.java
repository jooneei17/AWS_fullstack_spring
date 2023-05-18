package emp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
//		Emp emp = new Programmer();
//		emp.work();
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("emp.xml");
		Emp emp = (Emp) ctx.getBean("emp");
		Emp emp1 = (Emp) ctx.getBean("programmer");
		emp.work(); //추상 클래스를 통한 객체 생성
		emp1.work(); //구상 클래스를 통한 객체 생성
		
		System.out.println(emp);
		System.out.println(emp1);
	}
}
