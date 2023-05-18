package shape2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Component
public class Circle {
	@Autowired
	private Point point;
	@Value("5.5")
	private double r;
	
	public String toString() {
		return String.format("중점 x : %d, y : %d인 원의 반지름은 %f입니다", point.getX(), point.getY(), r);
	}
}
