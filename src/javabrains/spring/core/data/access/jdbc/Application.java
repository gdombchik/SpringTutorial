package javabrains.spring.core.data.access.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args []){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc.xml");
		//JdbcDaoImpl dao = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		
		/*Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());
		
		System.out.println(dao.getCircleCount());*/
		
		//System.out.println(dao.getCircleName(1));
		//System.out.println(dao.getCircle(1).getName());
		//System.out.println(dao.getCircleForId(1).getId());
		//System.out.println(dao.getAllCircles().get(0).getId());
		
		//dao.insertCircle(new Circle(2,"second circle"));
		
		//dao.createTriangleTable();
		
		//dao.insertCircle(new Circle(4,"fourth circle"));
		
		//JdbcDaoImplThatExtendsDaoSupport jdbcDaoImplThatExtendsDaoSupport = context.getBean("jdbcDaoImplThatExtendsDaoSupport",JdbcDaoImplThatExtendsDaoSupport.class);
		//System.out.println(jdbcDaoImplThatExtendsDaoSupport.getCircleCount());
		
		HibernateDaoImpl hibernateDaoImpl = context.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(hibernateDaoImpl.getCircleCount());
		
	}
}
