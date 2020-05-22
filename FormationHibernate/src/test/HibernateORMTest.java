package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Admin;
import Models.HEmployee;
import Models.SEmployee;

public class HibernateORMTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/testdb");
		cfg.configure("resources/hibernate.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		
		SEmployee sEmployee=new SEmployee(111, "hibernate", "hibernate@gmail.com", 10000, "eclipse");
		HEmployee hEmployee=new HEmployee(222,"ORM","orm@gmail.com",20000,"testing");
		Admin admin=new Admin(333, "administration", "admin@gmail.com", 30000, "master");
		
		session.save(sEmployee);
		session.save(hEmployee);
		session.save(admin);
		transaction.commit();
		session.close();
		sf.close();
	}

}
