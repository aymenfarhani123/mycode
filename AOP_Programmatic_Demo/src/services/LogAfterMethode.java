package services;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

import business.Bank;

public class LogAfterMethode implements AfterReturningAdvice {

	
	
	@Override
	public void afterReturning(Object ret, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Log log=LogFactory.getLog(Bank.class);
		log.info("After deposite methode ..."+ ret);
		
	}

}
