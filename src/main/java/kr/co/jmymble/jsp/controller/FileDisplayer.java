package kr.co.jmymble.jsp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jmymble.jsp.dao.AttachDao;
import kr.co.jmymble.jsp.dao.BoardDao;
import kr.co.jmymble.jsp.domain.Attach;
import kr.co.jmymble.jsp.util.ParamSolver;

@WebServlet("/display")
public class FileDisplayer extends HttpServlet{

	AttachDao dao = new AttachDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullPath = req.getParameter("fullpath");
		if(fullPath == null) return;
		File file = new File(ParamSolver.UPLOAD_PATH, fullPath);


		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	
		byte[] bytes = new byte[(int)file.length()]; //InputStream에 있는 파일의 내용을 가져와서 bytye배열에 저장
		bis.read(bytes);
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		bos.write(bytes);
		bis.close();
		bos.close();
	}
	
	//2023/03/29 62495655-4831-48c3-a91d-692a05757f97
	
}
