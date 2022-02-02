package model;

import com.google.gson.annotations.SerializedName;

public class Regions{

	@SerializedName("description")
	private String description;

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"Regions{" + 
			"description = '" + description + '\'' + 
			"}";
		}
}