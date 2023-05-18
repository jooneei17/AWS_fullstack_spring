package ioc.ioc2;

public class OrderManager {
	private CarMaker maker;

	public OrderManager() {
		//Interface를 통해 결합도를 낮춤
//		maker = new HyundaiMaker();
		maker = new KiaMaker();
	}
	
	public void order() {
		Money money = new Money(1500);
		Car car = maker.sell(money);
		System.out.println(car.getName() + "를 " + money.getAmount() + "에 팔았음");
	}
	
	
}
