package beans;
//Singleton implementation
public class University {

	private static University university;
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private University() {
	}

	public static University getInstance() {
		if (university == null) {
			university = new University();
		}
		return university;
	}

}
