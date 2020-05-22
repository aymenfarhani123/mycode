package beans;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Etudiant implements InitializingBean , DisposableBean{

	private String name;
	private Date dateDeNaissance;
	@Inject
	private Departement departement;
	private Addresse addresse;
	private University university;
	private Properties[] hobbies;
	private List<Integer> note;
	private Set<String> matieres;
	private Map<String, String> emploi;

	public Etudiant(String name) {
		super();
		this.name = name;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(Properties[] hobbies) {
		this.hobbies = hobbies;
	}

	public Addresse getAddresse() {
		return addresse;
	}

	@Inject
	@Qualifier("addresse1")
	//@Autowired(required = false)
	public void setAddresse(Addresse addresse) {
		this.addresse = addresse;
	}

	public List<Integer> getNote() {
		return note;
	}

	public void setNote(List<Integer> note) {
		this.note = note;
	}

	public Set<String> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<String> matieres) {
		this.matieres = matieres;
	}

	public Map<String, String> getEmploi() {
		return emploi;
	}

	public void setEmploi(Map<String, String> emploi) {
		this.emploi = emploi;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties Set");
	}

	public void init() {
		System.out.println("Methode d'initialization");
	}

	@Override
	public void destroy() {
		System.out.println("Methode clean up!");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Post Construct");
	}

}
