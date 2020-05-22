package Models;

public class HEmployee extends Employee{
	private String wh;
	
	public HEmployee() {
	}

	public HEmployee(int id, String name, String email, double salary, String wh) {
		super(id, name, email, salary);
		this.wh = wh;
	}

	public String getWh() {
		return wh;
	}

	public void setWh(String wh) {
		this.wh = wh;
	}

	
	

}
