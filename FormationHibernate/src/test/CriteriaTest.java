package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;

import Models.Etudiant;

public class CriteriaTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/testdb");
		cfg.configure("resources/hibernate-cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria cr = session.createCriteria(Etudiant.class);
//		Criterion criterion = Restrictions.gt("id", 3);
//		cr.add(criterion);
		PropertyProjection pn=Projections.property("name");
		PropertyProjection pe=Projections.property("email");
		ProjectionList pl=Projections.projectionList();
		pl.add(pn);
		pl.add(pe);
		
		cr.setProjection(pl);
		List<Object[]> etudiants=cr.list();
		for(Object[]  e:etudiants) {
			System.out.println(e[0]+" : "+e[1]);
		}
		
		Criteria cr1=session.createCriteria(Etudiant.class);
		Projection pro=Projections.sum("id");
		cr1.setProjection(pro);
		long avgid=(long)cr1.uniqueResult();
		System.out.println(avgid);
		
		
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
