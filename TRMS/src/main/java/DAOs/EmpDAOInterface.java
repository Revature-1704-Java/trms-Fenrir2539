package DAOs;

import java.util.HashMap;

public interface EmpDAOInterface {
	
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
	public double[] getReimFunds(int eid);
	
	
}
