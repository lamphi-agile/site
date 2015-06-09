package fr.lamphi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.lamphi.api.user.User;
import fr.lamphi.api.user.UserResource;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String status = request.getParameter("status");
		boolean deconnect = request.getParameter("deconnect")==null?false:true;
		if(status != null) {
			if(status.equals("etu"))
				session.setAttribute("user", new UserResource().getUser(1));
			else if(status.equals("prof"))
				session.setAttribute("user", new UserResource().getUser(2));
		} else if(deconnect) {
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}
}
