package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.EmpDAO;
import DAOs.EventDAO;
import beans.Event;
import beans.Reimbursement;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int eid = -1;
		if (session.getAttribute("eid") != null) {
			eid = (int) session.getAttribute("eid");
		}
		
		//Get Form Attributes
		String eventDate = request.getParameter("eventDate");
		System.out.println(eventDate);
		String eventType = request.getParameter("event");
		String gradeType = request.getParameter("grade");
		String passGrade = request.getParameter("passGrade");
		Double empCost = Double.parseDouble(request.getParameter("empCost"));
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		String workHours = request.getParameter("workHours");
		String just = request.getParameter("just");
		
		System.out.println(eventDate + " " + eventType + " " + gradeType + " " + passGrade 
				+empCost + " " + location + " " + description + " " + workHours + " " +just);
		
		//Calculate reimAmount using employeeID with EmpDAO
		EmpDAO eDAO = new EmpDAO();
		double[] reimFunds = eDAO.getReimFunds(eid);
		//Find eventType
		EventDAO eventDao = new EventDAO();
		//Maye should do a map instead with key values....
		List<Event> events = new ArrayList<>();
		eventDao.getAllEvents();
		//need event dow to calc %
		double reimAmount = 0.0;
		
		//Create Reim
		Reimbursement newReim = new Reimbursement(1 , eid, eventDate, Integer.parseInt(eventType), Integer.parseInt(gradeType), passGrade, 
				empCost, reimAmount, location, description, Double.parseDouble(workHours), just);
		
		//Insert Reim
		
		response.sendRedirect("resources/views/reimbursements.html");
		
	}

}
