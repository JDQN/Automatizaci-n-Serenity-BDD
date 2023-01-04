package in.reqres.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question<Integer> {
	
	public static  Question<Integer> was(){
		return new CodigoRespuesta();
	}
	@Override
	public Integer answeredBy(Actor actor) {
		return SerenityRest.lastResponse().statusCode();
	}
}
