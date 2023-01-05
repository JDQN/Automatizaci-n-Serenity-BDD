package questions;

import co.com.booker.models.IdReservaDTO;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IdReserva implements Question<IdReservaDTO> {
	
	public static IdReserva reservaId(){
		return new IdReserva();
	}
	
	@Override
	public IdReservaDTO answeredBy(Actor actor) {
		return SerenityRest.lastResponse().as(IdReservaDTO.class);
	}
}
