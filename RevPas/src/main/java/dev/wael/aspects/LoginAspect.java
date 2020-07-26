package dev.wael.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {

	public LoginAspect() {
		// TODO Auto-generated constructor stub
	}

	private int counter = 0;

	@Before("logJP()") // we have to define the join point
	public void logInf() {
		System.out.println("total calls = " + ++counter);
	}

	@Pointcut("execution(* dev.wael.controllers.AssociateController.*(..)) ")
	private void logJP() {

	}
	
	 
}
