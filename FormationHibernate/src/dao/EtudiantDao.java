package dao;

import java.util.List;

import Models.Etudiant;

public interface EtudiantDao {
	
	int saveEtudiant(Etudiant e);
	Etudiant getEtudiantById(int id);
	List<Etudiant> getAllEtudiants();
	int updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
}
