package com.nutriapp.admin.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Food {
	
	private long fdcId;
	private String description;
	private String publicationDate;
	private String lowercaseDescription;
	private String commonNames;
	private String additionalDescriptions;
	private String dataType;
	private String allHighlightFields;
	private BigDecimal score;
	private Set<Nutrients> foodNutrients;
	private FoodCategory foodCategory;
	private List<FoodPortion> foodPortions;
	

	
	
	

   
}
