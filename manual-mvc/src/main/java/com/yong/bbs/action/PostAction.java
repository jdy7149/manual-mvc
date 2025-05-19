package com.yong.bbs.action;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yong.controller.CommandHandler;
import com.yong.member.model.*;
import com.yong.bbs.model.*;

public class PostAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		MemberDTO userInfo = (MemberDTO)req.getSession().getAttribute("userInfo");
		
		BbsDAO dao = new BbsDAO();
		
		String title = req.getParameter("title");
		String writer = userInfo.getId();
		String content = req.getParameter("content");
		int ref = req.getParameter("ref") == null ? dao.maxRef() : Integer.parseInt(req.getParameter("ref"));
		int lev = req.getParameter("lev") != null ? Integer.parseInt(req.getParameter("lev")) : 0;
		int sunbun = req.getParameter("sunbun") != null ? Integer.parseInt(req.getParameter("sunbun")) : 0;
		BbsDTO dto = new BbsDTO(0, title, writer, null, content, 0, ref, lev, sunbun);
		
		int result = dao.post(dto);
		
		String msg = result > 0 ? "게시글 작성 성공" : "게시글 작성 실패";
		req.setAttribute("msg", msg);
		req.setAttribute("dest", "index.yong");
		
		return "msg.jsp";
	}

}
