package services;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import business.Bank;

public class LogMethodInterceptor implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Log log=LogFactory.getLog(Bank.class);
		log.info("Before deposite methode ...");
		Object ret=mi.proceed();
		log.info("After deposite methode ...");
		return ret;
	}

}
