package co.jmymble.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	@Autowired @Qualifier("cr")
	private Restaurant restaurant;
	
	@Test
	public void TestExist() {
		//주어진 값
		
		//기대 값
		
		//결과 값
		
		//assert 시리즈는 
//		assertNull(restaurant); //null이길 기대
//		assertEquals(null, restaurant); //null 과 restaurant가 같기를 기대
//		assertNotNull(restaurant); //null이 아니길 기대
		log.info(restaurant);
	}
}
