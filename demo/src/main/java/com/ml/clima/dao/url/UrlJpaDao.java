package com.ml.clima.dao.url;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ml.clima.model.DayWeather;
import com.ml.clima.model.Url;

public interface UrlJpaDao extends JpaRepository<Url, Long>{
	
	Url findByShortUrl(String shortUrl);
	
	Url findByLongUrl(String longUrl);

}
