package com.ml.clima.utils;

import com.ml.clima.model.Point;

public class CalculationUtils {
	
	private CalculationUtils() {}
	
	public static void calculatePositionPoint(Point point, Integer distanceFromSun, Long angle) {
		point.setX((double) Math.round(distanceFromSun * (Math.cos(Math.toRadians(angle)))*100)/100);
		point.setY((double) Math.round(distanceFromSun * (Math.sin(Math.toRadians(angle)))*100)/100);		
	}
	
	
	public static Boolean isAligned(Point p1, Point p2,Point p3, Point p4) {
		double x1 = p1.getX(); 
		double x2 = p2.getX();
		double x3 = p3.getX();
		double x4 = p4.getX();
		
		double y1 = p1.getY();
		double y2 = p2.getY();
		double y3 = p3.getY();
		double y4 = p4.getY();
		
		if ((x1 == 0 && x2 == 0 && x3 == 0 && x4 == 0) || (y1 == 0 && y2 == 0 && y3 == 0 && y4 == 0)){
			return true;
		}
		
		if (((x1-x2)/(x2-x3) == (y1-y2)/(y2-y3)) && ((x2-x3)/(x3-x4) == (y2-y3)/(y3-y4))) {
			return true;
		}
		return false;
	}
	
	public static Boolean isAlignedWithoutSun(Point p1, Point p2,Point p3, Point p4) {
		double x1 = p1.getX(); 
		double x2 = p2.getX();
		double x3 = p3.getX();
		double x4 = p4.getX();
		
		double y1 = p1.getY();
		double y2 = p2.getY();
		double y3 = p3.getY();
		double y4 = p4.getY();
		
		if ((x1 == 0 && x2 == 0 && x3 == 0 && x4 == 0) || (y1 == 0 && y2 == 0 && y3 == 0 && y4 == 0)){
			return false;
		}
		
		if (((x1-x2)/(x2-x3) == (y1-y2)/(y2-y3)) && ((x2-x3)/(x3-x4) != (y2-y3)/(y3-y4))) {
			return true;
		}
		return false;
	}

}
