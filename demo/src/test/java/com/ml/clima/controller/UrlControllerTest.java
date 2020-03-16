package com.ml.clima.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ml.clima.DemoApplication;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
//@AutoConfigureMockMvc
//@TestPropertySource(
//  locations = "classpath:application-integrationtest.properties")

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
@Ignore
public class UrlControllerTest {
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
    @Test
    public void get_url_short() throws Exception {
        ResponseEntity<String> response = restTemplate.postForEntity(
          createURLWithPort("/url/short/"), new String("https://eletronicos.mercadolivre.com.br/seguranca-casa/#menu=categories\\"), String.class);
       
        assertEquals(200, response.getStatusCodeValue());
    }
	
    
    private String createURLWithPort(String uri) {
        return "http://localhost:8080/"+ uri;
    }

    
    
    
}
