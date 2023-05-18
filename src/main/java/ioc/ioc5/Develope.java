package ioc.ioc5;

import org.springframework.stereotype.Service;

@Service
public class Develope {
	private Emp emp;
	private Emp emp2;
	
	public Develope(Emp emp, Emp emp2) {
		this.emp = emp;
		this.emp2 = emp2;
	}
	
	void coding() {
		emp.gotoOffice();
		emp2.gotoOffice();
		System.out.println("업무 합니다...");
		System.out.println("업무 합니다...");
		emp.getoffWork();
		emp2.getoffWork();
	}
}
