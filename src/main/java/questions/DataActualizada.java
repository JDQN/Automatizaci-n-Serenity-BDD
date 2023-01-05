package questions;

import co.com.booker.models.ReservaUsuarioModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DataActualizada implements Question<ReservaUsuarioModel> {
	
	public static DataActualizada dataActualizada(){
		return new DataActualizada();
	}
	
	@Override
	public ReservaUsuarioModel answeredBy(Actor actor) {
		return SerenityRest.lastResponse().as(ReservaUsuarioModel.class);
	}
}
