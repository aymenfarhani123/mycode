package test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Etudiant;

public class TestInjection {

	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("resources/beans.xml");
		Etudiant etudiant = (Etudiant) context.getBean("etudiant");
		System.out.println("============Le constructeur======================");
		System.out.println(etudiant.getName() +" "+etudiant.getDateDeNaissance());// le bean renommé avec le namespace p
		System.out.println("============L'University est une autre bean injectée dans étudiant======================");
		System.out.println(etudiant.getUniversity().getName());
		System.out.println("============La parent de la classe étudiant======================");
		System.out.println(etudiant.getClass().getSuperclass().getName());
		System.out.println("============Le Departement est une autre bean injectée dans étudiant======================");
		System.out.println(etudiant.getDepartement().getName());
		System.out.println("============L'addresse est une autre bean injectée dans étudiant======================");
		System.out.println(etudiant.getAddresse().getStreetName());
		System.out.println(etudiant.getAddresse().getStreetNumber());
		List<Integer> notes = etudiant.getNote();
		System.out.println("============La liste des notes======================");
		System.out.println(notes);

		Properties[] hobbies = etudiant.getHobbies();
		System.out.println("============Le tableau des favoris======================");
		for (int i = 0; i < hobbies.length; i++) {
			System.out.println(hobbies[i]);
		}
		Set<String> matiers = etudiant.getMatieres();
		System.out.println("============Le set des matiers======================");
		System.out.println(matiers);
		Map<String, String> emplois = etudiant.getEmploi();
		System.out.println("============Le map d'emploi======================");
		System.out.println(emplois);
		System.out.println("================Tester le scope prototype===========");
		Etudiant etudiant2 = (Etudiant) context.getBean("etudiant");
		System.out.println(etudiant.equals(etudiant2));// retourne false car le conteneur de spring construit un objet à
														// chaque demande
		// si on affiche les hashcode des deux objets ça doit etre differents
		System.out.println(
				"================On affiche les hashcodes pour voir la différence entre les deux objets===========");
		System.out.println(etudiant.hashCode() + "========" + etudiant2.hashCode());
		
		
		((AbstractApplicationContext)context).registerShutdownHook();
	}

}
