package io.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import io.spring.intrface.Shape;

@Component
public class Triangle implements Shape {

	/*
	 * Triangle has three different Point object properties for the three vertices
	 */
	private Point pointOne;
	private Point pointTwo;
	private Point pointThree;
	
	@Override
	public void draw() {
		System.out.println("Triangle Drawn");
		System.out.println("point1: ("+getPointOne().getX()+","+getPointOne().getY()+")");
		System.out.println("point2: ("+getPointTwo().getX()+","+getPointTwo().getY()+")");
		System.out.println("point3: ("+getPointThree().getX()+","+getPointThree().getY()+")");}

	public Point getPointOne() {
		return pointOne;
	}
	
	@Autowired
	@Qualifier(value="point1")
	public void setPointOne(Point pointOne) {
		this.pointOne = pointOne;
	}

	public Point getPointTwo() {
		return pointTwo;
	}
	
	@Autowired
	public void setPointTwo(Point pointTwo) {
		this.pointTwo = pointTwo;
	}

	public Point getPointThree() {
		return pointThree;
	}
	
	@Autowired
	public void setPointThree(Point pointThree) {
		this.pointThree = pointThree;
	}

	@Override
	public String draw(String name) {
	return name;
		
	}

}
