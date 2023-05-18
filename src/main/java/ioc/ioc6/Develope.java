package ioc.ioc6;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Develope {
	private Emp emp;
	private Emp emp2;
	
	void coding() {
		emp.gotoOffice();
		emp2.gotoOffice();
		System.out.println("업무 합니다...");
		emp.getoffWork();
		emp2.getoffWork();
		
		emp.gotoOffice();
		System.out.println("업무 합니다...");
		emp.getoffWork();
	}
}
