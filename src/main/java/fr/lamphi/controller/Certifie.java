package fr.lamphi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.WebApplicationException;

import fr.lamphi.api.user.UserDBResource;

/**
 * Servlet implementation class Hello
 */
@WebServlet(name = "CertifieServlet", urlPatterns = { "/lesson" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })

public class Certifie extends HttpServlet{ 
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String status = req.getParameter("status");
		
		boolean deconnect = req.getParameter("deconnect")==null?false:true;
		if(status != null) {
			if(status.equals("prof"))
				session.setAttribute("user", new UserDBResource().getUser(2));
			
		} else if(deconnect){
			session.invalidate();
		}
	}
}
