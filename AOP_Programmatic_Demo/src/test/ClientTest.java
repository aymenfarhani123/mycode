package test;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import business.Bank;
import services.LogAfterMethode;
import services.LogBeforeMethode;
import services.LogForException;
import services.LogMethodInterceptor;

public class ClientTest {
 
	public static void main(String[] args) {
		//create Target
//		Bank bank=new Bank();
//		//create Before Method Advice 
//		LogBeforeMethode beforeMethode=new LogBeforeMethode();
//		//create After Method Advice 
//		LogAfterMethode afterMethode=new LogAfterMethode();
//		//create Methode Interceptor
//		LogMethodInterceptor methodInterceptor=new LogMethodInterceptor();
//		//create exception advice
//		LogForException forException=new LogForException();
//		//create ProxyFactoryBean
//		ProxyFactoryBean factoryBean=new ProxyFactoryBean();
//		//Add Target to ProxyFactoryBean
//		factoryBean.setTarget(bank);
//		//Add Advice To ProxyFactoryBean
//		factoryBean.addAdvice(beforeMethode);
//		factoryBean.setInterceptorNames(interceptorNames);
////		factoryBean.addAdvice(afterMethode);
////		factoryBean.addAdvice(methodInterceptor);
////		factoryBean.addAdvice(forException);
		
		ApplicationContext context=new FileSystemXmlApplicationContext("C:\\Users\\h-tech\\Desktop\\cleanCode\\AOP_Delclarative_Demo\\src\\resources\\test.xml");
	    Bank b=(Bank) context.getBean("proxy");
		//		//generated Proxy Object
//		Bank b=(Bank) factoryBean.getObject();
		
		int amount=b.deposite(1200, "sik123");
		System.out.println(amount);

	}

}
