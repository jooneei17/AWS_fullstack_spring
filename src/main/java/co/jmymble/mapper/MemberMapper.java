package co.jmymble.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import co.jmymble.domain.MemberVO;

public interface MemberMapper {
	void insert(MemberVO vo);
	
	@Select("select * from tbl_member")
	List<MemberVO> getList();
	
	@Select("select * from tbl_member where id = #{id}")
	MemberVO read(String id);
	
	@Select("select * from tbl_member where id = #{id} and pw = #{pw}")
	MemberVO login(MemberVO vo);
}
