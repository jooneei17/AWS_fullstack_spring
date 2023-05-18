package student;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class Student {
	@Value("1")
	private int no;
	@Value("최길동")
	private String name;
	private int score;
	
	public Student(int no, String name, int score) {
		this.no = no;
		this.name = name;
		this.score = score;
	}

}
