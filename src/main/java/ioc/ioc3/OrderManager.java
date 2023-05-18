package ioc.ioc3;

import lombok.Setter;

@Setter
public class OrderManager {
	private CarMaker maker;

	public void order() {
		Money money = new Money(1500);
		Car car = maker.sell(money);
		System.out.println(car.getName() + "를 " + money.getAmount() + "에 팔았음");
	}
	
	
}
