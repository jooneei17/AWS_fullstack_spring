package ioc.ioc5;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Emp{

	public void gotoOffice() {
		System.out.println("프로그래머 출근합니다");
	}

	public void getoffWork() {
		System.out.println("프로그래머 퇴근합니다");
		
	}
	
}
