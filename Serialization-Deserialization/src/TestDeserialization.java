import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestDeserialization {
	public static void main(String[] args) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("file.txt"));
			Employee employee=(Employee) ois.readObject();
			System.out.println(employee.id+", "+employee.name);
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
