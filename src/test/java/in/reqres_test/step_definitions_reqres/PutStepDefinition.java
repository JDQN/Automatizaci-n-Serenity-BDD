package in.reqres_test.step_definitions_reqres;

import in.reqres_test.setup_reqres.ReqresSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;

public class PutStepDefinition extends ReqresSetUp {
	
	private static final Logger LOGGER = Logger.getLogger(PutStepDefinition.class);
	
	
	@Given("que el administrador ingresa al aplicativo web")
	public void queElAdministradorIngresaAlAplicativoWeb() {
		try {
			generalSetUp();
			headers.put("Content-type", "application/json");
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	
	@When("actualiza los datos de un usario registrado")
	public void actualizaLosDatosDeUnUsarioRegistrado() {
	
	}
	
	@Then("recibo un codigo de status {int}")
	public void reciboUnCodigoDeStatus(Integer int1) {
	
	}
	
	
}
