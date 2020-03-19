package com.ml.clima.dto;


public class UrlDto {

	private String urlShort;
	
	private String urlLong;
	
	private Long clic;
	
	public UrlDto(String urlLong, String urlShort, Long clic) {
		this.urlLong = urlLong;
		this.urlShort = urlShort;
		this.clic = clic;
	}
	
	public Long getClic() {
		return clic;
	}

	public void setClic(Long clic) {
		this.clic = clic;
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
