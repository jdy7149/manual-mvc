package com.yong.member.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.controller.CommandHandler;
import com.yong.member.model.*;

public class IdCheckAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isIdDuplicated(id);
		req.setAttribute("result", result);
		
		if (result) {
			req.setAttribute("msg", "중복된 아이디 입니다");
			req.setAttribute("dest", "idcheck-popup.yong");
			return "member/memberMsg.jsp";
		}
		
		req.setAttribute("id", id);
		return "/member/idCheckProcess.jsp";
	}

}
