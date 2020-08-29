package aspects;

import java.util.logging.Logger;

public aspect LoggerAspect {
	
	private Logger logger=Logger.getLogger(this.getClass().getName());
	private long t1, t2;
	
	//pointcut mainBanque() : execution(* *..Banque.main(String[]));
	
	pointcut log() : call(* *.Compte.*(..)) || initialization(metier.Compte.new(..));
	
//	before() : mainBanque() {
//		System.out.println("Before Main Banque");
//	}
//	
//	after() : mainBanque(){
//		System.out.println("After Main Banque");
//	}
	
	before() : log(){
		System.out.println("**********************************");
		logger.info("Avant execution de la methode "+thisJoinPoint.getSignature());
		t1=System.currentTimeMillis();
	}
	
	after() : log(){
		logger.info("Apres execution de la methode "+thisJoinPoint.getSignature());
		t2=System.currentTimeMillis();
		
		logger.info("La duree d'execution de la methode est égal à "+(t2-t1));
		System.out.println("**********************************");
		
		if(thisJoinPoint.getKind().equals("initialization")){
			System.out.println("C'est une initialization!!");
		}
	}

}
