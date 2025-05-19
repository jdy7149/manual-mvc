package com.yong.member.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.controller.CommandHandler;
import com.yong.member.model.*;

public class RegisterAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		MemberDTO dto = new MemberDTO(0, id, pwd, name, email, tel, addr);
		MemberDAO dao = new MemberDAO();
		
		int result = dao.register(dto);
		
		String msg = result > 0 ? "회원가입성공(mvc)" : "회원가입실패(mvc)";
		req.setAttribute("msg", msg);
		req.setAttribute("dest", "index.yong");
		
		return "/member/memberMsg.jsp";
	}

}
