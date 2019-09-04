package com.lotto.web.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.pool.Constants;
import com.lotto.web.serviceImpls.ConsumerServiceImpl;
import com.lotto.web.services.ConsumerService;

@WebServlet("/consumer.do")
public class ConsumerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cid = request.getParameter("cid"),
				pass = request.getParameter("pass"),
				dest ="";
		switch (request.getParameter("action")) {
		case "move":
			dest = String.format(Constants.VIEW_PATH,"consumer",request.getParameter("dest"));
			break;
		case "join":
			dest = String.format(Constants.VIEW_PATH,"consumer","login");
			break;
		case "login":
			dest = String.format(Constants.VIEW_PATH,"lotto","buy");
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
