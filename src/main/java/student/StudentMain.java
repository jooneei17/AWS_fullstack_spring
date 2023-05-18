package student;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//CDL = context dependency lookup
public class StudentMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("student.xml");
		
//		StudentService service = new StudentService();
		StudentService service = (StudentService)ctx.getBean("studentService"); //리턴 타입이 Object이기 때문에 casting을 해주어야 한다. 
//		Student student1 = new Student(1, "홍길동", 90);
		Student student1 = (Student)ctx.getBean("student1");
//		Student student2 = new Student(2, "김길동", 80);
		Student student2 = (Student)ctx.getBean("student2");
		service.add(student1);
		service.add(student2);
		service.list();
		
		System.out.println(ctx.getBean("customStudent"));
		
		List<?> list = (List<?>) ctx.getBean("mylist");
		System.out.println(list.getClass().getSimpleName()); //list가 어떤 타입인지 알아보기		
		list.forEach(System.out::println);
		
		ctx.close();
	}
}
