package MVCPattern;

public class TestDesignPatternMVC {

	public static void main(String[] args) {

		Student model = retrieveStudentFromDataBase();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);
		controller.updateView();
		
		controller.setStudentName("Aymen");
		
		controller.updateView();

	}

	private static Student retrieveStudentFromDataBase() {
		Student student = new Student();
		student.setName("Design Pattern MVC");
		student.setRollNo("111");
		return student;
	}
}