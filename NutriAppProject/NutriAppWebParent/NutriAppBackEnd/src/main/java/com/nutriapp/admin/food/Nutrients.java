package com.nutriapp.admin.food;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nutrients {
	
	private String nutrientId;
	private String nutrientName;
	private String nutrientNumber;
	private String unitName;
	private String derivationCode;
	private String derivationDescription;
	private String derivationId;
	private BigDecimal value;
	private long foodNutrientSourceId;
	private String foodNutrientSourceCode;
	private String foodNutrientSourceDescription;
	private long rank;
	private long indentLevel;
	private String foodNutrientId;
	private long dataPoints;
	
	


	
	
	


}
