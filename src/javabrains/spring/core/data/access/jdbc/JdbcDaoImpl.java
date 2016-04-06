package javabrains.spring.core.data.access.jdbc;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/*public Circle getCircle(int circleId){
		
		Connection connection = null;
		Circle circle = null;
		try{
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabrains", "root", "snaggle1tea");
			
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement("select name from circle where id = ?");
			ps.setInt(1, circleId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				circle = new Circle(circleId,rs.getString("name"));
			}
			
			ps.close();
			rs.close();
					
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return circle;
	}*/

	public int getCircleCount(){
		String sql = "select count(*) from circle;";
		return jdbcTemplate.queryForObject(sql, null, Integer.class);
	}

	public String getCircleName(int circleId){
		String sql = "select name from circle where id = ?";
		Integer [] args = new Integer[]{circleId};
		return jdbcTemplate.queryForObject(sql, args, String.class);
	}
	
	public Circle getCircleForId(int circleId){
		String sql = "select id, name from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[]{circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		String sql = "select id, name from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.dataSource = dataSource; //not needed.  used by getCircle
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*public void insertCircle(Circle circle){
		String sql = "insert into circle (id,name) values (?,?)";
		Object [] args = new Object[]{circle.getId(),circle.getName()};
		this.jdbcTemplate.update(sql, args);
	}*/
	
	public void insertCircle(Circle circle){
		String sql = "insert into circle (id,name) values (:id,:name)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	public void createTriangleTable(){
		String sql = "create table triangle (id int primary key, name char(50))";
		this.jdbcTemplate.execute(sql);
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
		
	}
}
