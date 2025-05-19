package com.yong.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yong.controller.CommandHandler;

public class LogoutAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		
		req.setAttribute("msg", "로그아웃됨");
		req.setAttribute("dest", "index.yong");
		return "member/memberMsg.jsp";
	}

}
