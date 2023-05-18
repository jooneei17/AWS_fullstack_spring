package kr.co.jmymble.jsp.member.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jmymble.jsp.dao.MemberDao;
import kr.co.jmymble.jsp.domain.Member;
import kr.co.jmymble.jsp.service.MemberService;
import kr.co.jmymble.jsp.service.MemberServiceImpl;
import kr.co.jmymble.jsp.util.ParamSolver;

@WebServlet("/member/signup")
public class SignUp extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = ParamSolver.getParams(req, Member.class);
		System.out.println(member);
		memberService.register(member);
		resp.sendRedirect(req.getContextPath() + "/");
	}
}
