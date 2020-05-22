package Models;

public class Admin extends Employee{
	private String branchname;
	
	public Admin() {
	}

	public Admin(int id, String name, String email, double salary, String branchname) {
		super(id, name, email, salary);
		this.branchname=branchname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	
	
	
	
}
