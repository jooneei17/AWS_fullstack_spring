package aop.aop3;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class AspectJMain {
	public static void main(String[] args) {
		First first = new First();
		Second second = new Second();
		
		first.one();
		first.two();
		second.one();
		second.two();
		
		System.out.println("========================");
		
		//특정 대상에게 조건을 걸기 위한 것 = pointcut
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor(); //advisor 타입
		advisor.setAdvice(new SimpleAdv());
		advisor.setExpression("execution(* one(..))"); //pointcut의 Aspectj형태의 표현식 
	
		Pointcut pc = advisor.getPointcut(); //pc는 AspectJExpressionPointcut 타입이 나온다
		Advice adv = advisor.getAdvice(); // adv는 SimpleAdv 타입이 나온다.
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(first);
		
		
		First first2 = (First) pf.getProxy();
		
		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(second);
		
		Second second2 = (Second) pf.getProxy();
		
		first2.one();
		first2.two();
		second2.one();
		second2.two();
	}
	
}
