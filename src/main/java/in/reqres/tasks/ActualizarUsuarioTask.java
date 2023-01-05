package in.reqres.tasks;

import interteraction.Put;
import in.reqres.models.UsuarioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class ActualizarUsuarioTask implements Task {
	
	private String resource;
	private Map<String, Object> headers;
	
	private final UsuarioModel actualizarUsuarioModel;
	
	public ActualizarUsuarioTask(UsuarioModel actualizarUsuarioModel) {
		this.actualizarUsuarioModel = actualizarUsuarioModel;
	}
	
	public static DatosUsuarioBuilder withName(String name) {
		return new DatosUsuarioBuilder(name);
	}
	
	public ActualizarUsuarioTask usingTheResource(String resource) {
		this.resource = resource;
		return this;
	}
	
	public ActualizarUsuarioTask withHeaders(Map<String, Object> headers) {
		this.headers = headers;
		return this;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Put.to(resource)
				.with(
					requestSpecification -> requestSpecification
                  .relaxedHTTPSValidation()
                  .headers(headers)
                  .body(actualizarUsuarioModel)
				)
		);
	}
	
	public static class DatosUsuarioBuilder{
		
		private String name;
		private String job;
		
		
		public DatosUsuarioBuilder(String name){
			this.name = name;
		}
		
		public ActualizarUsuarioTask andjob(String job){
			this.job = job;
			return new ActualizarUsuarioTask(UsuarioModel
			                                 .builder()
			                                 .name(this.name)
			                                 .job(this.job)
			                                 .build()
			);
		}
	}
}
