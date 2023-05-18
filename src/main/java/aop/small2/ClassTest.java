package aop.small2;
enum MyE {}
public class ClassTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassTest classTest = new ClassTest();
		
		//ClassTest를 가져오는 방법
		
		//1번 방법 인스턴스를 통한 탐색
		Class<?> clazz = classTest.getClass(); 

		//2번 방법 클래스 리터럴을 통한 탐색
		clazz = ClassTest.class; //class와 같은 항렬이면 모두 가능.
		clazz = Override.class; //어노테이션도 가능하다.
		clazz = MyE.class; //enum도 가능

		//3번 방법 이름을 통한 탐색
		clazz = Class.forName("aop.small2.ClassTest");
	}
}
