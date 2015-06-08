package fr.lamphi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.lamphi.api.User;

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
				session.setAttribute("user", new User(1, "CHAVAL", "Clément", "etu", "cchaval", "clement.chaval@free.fr", "proutprout", "M"));
			else if(status.equals("prof"))
				session.setAttribute("user", new User(1, "CLAVIER", "Thomas", "prof", "tclavier", "thomas.clavier@univ-lille1.fr", "proutprout", "M"));
		} else if(deconnect) {
			session.invalidate();
		}
		response.sendRedirect("index.jsp");
	}
}
