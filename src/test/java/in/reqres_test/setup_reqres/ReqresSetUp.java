package in.reqres_test.setup_reqres;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;
import java.util.Map;

public class ReqresSetUp {
	
	protected static final String URL_BASE_REQRES = "https://reqres.in";
	protected static final String POST_CREAR_USUARIO = "/api/users";
	protected static final String PUT_ACTUALIZAR_USUARIO = "/api/users/2";
	protected  static final String CONTENT_TYPE = ("application/json");
	protected static final String ACTOR_NAME = "Messi";
	protected Actor actor;
	protected Map<String, Object> headers = new HashMap<>();
	
	protected void generalSetUp(){
		actor = Actor.named(ACTOR_NAME);
		actor.can(CallAnApi.at(URL_BASE_REQRES));
	}
	
}
