package com.nutriapp.admin.food;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDTO {
	
	private long fdcId;
	private String description;
	private String dataType;
	private String publicationDate;
	private String ndbNumber;
//	private Set<Nutrients> foodNutrients;
	private List<FoodPortion> foodPortions;
	
	public FoodDTO(long fdcId, String description, List<FoodPortion> foodPortions) {
		this.fdcId = fdcId;
		this.description = description;
		this.foodPortions = foodPortions;
	}

}
