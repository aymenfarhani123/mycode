package BusinessDelegatePattern;

public class BusinessLokup {
	
	public BusinessService getBusinessService(String serviceType) {
		if(serviceType.equalsIgnoreCase("EJB")) {
			return new EJBService();
		}
		return new JMSService();
	}

}
