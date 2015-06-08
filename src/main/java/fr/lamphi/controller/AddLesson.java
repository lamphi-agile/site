package fr.lamphi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lamphi.api.Lesson;
import fr.lamphi.api.LessonRessource;

@WebServlet(name = "addLessonServlet", urlPatterns = { "/AddLesson" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class AddLesson extends HttpServlet {

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Lesson lesson = new Lesson(request.getParameter("title"),  "",request.getParameter("contenu"), 1, "L'auteur du CUL !", ""+System.currentTimeMillis(), false);
		
		LessonRessource lr = new LessonRessource();
		lr.createLesson(lesson);
		
		response.sendRedirect("index.jsp");
	}
}
