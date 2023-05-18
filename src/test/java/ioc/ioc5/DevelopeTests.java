package ioc.ioc5;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/ioc5.xml")
public class DevelopeTests {
	@Autowired
	private Develope develope;
	
	@Test
	public void testCoding() {
		develope.coding();
	}
}
