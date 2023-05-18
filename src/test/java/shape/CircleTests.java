package shape;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/shape.xml")
//@Log
@Slf4j
public class CircleTests {
	@Autowired
	private Circle circle;
	
	@Test
	public void testCircle() {
//		log.info(circle.toString());
		circle.setR(10);
		log.debug(circle.toString());
	}
}
