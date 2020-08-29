package aspects;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;

public aspect SecurityAspect {
	private String login;
	private String password;
	
	pointcut security() : call(metier.Banque.new(..));
	
	Object around() : security() {
		if(login == null) {
			Scanner clavier=new Scanner(System.in);
			System.out.println("Login : ");
			String login=clavier.next();
			System.out.println("Password : ");
			String password=clavier.next();
			
			if(("root".equals(login)) && ("root".equals(password))) {
				login="root";
				password="root";
				return proceed();
			}
			else {
				throw new RuntimeException("Accèes refusé :(");
			}
		}
		return null;
	}

}
