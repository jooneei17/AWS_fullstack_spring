package ioc.ioc1;

public class HyundaiMaker {
	public Car sell(Money money) {
		System.out.println("I sold a car");
		Car car = new Car("sonata");
		return car;
	}
}
