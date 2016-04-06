package java_programming_interviews_exposed_chapter16;

import java.sql.*;

public class Jdbc {	
	
	public Connection connectToDb() {
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabrains", "root", "password");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return connection;
		
	}
}

