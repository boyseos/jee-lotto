package com.lotto.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotto.web.daoimpls.LottoDaoImpl;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.pool.Constants;
import com.lotto.web.serviceImpls.LottoServiceImpl;

@WebServlet("/lotto.do")
public class LottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		String money = request.getParameter("money");
//		LottoBean lotto = new LottoBean();
//		new LottoServiceImpl().createLotto(lotto);
		String dest ="";
		switch (request.getParameter("action")) {
		case "move":
			dest = String.format(Constants.VIEW_PATH,"consumer",request.getParameter("dest"));
			break;
		case "join":
			dest = String.format(Constants.VIEW_PATH,"consumer","login");
			break;
		case "login":
			dest = String.format(Constants.VIEW_PATH,"consumer","buy");
			break;
		case "buy":
			dest = "index.jsp";
			break;
		}
		request.getRequestDispatcher(dest).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
