package kr.co.jmymble.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.mindrot.bcrypt.BCrypt;

import kr.co.jmymble.jsp.domain.Member;
import kr.co.jmymble.jsp.util.DBConn;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//회원가입 insert
	public int insert(Member vo) { //나오는 값이 처리 행 개수이기 때문에 리턴 값이 int
		conn = DBConn.getConnection();
		int result = 0;
		//처리할 sql 구문
		String sql = "insert into tbl_member(id, pw, name, email, addr, addrDetail) values (?, ?, ?, ?, ?, ?)";
		try {
			//문장 생성
			pstmt = conn.prepareStatement(sql);
			
			//문장 처리
			
			int idx = 1;
			pstmt.setString(idx++, vo.getId());
			pstmt.setString(idx++, vo.getPw());
			pstmt.setString(idx++, vo.getName());
			pstmt.setString(idx++, vo.getEmail());
			pstmt.setString(idx++, vo.getAddr());
			pstmt.setString(idx++, vo.getAddrDetail());
			
			result = pstmt.executeUpdate();
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public int updatePw(Member vo) { //나오는 값이 처리 행 개수이기 때문에 리턴 값이 int
		conn = DBConn.getConnection();
		int result = 0;
		//처리할 sql 구문
		String sql = "update tbl_member set pw = ? where id = ?";
		try {
			//문장 생성
			pstmt = conn.prepareStatement(sql);
			
			//문장 처리
			
			int idx = 1;
			pstmt.setString(idx++, vo.getPw());
			pstmt.setString(idx++, vo.getId());
			
			result = pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	
	public int update(Member vo) { //나오는 값이 처리 행 개수이기 때문에 리턴 값이 int
		conn = DBConn.getConnection();
		int result = 0;
		String sql = "update tbl_member set name = ?, email = ?, addr = ?, addrDetail = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, vo.getName());
			pstmt.setString(idx++, vo.getEmail());
			pstmt.setString(idx++, vo.getAddr());
			pstmt.setString(idx++, vo.getAddrDetail());
			pstmt.setString(idx++, vo.getId());
			
			result = pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	
	public Member selectOne(String id) {
		conn = DBConn.getConnection();
		//반환 예정 객체
		Member vo = null;
		
		//처리할 sql 구문
		String sql = "select * from tbl_member where id = ?";
		try {
			// 문장 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//결과집합 반환
			rs = pstmt.executeQuery();
			
			//결과 집합 >> 자바 객체
			if(rs.next()) { //반환이 true인 조건문에는 while 반복문이 잘 어울림. true일때 반복, false일 경우 
				int idx = 1;
				//객체 생성 후 값 바인딩
				vo = new Member(
						rs.getString(idx++), 
						rs.getString(idx++),
						rs.getString(idx++), 
						rs.getDate(idx++),
						rs.getString(idx++), 
						rs.getString(idx++), 
						rs.getString(idx++)
				);
				
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//결과 반환
		return vo;
		
	}
	
	//회원을 불러와서 pw 확인
	//가져와서 암호화하여 업데이트
	//단 한 번만 해야 한다! (암호화 한거를 또 하면 어떻게 찾을거야...)
	public List<Member> selectList() {
		conn = DBConn.getConnection();
		List<Member> vo = new ArrayList<Member>();
		String sql = "select * from tbl_member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //결과 집합이 여러 개가 나올 수 있기 때문에 while
				int idx = 1;
				Member member = new Member(
						rs.getString(idx++), 
						rs.getString(idx++),
						rs.getString(idx++), 
						rs.getDate(idx++),
						rs.getString(idx++), 
						rs.getString(idx++), 
						rs.getString(idx++)
				);
				vo.add(member);
				
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//결과 반환
		return vo;
		
	}
	
	

	public int delete(Member vo) { 
		conn = DBConn.getConnection();
		int result = 0;
		//처리할 sql 구문
		String sql = "delete from tbl_member where id = ?";
		try {
			//문장 생성
			pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, vo.getId());
			
			result = pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	
	
	public void close() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}	
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}	
		}
		
	}
	
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		dao.selectList().forEach(member -> {
			member.setPw(BCrypt.hashpw("1234", BCrypt.gensalt())); //update할 pw 고정
			dao.updatePw(member);
			
		});
	}
	
}
