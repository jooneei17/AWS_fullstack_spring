package ioc.ioc1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/ioc1.xml")
public class OrderManagerTests {
	@Autowired
	private OrderManager manager;
	
	@Test
	public void testOrder() {
		manager.order();
	}
	
}
