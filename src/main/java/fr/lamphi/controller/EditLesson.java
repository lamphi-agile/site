package fr.lamphi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lamphi.api.lesson.Lesson;
import fr.lamphi.api.lesson.LessonDBRessource;
import fr.lamphi.api.lesson.LessonRessource;
import fr.lamphi.api.user.User;

@WebServlet(name = "editLessonServlet", urlPatterns = { "/EditLesson" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class EditLesson extends HttpServlet {

	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


        User user = (User)request.getSession().getAttribute("user");
        
        int lessonId = (int)request.getSession().getAttribute("lessonUpdateId");
        if(user == null)
			response.sendRedirect("register.jsp");
        
        Lesson lesson = new Lesson(lessonId,request.getParameter("title"), request.getParameter("contenu"), user.getId(), ""+System.currentTimeMillis(),1, false,0,0);


        System.out.println(lesson);
        LessonDBRessource lr = new LessonDBRessource();
        lr.updateLesson(lesson);
       
        response.sendRedirect("index.jsp");
	}
}
