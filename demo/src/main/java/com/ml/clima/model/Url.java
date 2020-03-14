package com.ml.clima.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Url {

	@Column(nullable = false)
	private String urlShort;
	
	@Column(nullable = false)
	private String urlLong;

	public String getUrlShort() {
		return urlShort;
	}

	public void setUrlShort(String urlShort) {
		this.urlShort = urlShort;
	}

	public String getUrlLong() {
		return urlLong;
	}

	public void setUrlLong(String urlLong) {
		this.urlLong = urlLong;
	}
	
}
