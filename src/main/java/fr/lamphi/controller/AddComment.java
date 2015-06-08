package fr.lamphi.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lamphi.api.Commentaires;
import fr.lamphi.api.CommentairesRessource;
import fr.lamphi.api.User;

@WebServlet(name = "addComment", urlPatterns = { "/AddComment" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class AddComment extends HttpServlet {

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		User user = (User)request.getSession().getAttribute("user");
		
		if(user == null)
			response.sendRedirect("connexion.jsp");
		
		Commentaires newComments = new Commentaires(0, user.getId(), Integer.parseInt(request.getParameter("idLesson")), request.getParameter("comment"), new Date(System.currentTimeMillis()).toString());


		
		CommentairesRessource cr = new CommentairesRessource();
		cr.createCom(newComments);
		
		response.sendRedirect("lesson.jsp?id="+request.getParameter("idLesson"));
	}
}
