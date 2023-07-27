package com.nutriapp.admin.food;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FoodServiceRestClientImpl  {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${foodcentral.rest.api.key}")
	private String apiKey;
	
	@Value("${foodcentral.rest.url}")
	private String theURL;
	
	@Value("${foodcentral.rest.datatype}")
	private String dataType;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public List<Food> getFoods(){
		logger.info("in getFoods(): Calling REST API " + theURL + "foods/list?api_key="+ apiKey + "&dataType=" + dataType);

		// make REST call
		ResponseEntity<List<Food>> responseEntity = 
											restTemplate.exchange(theURL + "foods/list?api_key="+ apiKey + "&dataType=" + dataType, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Food>>() {});

		// get the list of foods from response
		List<Food> foods = responseEntity.getBody();

		logger.info("in getFoods(): foods" + foods);
		
		return foods;
	}

	
	public Food getFoodById(int foodId) {

		logger.info("in getCustomer(): Calling REST API " + theURL + "/food/" + foodId + "?api_key="+ apiKey + "&dataType=" + dataType);

		// make REST call
		Food food = restTemplate.getForObject(theURL + "/food/" + foodId + "?api_key="+ apiKey + "&dataType=" + dataType, Food.class);
	
		
		return food;
	}
	
	public Food getFoodByKeyword(int keyword) {

		logger.info("in getCustomer(): Calling REST API " + theURL + "/foods/search?api_key="+ apiKey + "&query=" + keyword +"&dataType=" + dataType);

		// make REST call
		Food food = restTemplate.getForObject(theURL + "/foods/search?api_key="+ apiKey + "&query=" + keyword +"&dataType=" + dataType, Food.class);
	
		
		return food;
	}





}
