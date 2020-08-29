package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import business.Bank;
import services.LogAfterMethode;
import services.LogBeforeMethode;
import services.LogForException;
import services.LogMethodInterceptor;

public class ClientTest {

	public static void main(String[] args) {
		//create Target
		Bank bank=new Bank();
		//create Before Method Advice 
		LogBeforeMethode beforeMethode=new LogBeforeMethode();
		//create After Method Advice 
		LogAfterMethode afterMethode=new LogAfterMethode();
		//create Methode Interceptor
		LogMethodInterceptor methodInterceptor=new LogMethodInterceptor();
		//create exception advice
		LogForException forException=new LogForException();
		//create ProxyFactoryBean
		ProxyFactoryBean factoryBean=new ProxyFactoryBean();
		//Add Target to ProxyFactoryBean
		factoryBean.setTarget(bank);
		//Add Advice To ProxyFactoryBean
		factoryBean.addAdvice(beforeMethode);
		factoryBean.addAdvice(afterMethode);
		factoryBean.addAdvice(methodInterceptor);
		factoryBean.addAdvice(forException);
		//generated Proxy Object
		Bank b=(Bank) factoryBean.getObject();
		
		int amount=b.deposite(1200, "sik123");
		System.out.println(amount);

	}

}
