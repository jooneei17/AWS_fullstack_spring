package co.jmymble.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import co.jmymble.domain.Member;

public interface MemberMapper {
	@Insert("insert into tbl_member(id, pw, name) values (#{id}, #{pw}, #{name})")
	int insert(Member member);
	
	@Select("select * from tbl_member where id = #{id}")
	Member selectOne(String id);
	
	@Select("select * from tbl_member")
	List<Member> selectList();
	
	@Select("select * from tbl_member")
	List<Map<String, Object>> selectList2();
}
