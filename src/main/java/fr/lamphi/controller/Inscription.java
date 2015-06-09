package fr.lamphi.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lamphi.api.user.User;
import fr.lamphi.api.user.UserDBResource;
import fr.lamphi.api.user.UserResource;



/**
 * Servlet implementation class Hello
 */
@WebServlet(name = "inscriptionServlet", urlPatterns = { "/inscription" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class Inscription extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String name=req.getParameter("name");
		String surname=req.getParameter("surname");
		String pseudo=req.getParameter("pseudo");
		String email=req.getParameter("email");
		String status=req.getParameter("status");
		String password=req.getParameter("password");
		String sex=req.getParameter("sex");
		
		User newUser = new User(2, name, surname, status, pseudo, email, password, sex);
		UserDBResource us = new UserDBResource();
		
		us.createUser(newUser);
		
		response.sendRedirect("index.jsp");
		
	}

}
