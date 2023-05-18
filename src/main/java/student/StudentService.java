package student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
	List<Student> students;
	
	
	//setter를 통한 값 주입
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	void add(Student student) {
		students.add(student);
	}
	
	void list() {
		students.forEach(System.out::println);
	}
}
