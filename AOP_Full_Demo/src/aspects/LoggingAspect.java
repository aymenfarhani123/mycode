package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allGetters()")
	public void loggingAdvice() {
		System.out.println("Advice run. Get mathode called! ");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}

}
