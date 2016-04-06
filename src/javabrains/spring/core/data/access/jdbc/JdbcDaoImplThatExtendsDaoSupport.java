package javabrains.spring.core.data.access.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoImplThatExtendsDaoSupport extends JdbcDaoSupport {
	
	public int getCircleCount(){
		String sql = "select count(*) from circle;";
		return getJdbcTemplate().queryForObject(sql, null, Integer.class);
	}
}
