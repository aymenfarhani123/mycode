package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestingHibernateHQLDump {
	
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/testdb");
		cfg.configure("resources/hibernate-cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        //String HQLQuery="insert into DumpEtudiant (id, name,email,dateDeNaissance) select e.id, e.name, e.email, e.dateDeNaissance from Etudiant e";
      String HQLQuery="select avg(id) from DumpEtudiant";
        Query q= session.createQuery(HQLQuery);
       double i=(double) q.uniqueResult();
       transaction.commit();
     
    	   System.out.println(i);
        session.close();
        sf.close();
        }
	
}
