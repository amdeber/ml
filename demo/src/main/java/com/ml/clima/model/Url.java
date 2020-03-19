package com.ml.clima.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

	public Long getClic() {
		return clic;
	}

	public void setClic(Long clic) {
		this.clic = clic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String shortUrl;
	
	@Column(nullable = false)
	private String longUrl;
	
	@Column(nullable = false)
	private Long clic = Long.valueOf(0);

	public String getShortUrl() {
		return shortUrl;
	}

	public Url() {
	}
	
	public Url(String longUrl, String shortUrl) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}
	public void setShortUrl(String urlShort) {
		this.shortUrl = urlShort;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String urlLong) {
		this.longUrl = urlLong;
	}
	
}
