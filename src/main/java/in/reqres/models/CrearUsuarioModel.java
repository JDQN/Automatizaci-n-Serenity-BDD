package in.reqres.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CrearUsuarioModel {
	private String name;
	private String job;
	
}
