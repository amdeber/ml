package com.ml.clima.utils;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

public class UrlTest {
	
	
	@Test
	public void wihtout_domain() {
		String url = "https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories";
		String result = UrlUtils.getInstance().urlWithoutDomain(url);
		assertEquals("/seguranca-casa/#menu=categories", result);
	}
	
	@Test
	public void get_url_short() {
		String url = "https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories";
		String result = UrlUtils.getInstance().transformLongToShorUrl(url);
		assertEquals("https://me.li/363a6462", result);
	}
	
}
