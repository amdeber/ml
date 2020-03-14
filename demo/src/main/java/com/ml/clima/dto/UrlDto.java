package com.ml.clima.dto;


public class UrlDto {

	private String urlShort;
	
	private String urlLong;
	
	public UrlDto(String urlLong, String urlShort) {
		this.setUrlLong(urlLong);
		this.setUrlShort(urlShort);
	}
	
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
