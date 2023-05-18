package aop.aop1;

//HelloWorldImpl을 상속받아 구현

public class MyProxy extends HelloWorldImpl {

	@Override
	public void sayHello(String msg) {
		System.out.println("추가된 전처리");
		super.sayHello(msg);
	}

	@Override
	public String toString() {
		return super.getClass().getSuperclass().getName() + "@" + Integer.toHexString(super.getClass().getSuperclass().hashCode());
	}
	
	
	
}
