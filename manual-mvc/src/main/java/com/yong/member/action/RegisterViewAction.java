package com.yong.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.controller.CommandHandler;

public class RegisterViewAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "/member/register.jsp";
	}

}
