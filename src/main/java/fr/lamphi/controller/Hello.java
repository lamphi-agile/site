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

@WebServlet(name = "testServlet", urlPatterns = { "/hello" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class Hello extends HttpServlet {

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Lesson lesson = new Lesson("La lesson du "+ System.currentTimeMillis(), 1, "Test", ""+System.currentTimeMillis(), false);
		
		LessonRessource lr = new LessonRessource();
		lr.createLesson(lesson);
		
		response.sendRedirect("index.jsp");
	}
}
