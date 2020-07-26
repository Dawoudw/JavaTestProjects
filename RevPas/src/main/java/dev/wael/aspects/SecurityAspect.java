package dev.wael.aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.bytebuddy.implementation.bind.annotation.Pipe;

@Component
@Aspect
public class SecurityAspect {

	@Around("securityJP()") 
	// advice method
	public Object authenticate(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();

		String auth = request.getHeader("Authorization");

		if (null != auth && auth.equals("Pass")) {
			Object obj = pjp.proceed();
			return obj;

		} else
			response.sendError(401);

		return null;
	}

	@Pointcut("@annotation(dev.wael.aspects.Authorized)")
	private void securityJP() {
	};
}
