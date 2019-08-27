package com.ml.clima.dto;

public class WeatherResultDto {
		
	private Long droughtDays;
	
	private Long rainDays;
	
	private Long optimalDays;
	
	public Long getDroughtDays() {
		return droughtDays;
	}

	public void setDroughtDays(Long droughtDays) {
		this.droughtDays = droughtDays;
	}

	public Long getRainDays() {
		return rainDays;
	}

	public void setRainDays(Long rainDays) {
		this.rainDays = rainDays;
	}

	public Long getOptimalDays() {
		return optimalDays;
	}

	public void setOptimalDays(Long optimalDays) {
		this.optimalDays = optimalDays;
	}

}
