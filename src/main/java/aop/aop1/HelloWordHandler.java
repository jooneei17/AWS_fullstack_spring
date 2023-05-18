package aop.aop1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HelloWordHandler implements InvocationHandler{
	private Object object;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("전처리");
		Object o = method.invoke(object, args);
		System.out.println("후처리");
		return o;
	}

}
