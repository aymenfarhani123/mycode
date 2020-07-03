package BusinessDelegatePattern;

public class BusinessDelegate {
	private BusinessLokup businessLokup=new BusinessLokup();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public void doTask() {
		businessService=businessLokup.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}
