package ioc.ioc5;

import org.springframework.stereotype.Component;

@Component
public class Designer implements Emp{

	public void gotoOffice() {
		System.out.println("디자이너 출근합니다");
	}

	public void getoffWork() {
		System.out.println("디자이너 퇴근합니다");
		
	}
	
}
