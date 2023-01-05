package co.com.booker_test.step_definitions_booker;

import co.com.booker.models.DateReservaModel;
import co.com.booker.models.ReservaUsuarioModel;
import co.com.booker.tasks.CrearReservaTask;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.eclipse.jetty.http.HttpStatus;
import setup.BookerSetUp;

import java.sql.Date;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.CodigoRespuesta.was;
import static questions.DataActualizada.dataActualizada;


public class PostStepDefinitionBooking extends BookerSetUp {
	
	private static final Logger LOGGER = Logger.getLogger(PostStepDefinitionBooking.class);
	
	@Given("que el usuario ingresa al aplicativo booking")
	public void queElUsuarioIngresaAlAplicativoBooking() {
		try {
			generalSetUp();
		}catch (Exception exception){
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	@When("ingresa los datos del formulario de reserva")
	public void ingresaLosDatosDelFormularioDeReserva() {
		try {
			DatosReserva();
			actor.attemptsTo(
					(Performable) CrearReservaTask.withName(reservaUsuarioModel.getFirstName())
							.datosLastName(reservaUsuarioModel.getLastName())
							.datosTotalPrice(reservaUsuarioModel.getTotalPrice())
							.datosDepositpaid(reservaUsuarioModel.getDepositpaid())
							.datosbookingDates(reservaUsuarioModel.getBookingDates())
		               .datosadditionalNeeds(reservaUsuarioModel.getAdditionalNeeds())
              .usingTheResource(POST_CREAR_RESERVA)
              .withHeaders(headers)
			);
			LastResponse.received().answeredBy(actor).prettyPrint();
		}catch (Exception exception) {
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	@Then("se recibe un codigo stus 200")
	public void seRecibeUnCodigoStus200() {
		try {
			actor.should(
					seeThat("el codigo de respuesta", was(),equalTo(HttpStatus.OK_200))
			);
		}catch (Exception exception) {
			Assertions.fail(exception.getMessage(), exception);
			LOGGER.error(exception.getMessage(), exception);
		}
	}
	
	private  void DatosReserva(){
		
		Faker faker = new Faker();
		
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		Integer totalPrice = faker.number().numberBetween(100,200);
		Boolean depositpaid = faker.random().nextBoolean();
		String additionalNeeds = "desayuno";
		
		String checkin = (String.valueOf(faker.date().between(Date.valueOf("2014-10-23"), Date.valueOf("2019-10-23"))));
		String checkout = (String.valueOf(faker.date().between(Date.valueOf("2015-10-23"), Date.valueOf("2022-10-23"))));
		
		dateReservaModel = new DateReservaModel(checkin, checkout);
		reservaUsuarioModel = new ReservaUsuarioModel(
				firstname,
				lastname,
				totalPrice,
				depositpaid,
				dateReservaModel,
				additionalNeeds
		);
	}
}
