package fr.lamphi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testServlet", urlPatterns = { "/hello" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class Hello extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String simpleParam = getServletConfig().getInitParameter("simpleParam");
		
		request.setAttribute("param", simpleParam);
		this.getServletContext().getRequestDispatcher("../view/Hello.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}