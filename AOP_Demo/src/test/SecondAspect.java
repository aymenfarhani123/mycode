package test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecondAspect {
	
	
	
	@Before("execution(* *..Application.main(..))")
	public void avant() {
		System.out.println("Avant...");
	}
	
	@After("execution(* *..Application.main(..))")
	public void apres() {
		System.out.println("Apres...");
	}

}
