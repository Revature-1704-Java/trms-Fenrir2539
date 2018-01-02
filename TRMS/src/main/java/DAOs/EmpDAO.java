package DAOs;

import java.util.ArrayList;
import java.util.List;

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
		return reimFunds;
	}
	
	/**
	 */ 
	public Employee getEmployee(int eid) {
		Employee anEmployee = null;
		return anEmployee;
	}
	
	/**
	 */ 
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		return employees;
	}
}
