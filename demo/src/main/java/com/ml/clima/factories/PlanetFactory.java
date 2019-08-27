package com.ml.clima.factories;

import java.util.ArrayList;
import java.util.List;
import com.ml.clima.model.Planet;

public class PlanetFactory {
	
	
	public static String FERENGI = "Ferengi";
	public static String BETASOIDE = "Betasoide";
	public static String VULCANO = "Vulcano";
	
	private static Planet createPlanet(String name, Long angularVelocity, Integer distanceFromSun) {	
		Planet planet = new Planet();
		planet.setName(name);
		planet.setAngularVelocity(angularVelocity);
		planet.setDistanceFromSun(distanceFromSun);
		return planet;	
	}
		
	public static List<Planet> createPlanets(){
		List<Planet> planets = new ArrayList<>();
		planets.add(createPlanet(FERENGI,  Long.valueOf(1),  Integer.valueOf(500)));
		planets.add(createPlanet(BETASOIDE,  Long.valueOf(3),  Integer.valueOf(2000)));
		planets.add(createPlanet(VULCANO,  Long.valueOf(5),  Integer.valueOf(1000)));
		return planets;
	}
	
}
