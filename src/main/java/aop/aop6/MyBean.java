package aop.aop6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
@Service
public class MyBean {
	@Setter
	@Autowired
	private MyDependency dependency;
	
	public void run() {
		dependency.hello(5500);
		dependency.hello(4500);
		dependency.bye();
	}
}
