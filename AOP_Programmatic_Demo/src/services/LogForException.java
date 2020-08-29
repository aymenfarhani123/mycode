package services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

import business.Bank;

public class LogForException implements ThrowsAdvice {
	
	public void afterThrowing(Exception e) {
		Log log=LogFactory.getLog(Bank.class);
		log.info("incase of exception ..."+ e.getMessage());
	}

}
