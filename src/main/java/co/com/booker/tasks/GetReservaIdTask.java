package co.com.booker.tasks;

import interteraction.Get;
import interteraction.Post;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class GetReservaIdTask implements Task {
	
	private String resource;
	private Map<String, Object> headers;

	
	public static GetReservaIdTask getReservaIdTask(){
		return new GetReservaIdTask();
	}
	
	public GetReservaIdTask usingTheResource(String resource){
		this.resource = resource;
		return this;
	}
	
	public GetReservaIdTask withHeaders(Map<String, Object> headers){
		this.headers = headers;
		return this;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Get.resource(resource)
			.with(
				requestSpecification -> requestSpecification
               .relaxedHTTPSValidation()
               .headers(headers)
			)
		);
	}
	
}
