package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.LoginDAO;

/**
 * Servlet implementation class Servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("errorMessage") != null) {
			//Wrong login
		}
		/*
		HttpSession session = request.getSession();
		//Dao to get usernames/pass
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
		/*
		if(<check valid> && <pass valid>) {
			session.setAttribute("id", <value>);
			response.sendRedirect("WelcomeServlet');
			
			//Remeber seesions data is an object! Must cast
			//(int)session.getAttribute("id")
		}
		else {
			response.sendRedirect("LoginServlet");
		}
		*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet posting");
		String userName = request.getParameter("userName");
		String password = request.getParameter("passWord");
		HttpSession session = request.getSession();
		
		//Try to get user names
		LoginDAO loginDAO = new LoginDAO();
		HashMap<String, Integer> userPassMap = loginDAO.getUserandPassword();
		if (userPassMap.containsKey(userName+password)) {
			//Valid Login... Do stuff
			int eid = userPassMap.get(userName+password);
			session.setAttribute("eid", eid);
			System.out.println("Your login: " +userName + password);
			System.out.println("Your eid: " +eid);
			response.sendRedirect("resources/views/createReim.html");
			
		}
		else {
			//Invalid Login
			request.getSession().setAttribute("errorMessage", "Invalid Login");
			response.sendRedirect("index.html");
		}
			
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<p>Your name is: ");
		out.println(userName + " " + password + "</p>");
		for (String name: userPassMap.keySet()){
            String key =name.toString();
            String value = userPassMap.get(name).toString();  
            out.println("<p>"+key + " " + value+"</p>");
		} 
		out.close();
		*/
		
	}

}
