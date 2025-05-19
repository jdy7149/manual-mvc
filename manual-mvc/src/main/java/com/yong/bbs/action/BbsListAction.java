package com.yong.bbs.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.controller.CommandHandler;
import com.yong.bbs.model.*;

public class BbsListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String curPageStr = req.getParameter("curpage");
		if (curPageStr == null || curPageStr.equals("")) {
			curPageStr = "1";
		}
		
		int curPage = Integer.parseInt(curPageStr);
		BbsDAO dao = new BbsDAO();
		req.setAttribute("result", dao.bbsList(curPage));
		
		String pageBar = com.yong.page.PageModule.makePaging("bbs-list.yong", dao.maxRow(), 5, 5, curPage);
		
		req.setAttribute("pageBar", pageBar);
		return "bbs/bbsList.jsp";
	}

}
