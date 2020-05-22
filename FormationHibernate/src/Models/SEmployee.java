package Models;

public class SEmployee extends Employee {
	private String tool;

	public SEmployee() {
	}

	public SEmployee(int id, String name, String email, double salary, String tool) {
		super(id, name, email, salary);
		this.tool = tool;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

}
