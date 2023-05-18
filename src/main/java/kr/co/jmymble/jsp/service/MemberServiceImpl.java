package kr.co.jmymble.jsp.service;

import java.util.List;

import org.mindrot.bcrypt.BCrypt;

import kr.co.jmymble.jsp.dao.BoardDao;
import kr.co.jmymble.jsp.dao.MemberDao;
import kr.co.jmymble.jsp.dao.ReplyDao;
import kr.co.jmymble.jsp.domain.Member;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao = new MemberDao(); 
	private BoardDao boardDao = new BoardDao();
	private ReplyDao replyDao = new ReplyDao();
	
	@Override
	public void register(Member member) {
		member.setPw(BCrypt.hashpw(member.getPw(), BCrypt.gensalt()));
		memberDao.insert(member);
	}

	@Override
	public int login(String id, String pw) {
		Member member = memberDao.selectOne(id);
		
		if(member == null) {
			//id 없음. 로그인 실패
			return 2;
		} else if(! BCrypt.checkpw(pw,  member.getPw())){
			//비밀번호 틀림. 로그인 실패
			return 3;
			
		} else {
			//로그인 성공
			return 1;
			
		}
	}
	
	@Override
	public Member get(String id) {
		return memberDao.selectOne(id);
	}
	

	@Override
	public List<Member> list() {
		return memberDao.selectList();
	}

	@Override
	public void modify(Member member) {
		memberDao.update(member);
		
	}

	@Override
	public void modifyPW(Member member) {
		//암호화 처리
		member.setPw(BCrypt.hashpw(member.getPw(), BCrypt.gensalt()));
		
		// DB 반영
		memberDao.updatePw(member);
	}

	@Override
	public void remove(Member member) {
		//게시글 처리
		
		//댓글 처리
		
		
		//회원 탈퇴
		memberDao.delete(member);
	}



	
}
