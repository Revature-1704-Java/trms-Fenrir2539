package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utility.ConnectionSingleton;
import beans.Event;

public class EventDAO {
	
	public Map<Integer, Integer> getAllEvents() {
		Map<Integer, Integer> events = new HashMap<>();
		ResultSet result;
		
		//Creation of the statement instance 
		ConnectionSingleton single = ConnectionSingleton.getInstance();
		Statement state = ConnectionSingleton.getStatement();
		// put your SQL code in the variable sqlString
		String sqlString = "SELECT * FROM EVENT" ;
		try {
			result = state.executeQuery(sqlString);
			while (result.next()) {
				int id = result.getInt("EVENTID");
				String type =  result.getString("EVENT_TYPE");
				int reimPercent =  result.getInt("REIM_PERCENT");
				
				events.put(id, reimPercent);
			}
			result.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException occured: "+e);
		}
		
		return events;
	}

}
