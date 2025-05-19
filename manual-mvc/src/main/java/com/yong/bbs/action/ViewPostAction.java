package com.yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.bbs.model.*;
import com.yong.controller.CommandHandler;

public class ViewPostAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idxStr = req.getParameter("idx"); 
		
		if (idxStr == null || idxStr.equals("")) {
			idxStr = "0";
		}
		int idx = Integer.parseInt(idxStr);
		
		BbsDAO dao = new BbsDAO();
		
		BbsDTO result = dao.viewPost(idx);
		
		if (result == null) {
			req.setAttribute("msg", "게시글을 확인할 수 업습니다");
			return "msg.jsp";
		}
		
		result.setContent(result.getContent().replaceAll("\n", "<br>"));
		req.setAttribute("result", result);
		return "bbs/viewPost.jsp";
	}

}
