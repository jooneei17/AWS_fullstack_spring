package kr.co.jmymble.jsp.board.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jmymble.jsp.domain.Board;
import kr.co.jmymble.jsp.service.BoardService;
import kr.co.jmymble.jsp.service.BoardServiceImpl;
import kr.co.jmymble.jsp.util.ParamSolver;

import static kr.co.jmymble.jsp.util.ParamSolver .*;

@MultipartConfig(location = ParamSolver.UPLOAD_PATH, fileSizeThreshold = 1024)
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardWriteController.doGet() :: " + req.getRequestURI());
		
		if(!isLogin(req)) {
			resp.sendRedirect(req.getContextPath() + "/member/login?href=" + URLEncoder.encode(req.getRequestURI() + "?" + req.getQueryString(), "utf-8"));
			return;
		}
		List<String> categories = new ArrayList<String>(Arrays.asList("공지사항", "자유게시판", "자료실", "갤러리"));
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/WEB-INF/jsp/board/write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!isLogin(req)) {
			resp.sendRedirect(req.getContextPath() + "/member/login?href=" + URLEncoder.encode(req.getRequestURI() + "?" + req.getQueryString(), "utf-8"));
			return;
		}
		//글 작성 시 필요한 정보
		//제목, 내용, 작성자
		Board board = getParams(req, Board.class);
		System.out.println("board write doPost : " + board);
		boardService.register(board);
//		//redirect방식으로 현재 경로(board)에서 list로 이동해야 한다. category를 같이 가지고 다님
		resp.sendRedirect("list?category=" + board.getCategory());
	}
}
