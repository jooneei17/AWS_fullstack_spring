package aop.aop6;

import org.springframework.stereotype.Component;

@Component
public class MyDependency {
	public void hello(int intValue){
		System.out.println("hello : " + intValue);
	}
	public void bye(){
		System.out.println("bye");
	}
}
