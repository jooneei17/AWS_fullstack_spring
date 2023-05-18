package co.jmymble.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.jmymble.domain.Member;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//logging
@Log4j
public class MemberMapperTests {
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testMemberMapper() {
		log.info(memberMapper);
	}
	
//	@Test
//	public void testSelectOne() {
//		String id = "javaman";
//		Member member = memberMapper.selectOne(id);
//		log.info(member);
//	}
//	
//	@Test 
//	public void testInsert() {
//		Member member = new Member();
//		member.setId("idid1");
//		member.setPw("1234");
//		member.setName("메퍼테스트 계정");
//		
//		memberMapper.insert(member);
//	}
//	
	@Test
	public void testSelectList() {
		//List<Member>
		memberMapper.selectList().forEach(member -> log.info(member));
	}
	
	@Test
	public void testSelectList2() {
		memberMapper.selectList2().forEach(map -> log.info(map.get("id")));
	}

}