package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateReimServlet
 */
public class CreateReimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventDate = request.getParameter("eventDate");
		String eventType = request.getParameter("event");
		String gradeType = request.getParameter("grade");
		String passGrade = request.getParameter("passGrade");
		String empCost = request.getParameter("empCost");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		String workHours = request.getParameter("workHours");
		String just = request.getParameter("just");
		
		System.out.println(eventDate + " " + eventType + " " + gradeType + " " + passGrade 
				+empCost + " " + location + " " + description + " " + workHours + " " +just);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<p>" +eventDate + " " + eventType + " " + gradeType + " " + passGrade 
				+empCost + " " + location + " " + description + " " + workHours + " " +just +"</p>");
		out.close();
		response.sendRedirect("resources/views/home.html");
		
	}

}
