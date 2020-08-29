package business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Bank {
	
	private int amount=5000;
	private String accountNumber="sib123";
	
	public int deposite(int amount, String accountNumber) {
		if(this.accountNumber.equals(accountNumber)) {
			Log log=LogFactory.getLog(Bank.class);
			log.info("in deposite method...");
			this.amount += amount;
			return this.amount;
		}
		else {
			throw new AccountNotFoundException();
		}
	}

}
