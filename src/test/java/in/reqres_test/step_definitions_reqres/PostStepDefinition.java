package in.reqres_test.step_definitions_reqres;

import com.github.javafaker.Faker;
import in.reqres.models.UsuarioModel;
import in.reqres.tasks.CrearUsuarioTask;
import in.reqres_test.setup_reqres.ReqresSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.eclipse.jetty.http.HttpStatus;

import static in.reqres.questions.CodigoRespuesta.was;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class PostStepDefinition extends ReqresSetUp {
	
	private static final Logger LOGGER = Logger.getLogger(PostStepDefinition.class);
	private static UsuarioModel crearUsuarioModel;
	
	
	@Given("que el administrador ingresa al aplicativo")
	public void queElAdministradorIngresaAlAplicativo() {
		try {
			generalSetUp();
			headers.put("Content-type", "application/json");
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
		
	}
	
	@When("crea un usuario nuevo")
	public void creaUnUsuarioNuevo(){
		try {
			CrearDatosUsuarios();
			actor.attemptsTo(
					CrearUsuarioTask.withName(crearUsuarioModel.getName())
							.andjob(crearUsuarioModel.getJob())
							.usingTheResource(POST_CREAR_USUARIO)
							.withHeaders(headers)
			);
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	@Then("recibira un codigo de status create 201")
	public void recibiraUnCodigoDeStatusCreate201() {
		try {
			actor.should(
					seeThat("el codigo de respuesta", was(),equalTo(HttpStatus.CREATED_201))
			);
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	private static void CrearDatosUsuarios(){
		Faker faker = new Faker();
		String name = faker.name().name();
		String job =  faker.job().position();
		crearUsuarioModel = new UsuarioModel(name, job);
	}
	
}
