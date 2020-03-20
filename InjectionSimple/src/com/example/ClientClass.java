package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientClass {

	public static void main(String[] args) {
		//le scope d'un bean par defaut est un singleton
		Resource r=new ClassPathResource("spring.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		Test t=(Test) factory.getBean("t");
		t.hello();
		
		
		Object o1= factory.getBean("t");
		Object o2= factory.getBean("t");
		Object o3= factory.getBean("t");
		System.out.println(o1==o2);
		System.out.println(o2==o3);
		System.out.println(o1==o3);
	}

}
