package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utility.ConnectionSingleton;
import beans.Reimbursement;

public class ReimDAO {

	public List<Reimbursement> getAllReimbursements(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		ResultSet result;
		//Get Connection
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		Statement state = ConnectionSingleton.getStatement();
		//Make Query
		String sqlString = "SELECT * FROM REIMBURSEMENT";
		try {
			result = state.executeQuery(sqlString);
			while (result.next()) {
				int rid = result.getInt("REIMID");
				int eid = result.getInt("EMPLOYEEID");
				String date =  result.getString("EVENTDATE");
				int eventId = result.getInt("EVENTID");
				int gradeId = result.getInt("GRADEID");
				String passGrade = result.getString("PASSINGGRADE");
				double empCost = result.getDouble("EMPLOYEE_COST");
				double reimAmount = result.getDouble("REIM_AMOUNT");
				String location = result.getString("REIM_LOCATION");
				String desc = result.getString("REIM_DESCRIPTION");
				double hoursMissed = result.getDouble("WORK_HOURS_MISSED");
				String status = result.getString("REIM_LOCATION");
				Reimbursement aReim = new Reimbursement(rid, eid, date, eventId, gradeId, passGrade, 
						empCost, reimAmount, location, desc, hoursMissed, status);
				reimbursements.add(aReim);
			}
			result.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException occured: "+e);
		}
		return reimbursements;
	}
	
	public boolean insertReimbursement(Reimbursement r) {
		PreparedStatement ps = null;
		int result;
		Reimbursement reimbursement = null;
		boolean insertWorked = false;
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		Statement state = ConnectionSingleton.getStatement();
		//Make Query
		String sqlString = "INSERT INTO REIMBURSEMENT VALUES(";
		try {
			sqlString += r.getReimId() +", ";
			sqlString += r.getEmpId() +", ";
			//date
			String dateStr = r.getEventDate();
			java.util.Date date = new Date();
			 String expectedPattern = "MM/dd/yyyy";
			    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
			    try
			    {
			      date = formatter.parse(dateStr);
			    }
			    catch (ParseException e)
			    {
			      e.printStackTrace();
			    }
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			sqlString += sqlDate +", ";
			sqlString += r.getEventId() +", ";
			sqlString += r.getGradeId() +", ";
			sqlString += r.getPassingGrade() +", ";
			sqlString += r.getEmpCost() +", ";
			sqlString += r.getReimAmount() +", ";
			sqlString += r.getLocation() +", ";
			sqlString += r.getDescription() +", ";
			sqlString += r.getWorkHoursMissed() +", ";
			sqlString += r.getStatus() +")";
			result = state.executeUpdate(sqlString);
			
			if (result != 0) {
				System.out.println("Reimbursement submitted");
	            insertWorked = true;
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return insertWorked;
	}
}
