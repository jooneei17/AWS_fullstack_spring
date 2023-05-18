package co.jmymble.mapper;

import javax.annotation.Resource;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
//	@Autowired
//	@Inject //상단의 Autowired와 결과는 같음
	@Resource
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper);
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testgetTime2() {
		log.info(timeMapper.getTime2());
	}
	@Test
	public void testGetTime2() {
		timeMapper.memberList().forEach(log::info);
	}
	
	
}
