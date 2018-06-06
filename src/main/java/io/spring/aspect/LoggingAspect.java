package io.spring.aspect;

import java.util.logging.LoggingMXBean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import io.spring.model.Circle;
import io.spring.model.Point;

@Aspect
@Component
public class LoggingAspect {
	
	@AfterReturning(pointcut="args(String)" ,returning="name")
	public void BeforeAdvice(String name) {
		System.out.println(name);
		System.out.println("@AfterReturning Execution Advice executed");
	}
	
	@AfterThrowing(pointcut="args(String)" ,throwing="ex")
	public void BeforeAdvice(RuntimeException ex) {
		System.out.println(ex);
		System.out.println("@AfterThrowing Execution  Advice executed");
	}
	
	//@Around("withinCircle() && draw()")
	@Around("@annotation(io.spring.aspect.DrawAnnotation)")
	public void aroundAdvice(ProceedingJoinPoint pjp) {
		System.out.println("___this sop is just before the target method execution___");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("__this sop is right after method has been executed__");
	}
	
	@Pointcut("within(io.spring.model.Circle)")
	public void withinCircle() {}
	
	@Pointcut("execution(* draw())")
	public void draw() {}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	
}
