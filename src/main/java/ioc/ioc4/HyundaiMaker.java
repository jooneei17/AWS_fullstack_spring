package ioc.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class HyundaiMaker implements CarMaker {
	@Autowired @Setter
	private Car car;
	public Car sell(Money money) {
		car.setName("sonata");
		System.out.println("I sold a car");
		return car;
	}
}
