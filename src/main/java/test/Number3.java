package test;
import java.util.Scanner; 

//클래스명: Number3
public class Number3 {
	public static void main(String[] args) { 
		
		//변수들을 설정하고 저장한다.
		double tem;
		String choice;
		double result;
		
		//Scanner 객체를 생성하고 scan이 가리키게 한다.
		Scanner scan = new Scanner(System.in); 
		
		//온도를 입력받아서 tem에 저장한다
		System.out.print("온도를 입력하세요: ");
		tem = scan.nextDouble();
		
		//섭씨 온도이면 c,C에 입력받아 저장하고 화씨온도이면 f,F에 입력받아 저장한다.
		System.out.print("화씨 온도이면 'F'(혹은 'f')를 입력하고 섭씨 온도이면 'C'(혹은 'c')를 입력하세요: ");
		choice = scan.next();

		//반복문 choice == c or choice == C이면 섭씨온도를 화씨 온도로 바꾸어 출력한다
		if(choice.equals("c") || choice.equals("C")) {
			result = tem * 1.8 +32;
			System.out.println("섭씨 "+ tem +" = 화씨 "+ result +" ");
			
		}
		//choice == f이면 화씨 온도를 섭씨 온도로 바꾸어 출력한다.
		else if(choice.equals("f") || choice.equals("F")) {
			result = (tem-32)/ 1.8;
			System.out.println("화씨 "+ tem +" = 섭씨 "+ result +" ");
			
		}
		//choice가 섭씨, 화씨온도도 아니면 온도 변환 불가와 다음 번에 f나 c 입력받는다.
		else
			System.out.println("섭씨도 화씨도 아니다-");
		    System.out.println("온도 변환을 할 수 없다-");
		    System.out.println("다음 번에는 화씨 온도이면 'F'(혹은 'f')를 입력하고 섭씨 온도이면 'C'(혹은 'c')를 입력하세요: ");
		
		
		    
	}

}
