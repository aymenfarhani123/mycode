import java.io.Serializable;

public class Employee implements Serializable{

	private static final long serialVersionUID = -68439304351268801L;
	int id;
	String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
