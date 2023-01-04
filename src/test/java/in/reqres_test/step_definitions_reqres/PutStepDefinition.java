package in.reqres_test.step_definitions_reqres;

import com.github.javafaker.Faker;
import in.reqres.models.UsuarioModel;
import in.reqres.questions.IdActualizar;
import in.reqres.tasks.ActualizarUsuarioTask;
import in.reqres.tasks.CrearUsuarioTask;
import in.reqres_test.setup_reqres.ReqresSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.eclipse.jetty.http.HttpStatus;

import static in.reqres.questions.IdActualizar.actualizarId;
import static in.reqres.questions.CodigoRespuesta.was;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutStepDefinition extends ReqresSetUp {
	
	private static final Logger LOGGER = Logger.getLogger(PutStepDefinition.class);
	private static UsuarioModel actualizarUsuarioModel;
	private static UsuarioModel crearUsuarioModel;
	private String idActualizar;
	
	
	
	@Given("que el administrador ingresa al aplicativo web")
	public void queElAdministradorIngresaAlAplicativoWeb() {
		try {
			ActualizarDatosUsuario();
			generalSetUp();
			headers.put("Content-type", "application/json");
			actor.attemptsTo(
					CrearUsuarioTask.withName(actualizarUsuarioModel.getName())
							.andjob(actualizarUsuarioModel.getJob())
							.usingTheResource(POST_CREAR_USUARIO)
							.withHeaders(headers)
			);
			idActualizar = actualizarId().answeredBy(actor);
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	
	@When("actualiza los datos de un usario registrado")
	public void actualizaLosDatosDeUnUsarioRegistrado() {
		try{
			ActualizarDatosUsuario();
			actor.attemptsTo(
					ActualizarUsuarioTask.withName(actualizarUsuarioModel.getName())
							.andjob(actualizarUsuarioModel.getJob())
							.usingTheResource(PUT_ACTUALIZAR_USUARIO + idActualizar)
							.withHeaders(headers)
			);
		}catch (Exception exception){
			Assertions.fail("Aqui esta el Error", exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	@Then("recibo un codigo de status {int}")
	public void reciboUnCodigoDeStatus(Integer int1) {
		try {
			actor.should(
					seeThat("el codigo de respuesta",was(),equalTo(HttpStatus.OK_200))
			);
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	private  void ActualizarDatosUsuario(){
		Faker faker = new Faker();
		String name = faker.name().name();
		String job = faker.job().position();
		actualizarUsuarioModel = new UsuarioModel(name, job);
	}
	
}
