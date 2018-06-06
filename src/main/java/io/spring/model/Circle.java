package io.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import io.spring.aspect.DrawAnnotation;
import io.spring.event.Event;
import io.spring.intrface.Shape;

@Component
public class Circle implements Shape,ApplicationEventPublisher,ApplicationEventPublisherAware {

	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher applicationEventPublisher;
	
	@DrawAnnotation
	public void draw() {
		System.out.println("Circle Drawn");
		//System.out.println("point: ("+getCenter().getX()+","+getCenter().getY()+")");
		//Event e=new Event(applicationEventPublisher);
		//publishEvent(e);
		System.out.println(messageSource.getMessage("circle.drawn", new Object[] {getCenter().getX(),getCenter().getY()}, "Defaut Circle drawn", null));
	}
	
	public String draw(String userName) {
		System.out.println("Circle Drawn for User: "+userName);
		System.out.println(messageSource.getMessage("circle.drawn", new Object[] {getCenter().getX(),getCenter().getY()}, "Defaut Circle drawn", null));
		return userName;
	}
	
/*	public String draw(String userName) {
		System.out.println("Circle Drawn for User: "+userName);
		System.out.println(messageSource.getMessage("circle.drawn", new Object[] {getCenter().getX(),getCenter().getY()}, "Defaut Circle drawn", null));
		int x=2/0;
		return userName;
	}*/

	public Point getCenter() {
		return center;
	}
	
	@Autowired
	@Qualifier(value="point1")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void publishEvent(Object event) {
		System.out.println("Custom Event Published:"+ event);
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher=applicationEventPublisher;
		
	}
}
