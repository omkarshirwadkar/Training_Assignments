package com.example.demo.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beans.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CatalogService {
	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="prodServNotAvail", fallbackMethod = "fallBackResponse")
	public List<Product> getAllProducts(){
		return restTemplate.getForObject("http://PRODUCT-MGMT-SERVICE/products", List.class);
	}
	
	public List<String> fallBackResponse(Throwable T){
		return Collections.singletonList("Sorry Product Management Service not available");
	}
}
