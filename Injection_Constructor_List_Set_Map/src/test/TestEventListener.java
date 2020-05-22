package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEventListener {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("resources/refreshedBeans.xml");
		
		context.start();
		context.stop();
		context.close();
		context.refresh();
	}

}
