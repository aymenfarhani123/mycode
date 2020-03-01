import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {

	public static void main(String[] args) {
		Employee employee=new Employee(1, "Aymen");
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("file.txt");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(employee);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
