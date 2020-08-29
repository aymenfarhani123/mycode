package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ShapeService;

public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService=(ShapeService) context.getBean("shapeService");
		String nameCircle=shapeService.getCircle().getName();
		String nameTriangle=shapeService.getTriangle().getName();
		System.out.println(nameCircle);
		System.out.println(nameTriangle);
	}

}
