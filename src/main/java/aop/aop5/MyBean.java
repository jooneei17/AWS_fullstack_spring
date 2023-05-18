package aop.aop5;

import lombok.Setter;

public class MyBean {
	@Setter
	private MyDependency dependency;
	
	public void run() {
		dependency.hello(5500);
		dependency.hello(4500);
		dependency.bye();
	}
}
