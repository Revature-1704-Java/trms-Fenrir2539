package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class ConnectionSingleton {
	    private static String db_url;
	    private static String db_user;
	    private static String db_password;
	    private static Statement connection;

	    private ConnectionSingleton() {
	    	Properties prop = new Properties(); 
			InputStream in = null;
			try {
				in = new FileInputStream("/TRMS/src/main/resources/connection.properties");
			} catch (FileNotFoundException e) {
				//Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.FATAL, "File does not exist", e);
				System.out.println("connection.properties not found");
			}
			try {
				prop.load(in);
			} catch (IOException e) {
				//Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.FATAL, "Failed to load properties", e);
				System.out.println("loading properties failed");
			}
	    	db_url = prop.getProperty("url");
	        db_user = prop.getProperty("user");
	        db_password = prop.getProperty("password");
	        connection = setConnection();
	    }
	/* Private method charge to set the connection statement*/
	    private static Statement setConnection() {
	        try {
	            String url = "" + db_url;
	            System.out.println("connection: "+db_url+db_user+db_password);
	            java.sql.Connection conn = DriverManager.getConnection(url, db_user, db_password);

	            //Creation of the Statement object
	            java.sql.Statement state = conn.createStatement();
	            return (Statement) state;
	        } catch (SQLException ex) {
	            //Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.FATAL, "Failed to set connection: "+db_url, ex);
	        }
	        return null;
	    }

	/* Private inner class responsible for instantiating the single instance of the singleton */
	    private static class ConnectionSingletonManagerHolder {
	        private final static ConnectionSingleton instance = new ConnectionSingleton();
	    }

	    /**
	     * @return
		 *	Public method, which is the only method allowed to return an instance of 
		 *	the singleton (the instance here is the database connection statement)
	     */
	    public static ConnectionSingleton getInstance() {
	        try {
	            return ConnectionSingletonManagerHolder.instance;
	        } catch (ExceptionInInitializerError ex) {
	        	//Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.FATAL, "Failed to get Instance", ex);
	        	System.out.println("getIstance Failed");
	        }
	        return null;
	    }
	    
	    public static Statement getStatement() {
	        return connection;
	    }
}
