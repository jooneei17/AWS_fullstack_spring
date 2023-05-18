package ioc.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Setter
@Service
public class OrderManager {
	@Autowired 
	@Qualifier("kiaMaker") //없을 경우, 어떤 차를 선택할지 불분명해 에러 발생할 수 있음.
	private CarMaker maker;
	@Autowired 
	private Money money;

	public void order() {
		money.setAmount(10000);
		Car car = maker.sell(money);
		System.out.println(car.getName() + "를 " + money.getAmount() + "에 팔았음");
	}
	
	
}
