package com.yong.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.controller.CommandHandler;
import com.yong.member.model.*;

public class MemberListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		
		List<MemberDTO> res = dao.memberList();
		
		req.setAttribute("result", res);
		
		return "member/memberList.jsp";
	}

}
