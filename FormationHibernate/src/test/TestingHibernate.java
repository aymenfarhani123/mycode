package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Etudiant;

public class TestingHibernate {
	
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/testdb");
		cfg.configure("resources/hibernate-cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
//		Etudiant etudiant=new Etudiant();
//		etudiant.setId(9);
//		etudiant.setName("Spring Hibernate");
//		etudiant.setEmail("aymenfarhani28@gmail.com");
//		etudiant.setDateDeNaissance(new Date());
//		//session.remove(etudiant);
//		session.beginTransaction();
//		session.save(etudiant);
//		session.getTransaction().commit();
//		//session.evict(etudiant);
        
        Transaction transaction=session.beginTransaction();
        Etudiant oldEtudiant1=new Etudiant(111,"Aymen","aymenfarhani111@gmail.com",new Date());
        Etudiant oldEtudiant2=new Etudiant(112,"Hibernate","hibernate@gmail.com",new Date());
        Etudiant oldEtudiant3=new Etudiant(113,"HQL","hqlquery28@gmail.com",new Date());
        
        session.save(oldEtudiant1);
        session.save(oldEtudiant2);
        session.save(oldEtudiant3);
        transaction.commit();
        session.close();
        sf.close();
        }
	
}
