package test;

import java.util.Scanner;

//양의 정수내의 숫자들을 해당 수사로 출력
public class Number5 {
	
	public static int Ten(int N) {
		String str = Integer.toString(N);
		
		int temp = str.length() - 1;
		int result = 1;
		
		for(int i = 0; i < temp; i++){
			result *= 10;
		}
//		
		return result;
		
	}
	
	public static void Unit(int N) {
		
		//N = 51423  Ten(N) = 10000
		//N = 10000
		
		String str = Integer.toString(N);
		
		for(int i = str.length(); i > 0 ; i--){
			int j = 0;
			j = N / Ten(N);
			//51423 / 10000
			N -= j * Ten(N);
		
			switch(j) {
			case 0:
				System.out.print("영");
				break;
			case 1: 
				System.out.print("하나");
				break;
			case 2: 
				System.out.print("둘");
				break;
			case 3:
				System.out.print("셋");
				break;
			case 4:
				System.out.print("넷");
				break;
			case 5:
				System.out.print("다섯");
				break;
			case 6:
				System.out.print("여섯");
				break;
			case 7:
				System.out.print("일곱");
				break;
			case 8:
				System.out.print("여덟");
				break;
			case 9:
				System.out.print("아홉");
				break;
			
			}
		}
	
	}
	
//	public static String FindnumberWhile(int N){
//		
//		for (int i = 0; i < N; i++) {
//			
//			int n = Ten(N).charAt(i) - '0'; 
//			System.out.print(Unit(n) ); 
//			
//		}
//		return Unit(N);
//	}
//	
//	public static String Findnumber(int N) {
//		return Unit(N);
//	}
	
	
	public static void main(String[] args) {
		
		int N;
		
		//Scanner 객체를 생성하고 scan이 가리키게 한다.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		N = scan.nextInt();
		
		System.out.println(Ten(N));
		
		Unit(N);
		
//		System.out.println("반복 메소드 결과\n 정수내의 숫자들: " +FindnumberWhile(N));
//		System.out.println("재귀 메소드 결과\n 정수내의 숫자들: " +Findnumber(N));
	}

}
