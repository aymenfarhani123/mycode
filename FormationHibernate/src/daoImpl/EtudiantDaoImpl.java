package daoImpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Models.Etudiant;
import dao.EtudiantDao;

public class EtudiantDaoImpl implements EtudiantDao {
	private static final Logger LOGGER = Logger.getLogger(EtudiantDaoImpl.class.getName());
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
	EntityManager em = emf.createEntityManager();
	EntityTransaction ent = em.getTransaction();

	@Override
	public int saveEtudiant(Etudiant e) {
		ent.begin();
		em.persist(e);
		ent.commit();
		LOGGER.info("Save etudiant");
		return e.getId();

	}

	@Override
	public Etudiant getEtudiantById(int id) {
		Etudiant e = em.find(Etudiant.class, id);
		LOGGER.info("Recherche etudiant");
		return e;
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		String selectSqlQuery="select * from etudiant";
		Query query=em.createNativeQuery(selectSqlQuery, Etudiant.class);
		@SuppressWarnings("unchecked")
		List<Etudiant> etudiants = (List<Etudiant>) query.getResultList();
		LOGGER.info("Recherche list des etudiants");
		return etudiants;
	}

	@Override
	public int updateEtudiant(Etudiant e) {
		ent.begin();
		em.merge(e);
		ent.commit();
		LOGGER.info("Update etudiant");
		return e.getId();
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		ent.begin();
		em.remove(e);
		LOGGER.info("Delete etudiant");
		ent.commit();
	}

}
