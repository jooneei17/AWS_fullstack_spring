package ioc.ioc3;

public class HyundaiMaker implements CarMaker {
	public Car sell(Money money) {
		System.out.println("I sold a car");
		Car car = new Car("sonata");
		return car;
	}
}
