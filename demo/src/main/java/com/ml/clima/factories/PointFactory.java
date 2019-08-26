package com.ml.clima.factories;

import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Planet;
import com.ml.clima.model.Point;
import com.ml.clima.utils.CalculationUtils;

public class PointFactory {
	
	public static Point createPoint(Planet planet, DayWeather day) {	
		Point point = new Point();
		point.setPlanet(planet);
		point.setDay(day);
		Long angle = day.getDay() * planet.getAngularVelocity();
		CalculationUtils.calculatePositionPoint(point, planet.getDistanceFromSun(), angle);
		return point;	
	}

}
