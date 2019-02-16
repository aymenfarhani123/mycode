import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@ViewScoped
public class MyController {
	private List<Students> students = new ArrayList<Students>();
	Students selectedStudent = new Students();
	List<Students> selectedStudents;
	DBConnection dbc = new DBConnection();

	public List<Students> getStudents() {
		students = dbc.allstudents();
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public DBConnection getDbc() {
		return dbc;
	}

	public void setDbc(DBConnection dbc) {
		this.dbc = dbc;
	}

	public Students getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Students selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public List<Students> getSelectedStudents() {
		return selectedStudents;
	}

	public void setSelectedStudents(List<Students> selectedStudents) {
		this.selectedStudents = selectedStudents;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Student select", ((Students) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage("Détails", msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Student unselect", ((Students) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage("Détails", msg);
	}

	public void deleteStudent(Students s) {
		getStudents().remove(s);
	}

}
