package com.nutriapp.admin.food;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodPortion {
	
	private long id;
	private float amount;
	private BigDecimal gramWeight;
	private int sequenceNumber;
	private String modifier;
	
	

	


}
