package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IdActualizar implements Question<String> {
	
	public static Question<String> actualizarId(){
		return new IdActualizar();
	}
	
	@Override
	public String answeredBy(Actor actor) {
		return SerenityRest
				       .lastResponse()
				       .getBody()
				       .jsonPath()
				       .getString("id");
	}
}
