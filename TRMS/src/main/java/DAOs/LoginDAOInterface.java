package DAOs;

import java.util.HashMap;

public interface LoginDAOInterface {
	/**
	 * Retrieves a map of usernames and passwords
	 * 
	 * 
	 * 
	 * @return
	 */
	public HashMap<String,String> getUserandPassword();
}
