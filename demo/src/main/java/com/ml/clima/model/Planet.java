package com.ml.clima.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Planet {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long angularVelocity;
	
	@Column(nullable = false)
	private Integer distanceFromSun;
	
	@OneToMany(mappedBy="planet")
	private List<Point> Points;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Point> getPoints() {
		return Points;
	}

	public void setPoints(List<Point> points) {
		Points = points;
	}

	public Long getAngularVelocity() {
		return angularVelocity;
	}

	public void setAngularVelocity(Long angularVelocity) {
		this.angularVelocity = angularVelocity;
	}

	public Integer getDistanceFromSun() {
		return distanceFromSun;
	}

	public void setDistanceFromSun(Integer distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
