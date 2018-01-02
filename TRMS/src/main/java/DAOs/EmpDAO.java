package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utility.ConnectionSingleton;
import beans.Employee;

public class EmpDAO {

	/**
	 * Retrieves an employee's reimbursement fund data
	 * into an array of doubles with three values
	 * 0 - The amount available
	 * 1 - The amount pending
	 * 2 - The amount awarded
	 * 
	 * @param eid the employee's id
	 * @return the available, pending, and awarded reim funds.
	 */ 
	public double[] getReimFunds(int eid) {
		double[] reimFunds = new double[3];
		ResultSet result;
		//Get Connection
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		Statement state = ConnectionSingleton.getStatement();
		//Make Query
		String sqlString = "SELECT * FROM EMPLOYEE_REIM_FUNDS";
		try {
			result = state.executeQuery(sqlString);
			while (result.next()) {
				double avail = result.getDouble("AMOUNTAVAILABLE");
				reimFunds[0] = avail;
				double pend =  result.getDouble("AMOUNTPENDING");
				reimFunds[1] = pend;
				double award =  result.getDouble("AMOUNTAWARDED");
				reimFunds[2] = award;
				
			}
			result.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException occured: "+e);
		}
		
		return reimFunds;
	}
	
	/**
	 */ 
	public Employee getEmployee(int eid) {
		Employee anEmployee = null;
		ResultSet result;
		//Get Connection
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		Statement state = ConnectionSingleton.getStatement();
		//Make Query
		String sqlString = "SELECT * FROM EMPLOYEE";
		try {
			result = state.executeQuery(sqlString);
			while (result.next()) {
				int id = result.getInt("EMPLOYEEID");
				String firstName =  result.getString("FIRSTNAME");
				String lastName =  result.getString("LASTNAME");
				int employeeType = result.getInt("EMPLOYEETYPEID");
				int deptId = result.getInt("DEPARTMENTID");
				int reportsTo = result.getInt("REPORTSTO");
				anEmployee = new Employee(id, firstName, lastName, employeeType, deptId, reportsTo);
			}
			result.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException occured: "+e);
		}
		return anEmployee;
	}
	
	/**
	 */ 
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		ResultSet result;
		//Get Connection
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		Statement state = ConnectionSingleton.getStatement();
		//Make Query
		String sqlString = "SELECT * FROM EMPLOYEE";
		try {
			result = state.executeQuery(sqlString);
			while (result.next()) {
				int id = result.getInt("EMPLOYEEID");
				String firstName =  result.getString("FIRSTNAME");
				String lastName =  result.getString("LASTNAME");
				int employeeType = result.getInt("EMPLOYEETYPEID");
				int deptId = result.getInt("DEPARTMENTID");
				int reportsTo = result.getInt("REPORTSTO");
				Employee anEmployee = new Employee(id, firstName, lastName, employeeType, deptId, reportsTo);
				employees.add(anEmployee);
			}
			result.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException occured: "+e);
		}
		return employees;
	}
}
