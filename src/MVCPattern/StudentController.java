package MVCPattern;

public class StudentController {
	private Student studentModel;
	private StudentView studentView;

	public StudentController(Student studentModel, StudentView studentView) {
		super();
		this.studentModel = studentModel;
		this.studentView = studentView;
	}
	
	public void setStudentName(String name) {
		studentModel.setName(name);
	}

	public Student getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(Student studentModel) {
		this.studentModel = studentModel;
	}

	public StudentView getStudentView() {
		return studentView;
	}

	public void setStudentView(StudentView studentView) {
		this.studentView = studentView;
	}

	public void updateView() {
		studentView.printStudentDetails(studentModel.getName(), studentModel.getRollNo());
	}

}
