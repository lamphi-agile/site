package fr.lamphi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lamphi.api.Lesson;
import fr.lamphi.api.LessonRessource;
import fr.lamphi.api.User;

@WebServlet(name = "addLessonServlet", urlPatterns = { "/AddLesson" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class AddLesson extends HttpServlet {

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		User user = (User)request.getSession().getAttribute("user");
<<<<<<< HEAD
		Lesson lesson = new Lesson(request.getParameter("title"),  "",request.getParameter("contenu"), 1, user, ""+System.currentTimeMillis(), false,0);
=======
		//Lesson lesson = new Lesson(request.getParameter("title"),  "",request.getParameter("contenu"), 1, user, ""+System.currentTimeMillis(), false,0);
>>>>>>> 5ffd386e05dcf0f11091c3d56c9f157b1c36a985

		
		LessonRessource lr = new LessonRessource();
		lr.createLesson(lesson);
		
		response.sendRedirect("index.jsp");
	}
}
