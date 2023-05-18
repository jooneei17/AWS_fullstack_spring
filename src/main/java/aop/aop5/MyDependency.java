package aop.aop5;

public class MyDependency {
	public void hello(int intValue){
		System.out.println("hello : " + intValue);
	}
	public void bye(){
		System.out.println("bye");
	}
}
