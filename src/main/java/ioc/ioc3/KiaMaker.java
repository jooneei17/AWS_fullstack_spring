package ioc.ioc3;

public class KiaMaker implements CarMaker{

	public Car sell(Money money) {
		System.out.println("I sold a car");
		Car car = new Car("K5");
		return car;
	}
	
}
