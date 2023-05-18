package co.jmymble.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//logging
@Log4j
public class MemberTests {
	Member member = new Member();
	
	@Autowired
	Member member2;
	@Autowired
	Member member3;
	@Autowired
	Member member4;
	
	@Test
	public void testMe() {
		// TODO Auto-generated method stub
//		System.out.println("Hello Test");
		log.info("hello test");
	}
	
	@Test
	public void testMember() {
		System.out.println(member);
	}
	@Test
	public void testMember2() {
		member2.setId("javaman");
		member2.setName("자바맨");
		
		System.out.println(member2);
		System.out.println(member3);
		System.out.println(member4);
		System.out.println(member4 == member2);
		System.out.println(member3 == member2);
	}

}