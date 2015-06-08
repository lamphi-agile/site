package fr.lamphi.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lamphi.api.User;
import fr.lamphi.api.UserResource;



/**
 * Servlet implementation class Hello
 */
@WebServlet(name = "inscriptionServlet", urlPatterns = { "/inscription" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class Inscription extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String name=req.getParameter("Nom");
		String surname=req.getParameter("Prenom");
		String pseudo=req.getParameter("Pseudo");
		String email=req.getParameter("Email");
		String status=req.getParameter("Statut");
		String password=req.getParameter("Mot de passe");
		String sex=req.getParameter("Sexe");
		
		User newUser = new User(2, name, surname, status, pseudo, email, password, sex);
		UserResource us = new UserResource();
		
		us.createUser(newUser);
		
		response.sendRedirect("index.jsp");
		
	}

}
