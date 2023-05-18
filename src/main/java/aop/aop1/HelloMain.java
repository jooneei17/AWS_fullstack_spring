package aop.aop1;

import java.lang.reflect.Proxy;

public class HelloMain {
	public static void main(String[] args) {
		
		//helloWorld : target 
		HelloWorld helloWorld = new HelloWorldImpl();
		helloWorld.sayHello("반갑습니다 자바맨");
		
		System.out.println("=======================================");
		
		//target을 가지고 proxy 생성
		HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(HelloWorld.class.getClassLoader(),
				new Class[] {HelloWorld.class}, new HelloWordHandler(helloWorld));
		proxy.sayHello("반가워요 프록시");
		
		
		HelloWorld myProxy = new MyProxy();
		System.out.println("=======================================");
		myProxy.sayHello("내 프록시");
		
		System.out.println("target :: " + helloWorld);
		System.out.println("proxy :: " + proxy);
		System.out.println("myProxy :: " + myProxy);
	}
}
