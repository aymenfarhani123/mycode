package business;

public class AccountNotFoundException extends RuntimeException {
	
	@Override
	public String toString() {
		return "Account number invalid";
	}

}
