package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pais {
	@SerializedName(value="region")
	private String continente;
	@SerializedName(value="name")
	private String nombre;
	@SerializedName(value="capital")
	private String capital;
	@SerializedName(value="population")
	private long poblacion;

}
