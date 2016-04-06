package javabrains.spring.core.understanding.dependency_injection;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.FileSystemResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	/*public static void main(String[] args) {
		Shape triangle = new Triangle();
		//triangle.draw();
		myDrawMethod(triangle);
		
		Shape circle = new Circle();
		//circle.draw();
		myDrawMethod(circle);
	}
	
	public static void myDrawMethod(Shape shape){
		shape.draw();
	}*/
	
	
	/*public static void main(String[] args) {
		Drawing drawing = new Drawing();
		drawing.setShape(new Triangle());
		drawing.drawShape();
		
		Drawing drawing2 = new Drawing();
		drawing2.setShape(new Circle());
		drawing2.drawShape();
	}*/
	
	/*public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();
	}*/
	
	public static void main(String[] args) {
		//notification,aop that beanfactory does not have.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)context.getBean("triangle-alias2");
		triangle.draw();
	}
	
}
