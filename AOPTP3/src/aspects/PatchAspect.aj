package aspects;

import metier.Compte;

public aspect PatchAspect {

	pointcut patch(double montant) : call(* metier..Compte.retirer(..)) && args(montant);
	
	void around(double montant) : patch(montant) {
		Compte compte=(Compte) thisJoinPoint.getTarget();
		if(montant< compte.getSolde()) {
			proceed(montant);
		}
		else {
			throw new RuntimeException("Solde insuffisant: "+montant);
		}
		
	}
}
