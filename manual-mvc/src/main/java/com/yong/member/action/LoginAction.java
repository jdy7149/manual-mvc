package com.yong.member.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yong.controller.CommandHandler;
import com.yong.member.model.*;

public class LoginAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO userInfo = dao.login(id, pwd);
		
		if (userInfo != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userInfo", userInfo);
			req.setAttribute("msg", "로그인 성공");
		}
		else {
			req.setAttribute("msg", "로그인 실패");
		}
		req.setAttribute("dest", "index.yong");
		
		return "member/memberMsg.jsp";
	}

}
