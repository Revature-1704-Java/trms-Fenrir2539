package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
