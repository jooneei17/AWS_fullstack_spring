package ioc.ioc4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Component
// 명시하지 않으면 해당 클래스명의 첫 글자만 소문자로 된 문자가 value 값으로 지정
@NoArgsConstructor
public class Car {
//	@Value("K5")
	private String name;
}
