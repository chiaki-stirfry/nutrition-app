package com.nutriapp.admin.food;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FoodRestController {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${foodcentral.rest.api.key}")
	private String apiKey;
	
	@Value("${foodcentral.rest.url}")
	private String theURL;
	
	@Value("${foodcentral.rest.datatype}")
	private String dataType;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/get_food_list")
	public List<FoodDTO> listFood(Model model) {
		logger.info("in getFoods(): Calling REST API " + theURL + "/foods/list?api_key="+ apiKey + "&dataType=" + dataType + "&pageSize=25");
//		Debug============================================================================================================
//		ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
//		RestTemplate restTemplate = new RestTemplate(factory);
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//		interceptors.add(new LoggingRequestInterceptor());
//		restTemplate.setInterceptors(interceptors);
//		==================================================================================================================
		
		// make REST call
		ResponseEntity<List<Food>> responseEntity = 
											restTemplate.exchange(theURL + "/foods/list?api_key="+ apiKey + "&dataType=" + dataType, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Food>>() {});


		// get the list of foods from response and return
		return responseEntity.getBody().stream()
	                .map(food -> {
	                    Food item = restTemplate.getForObject(theURL + "/food/" + food.getFdcId() + "?api_key="+ apiKey + "&dataType=" + dataType, Food.class);
	                    return new FoodDTO(item.getFdcId(), item.getDescription(),item.getFoodPortions());
	                })
	                .filter(f -> f.getFoodPortions() != null)
	                .collect(Collectors.toList());



	}
	
	@GetMapping("/search_food/{keyword}")
	public List<FoodDTO> searchFood(Model model, @PathVariable(name = "keyword")String keyword) {
		logger.info("in searchFood(): Calling REST API " + theURL + "/foods/search?api_key="+ apiKey + "&query=" + keyword +"&dataType=" + dataType);
		// make REST call
//			ResponseEntity<ResponseDTO> responseEntity = 
//				restTemplate.exchange(theURL + "/foods/search?api_key="+ apiKey + "&query=" + keyword +"&dataType=" + dataType, HttpMethod.GET, null, 
//						  new ParameterizedTypeReference<ResponseDTO>() {});
		
		ResponseDTO food = restTemplate.getForObject(theURL + "/foods/search?api_key="+ apiKey + "&query=" + keyword +"&dataType=" + dataType, ResponseDTO.class);
		// get the list of foods from response and return
			
			
				List<FoodDTO> result= food.getFoods().stream()
		                .filter(f -> f.getFoodPortions() != null)
		                .collect(Collectors.toList());
				
				logger.info("food: " + result.size() + "food name: " + result.get(0).getDescription());	
				return result;

		
		
	}
	
	
	
	
}
	
	
