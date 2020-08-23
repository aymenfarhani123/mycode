package test;

public aspect FirstAspect {
	pointcut mainTest() : execution(* *..Application.main(..));
	
	before() : mainTest() {
		System.out.println("***********Aspect***********");
		System.out.println("Avant main");
	}
	
	after() : mainTest(){
		System.out.println("***********Aspect***********");
		System.out.println("Apres main");
	}
}
