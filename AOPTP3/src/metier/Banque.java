package metier;

import java.util.Scanner;

public class Banque {

	public static void main(String[] args) {
		new Banque().init();

	}

	
	public void init() {
		try {
			Scanner clavier=new Scanner(System.in);
			int code=clavier.nextInt();
			Compte compte=new Compte();
			compte.setCode(code);
			while(true) {
				System.out.println("Monatant à verser: ");
				double montantVerser=clavier.nextDouble();
				compte.verser(montantVerser);
				System.out.println("Monatant à retirer: ");
				double montantRetirer=clavier.nextDouble();
				compte.retirer(montantRetirer);
				System.out.println(compte.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
