package BusinessDelegatePattern;

public class Client {
	
	BusinessDelegate businessDelegate;

	public Client(BusinessDelegate businessDelegate) {
		super();
		this.businessDelegate = businessDelegate;
	}
	
	
	public void doTask() {
		businessDelegate.doTask();
	}

}
