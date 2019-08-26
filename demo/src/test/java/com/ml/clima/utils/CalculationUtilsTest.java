package com.ml.clima.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ml.clima.model.Point;

public class CalculationUtilsTest {
	
	@Test
	public void calculate_new_point() {
		Point point = new Point();
		CalculationUtils.calculatePositionPoint(point, 500, Long.valueOf("1"));
		assertEquals(Double.valueOf(499.92), point.getX());
		assertEquals(Double.valueOf(8.73), point.getY());
	}
	
	@Test
	public void calculate_points_align() {	
		Point p1 = new Point(Double.valueOf(0),Double.valueOf(0));
		Point p2 = new Point(Double.valueOf(-1),Double.valueOf(-1));
		Point p3 = new Point(Double.valueOf(1),Double.valueOf(1));
		Point p4 = new Point(Double.valueOf(2),Double.valueOf(2));
		assertTrue(CalculationUtils.isAligned(p1, p2, p3, p4));;	
	}
	
	
	@Test
	public void calculate_points_align_sequia() {	
		Point p1 = new Point(Double.valueOf(0),Double.valueOf(500));
		Point p2 = new Point(Double.valueOf(0),Double.valueOf(1000));
		Point p3 = new Point(Double.valueOf(0),Double.valueOf(2000));
		Point p4 = new Point(Double.valueOf(0),Double.valueOf(0));
		assertTrue(CalculationUtils.isAligned(p1, p2, p3, p4));;	
	}
	
}
