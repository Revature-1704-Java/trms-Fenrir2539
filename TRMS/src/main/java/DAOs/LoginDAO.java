package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Utility.ConnectionSingleton;

public class LoginDAO {
	
	/**
	 * Retrieves a map of user names and passwords
	 * user name is the key to the value password
	 * 
	 * 
	 * @return
	 */
	public HashMap<String, Integer> getUserandPassword() {
		HashMap<String, Integer> userPassMap = new HashMap<String, Integer>();
		ResultSet result;
		
		//Creation of the statement instance 
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		if (single == null) {
			System.out.println("null singleton");
		}
		Statement state = ConnectionSingleton.getStatement();
		// put your SQL code in the variable sqlString
		if (state == null) {
			System.out.println("null state");
		}
		String sqlString = "SELECT * FROM LOGIN" ;
		try {
			result = state.executeQuery(sqlString);
			while (result.next()) {
				int id = result.getInt("EMPLOYEEID");
				String userName =  result.getString("USERNAME");
				String pass =  result.getString("PWORD");
				
				userPassMap.put(userName+pass, id);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return userPassMap;
	}
}
