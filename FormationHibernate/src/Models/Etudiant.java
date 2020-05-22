package Models;

import java.util.Date;

import javax.persistence.Id;


public class Etudiant {

	@Id
	
	private int id;
	private String name;
	private String email;
	private Date dateDeNaissance;
	
	
	public Etudiant() {}


	public Etudiant(int id,String name, String email, Date dateDeNaissance) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	
}
