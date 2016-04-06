package java_programming_interviews_exposed_chapter16;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcExecute {
	Jdbc jdbc = new Jdbc();
	Connection connection;
	
	@Test
	public void testConnection(){
		connection = jdbc.connectToDb();
		try {
			assertFalse(connection.isClosed());	
			
			final Statement stmt = connection.createStatement();
			final ResultSet rs = stmt.executeQuery("select id, name from circle where id = 1");
			
			final Map<Integer, String> employeeMap = new HashMap<>();
			
			while (rs.next()) {
				final int employeeNumber = rs.getInt("id");
				final String name = rs.getString("name");
				employeeMap.put(employeeNumber, name);
			}			
			
			final Map<Integer, String> expectedMap = new HashMap<Integer, String>() {{
				put(1, "first circle");
			}};
		
			assertEquals(expectedMap, employeeMap);
			
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
