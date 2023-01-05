package in.reqres.tasks;

import interteraction.Post;
import in.reqres.models.UsuarioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class CrearUsuarioTask implements Task {
	
	private String resource;
	private Map<String, Object> headers;
	
	
	private final UsuarioModel crearUsuarioModel;
	
	
	public CrearUsuarioTask(UsuarioModel crearUsuarioModel) {
		this.crearUsuarioModel = crearUsuarioModel;
	}
	
	public static DatosUsuarioBuilder withName(String name){
		return new DatosUsuarioBuilder(name);
	}
	
	
	public CrearUsuarioTask usingTheResource(String resource) {
		this.resource = resource;
		return this;
	}
	
	public CrearUsuarioTask withHeaders(Map<String, Object> headers) {
		this.headers = headers;
		return this;
	}
	
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Post.to(resource)
				.with(
					requestSpecification -> requestSpecification
                  .relaxedHTTPSValidation()
                  .headers(headers)
                  .body(crearUsuarioModel)
                  .log().body()
				)
		);
	}
	
	
	public static class DatosUsuarioBuilder{
		private String name;
		private String job;
		
		
		public DatosUsuarioBuilder(String name){
			this.name = name;
		}
		
		public  CrearUsuarioTask andjob(String job){
			this.job = job;
			return new CrearUsuarioTask(UsuarioModel
			                            .builder()
					                      .name(this.name)
					                      .job(this.job)
					                      .build());
		}
	}
}
