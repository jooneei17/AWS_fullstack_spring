package shape;

import lombok.Data;
import lombok.Setter;

@Data
public class Circle {
	private Point point;
	private double r;
	
	public String toString() {
		return String.format("중점 x : %d, y : %d인 원의 반지름은 %f입니다", point.getX(), point.getY(), r);
	}
}
