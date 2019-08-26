package com.ml.clima.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class DayWeather implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long day;

	@Column(nullable = true)
	private String weather;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "day", cascade = CascadeType.ALL)
	private List<Point> Points;
	
	public DayWeather(Long day) {
		this.day = day;
	}

	public DayWeather() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String clima) {
		this.weather = clima;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}
	
	public List<Point> getPoints() {
		return Points;
	}

	public void setPoints(List<Point> points) {
		Points = points;
	}
}
