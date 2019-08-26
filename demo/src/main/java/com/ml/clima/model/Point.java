package com.ml.clima.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Point {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Double x;

	@Column(nullable = false)
	private Double y;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "planet_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Planet planet;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "day_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DayWeather day;

	public Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public DayWeather getDay() {
		return day;
	}

	public void setDay(DayWeather day) {
		this.day = day;
	}
	
	public String getNamePlanet() {
		return this.getPlanet().getName();	
	}
	

}
