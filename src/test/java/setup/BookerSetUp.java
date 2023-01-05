package setup;

import co.com.booker.models.DateReservaModel;
import co.com.booker.models.ReservaUsuarioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;
import java.util.Map;

public class BookerSetUp {
	
	protected static final String URL_BASE_BOOKING = "https://restful-booker.herokuapp.com";
	protected static final String POST_CREAR_RESERVA = "/booking";
	protected static final String GET_RESERVA_ID = "/booking/";
	protected  static final String CONTENT_TYPE = ("application/json");
	
	protected DateReservaModel dateReservaModel;
	protected ReservaUsuarioModel reservaUsuarioModel;
	
	protected static final String ACTOR_NAME = "ReyPele";
	protected Actor actor;
	protected Map<String, Object> headers = new HashMap<>();
	protected void generalSetUp(){
		actor = Actor.named(ACTOR_NAME);
		actor.can(CallAnApi.at(URL_BASE_BOOKING));
		headers.put("Content-Type", "application/json");
	}
	
}
