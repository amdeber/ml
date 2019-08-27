package com.ml.clima.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.ml.clima.dao.day.DayWeatherDao;
import com.ml.clima.dao.planet.PlanetDao;
import com.ml.clima.dao.point.PointDao;
import com.ml.clima.factories.PlanetFactory;
import com.ml.clima.factories.PointFactory;
import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Planet;
import com.ml.clima.model.Point;
import com.ml.clima.services.interfaces.IWeatherCreatorService;
import com.ml.clima.utils.CalculationUtils;
import com.ml.clima.utils.DayUtils;

@Service
public class WeatherCreatorService implements IWeatherCreatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherCreatorService.class);

	@Autowired
	DayWeatherDao dayWeatherDao;

	@Autowired
	PlanetDao planetDao;

	@Autowired
	PointDao pointDao;

	public void createInicialDays() {
		createAllPlanetAndPoint();
		setInitialWeatherDay();
	}

	public void createDateWeatherList() {

	}

	private void setWeaterToDay(DayWeather dateWeather, Point ferengiPoint, Point betasoidePoint,
			Point vulcanoPoint) {
		if (CalculationUtils.isAligned(ferengiPoint, betasoidePoint, vulcanoPoint, getOriginPoint())) {
			dateWeather.setWeather("SEQUIA");
		}else {
			dateWeather.setWeather("LLUVIA");
		}
	}

	private Point getOriginPoint() {
		return new Point(Double.valueOf(0.0), Double.valueOf(0.0));
	}

	private void createAllPlanetAndPoint() {
		List<Planet> planets = PlanetFactory.createPlanets();
		LOGGER.info("Finish create planet. Total planets: " + planets.size());
		planets.forEach(p -> {
			planetDao.createFlush(p);
		});
		Long days = getInicialDays();
		List<DayWeather> resutlDays = new ArrayList<>();
		createDayForPlanets(planets, days);
		LOGGER.info("Finish create days without weather. Total days: " + days);
		LOGGER.info("Finish create point. Total point: " + pointDao.countFindAll());
	}

	private void createDayForPlanets(List<Planet> planets, Long days) {
		planets.forEach(p -> {
			IntStream.range(0, Integer.valueOf(days.toString())).forEach(day -> {
				createDayAndTheirPoints(p, day);
				LOGGER.debug("Point create");
			});
		});
	}

	private void createDayAndTheirPoints(Planet p, int day) {
		Long dayLong = Long.valueOf(day);
		DayWeather dayWeather = dayWeatherExist(dayLong) ? dayWeatherDao.getFindByDay(dayLong)
				: createDayWeather(dayLong);
		Point point = PointFactory.createPoint(p, dayWeather);
		List<Point> points = dayWeather.getPoints() != null ? dayWeather.getPoints() : new ArrayList<>();
		dayWeather.setPoints(points);
		dayWeather.getPoints().add(point);
		pointDao.createFlush(point);
		dayWeatherDao.updateFlush(dayWeather);
	}

	private void setInitialWeatherDay() {
		List<DayWeather> days = dayWeatherDao.findAll();
		days.forEach(wd -> {
			setWeatherForOneDay(wd);
		});
		LOGGER.info("Finish create days with weather. Total days: " + days.size());
		LOGGER.info("Finished initialization process");
	}

	private void setWeatherForOneDay(DayWeather wd) {
		Map<String, Point> map = wd.getPoints().stream()
				.collect(Collectors.toMap(Point::getNamePlanet, Point -> Point));
		setWeaterToDay(wd, map.get(PlanetFactory.FERENGI), map.get(PlanetFactory.BETASOIDE),
				map.get(PlanetFactory.VULCANO));
		dayWeatherDao.updateFlush(wd);
		LOGGER.debug("Point update");
	}

	private Long getInicialDays() {
		return DayUtils.getInstance().getQDaysBetweenDateAndYears(LocalDateTime.now(), Long.valueOf(10));

	}

	private boolean dayWeatherExist(Long day) {
		return dayWeatherDao.countByDay(day) > 0;
	}

	private DayWeather createDayWeather(Long day) {
		DayWeather dw = new DayWeather(day);
		return dayWeatherDao.createFlush(dw);
	}
	
	public void createWeatherForSpecificDay(){
		Long lastDay = dayWeatherDao.getMaxDay();
		List<Planet> planets = planetDao.findAll();
		createDayForPlanets(planets, lastDay);
		DayWeather dw = dayWeatherDao.getFindByDay(lastDay + 1);
		setWeatherForOneDay(dw);
		LOGGER.info("Weather created for day: " + dw.getDay().toString());
	}
	
	

}
