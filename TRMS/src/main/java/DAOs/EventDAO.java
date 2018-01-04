package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utility.ConnectionSingleton;
import beans.Event;

public class EventDAO {
	
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<>();
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
				
				Event e = new Event(id, type, reimPercent);
				
				events.add(e);
			}
			result.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException occured: "+e);
		}
		
		return events;
	}

}
