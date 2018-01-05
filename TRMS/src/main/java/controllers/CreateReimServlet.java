package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.EmpDAO;
import DAOs.EventDAO;
import DAOs.ReimDAO;
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
		int eventType = Integer.parseInt(request.getParameter("event"));
		int gradeType = Integer.parseInt(request.getParameter("grade"));
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
		//Get an employee's reimFunds
		double[] reimFunds = eDAO.getReimFunds(eid);
		//Get events to see reim percentage
		Map<Integer, Integer> events = new HashMap<>();
		EventDAO eventDao = new EventDAO();
		events = eventDao.getAllEvents();
		int reimPercent = events.get(eventType);
		//possible reimAmount
		double reimAmount = empCost * reimPercent;
		//Check
		double avail = reimFunds[0];
		double pend = reimFunds[1];
		double award = reimFunds[2];
		//Deny if not enough money
		if (reimAmount > avail) {
			//Deny logic
		}
		else {
			//update empReimFunds
			
			//insert Reim
			Reimbursement newReim = new Reimbursement(1 , eid, eventDate, eventType, gradeType, passGrade, 
					empCost, reimAmount, location, description, Double.parseDouble(workHours), just);
			
			//Move to reim Display
			
		}
		
		ReimDAO reimDAO = new ReimDAO();
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		reimbursements = reimDAO.getAllReimbursements(1);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		for (Reimbursement r: reimbursements) {
			out.println(r);
		}
		out.close();
		response.sendRedirect("resources/views/reimbursements.html");
		
		//Create Reim
		
		
		//Insert Reim
		
		
		
	}

}
