package magic;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Tiger implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		//invoke 랑 비슷함...
		// obj : 메서드 수행 객체
		// method : 메서드 자신
		// args : 파라미터
		// return : Object
		
		return "호랑이";
	}
	

}
