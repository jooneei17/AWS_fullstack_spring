package shape2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//중점
@Data
@Component
public class Point {
//	@Value("10") //x에 기본 값으로 10을 준다
	private int x = 10;
	@Value("20") //spring을 통해 값을 생성할 때 
	private int y;
	
}
