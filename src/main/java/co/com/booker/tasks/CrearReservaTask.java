package co.com.booker.tasks;

import co.com.booker.models.DateReservaModel;
import co.com.booker.models.ReservaUsuarioModel;

import interteraction.Post;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class CrearReservaTask implements Task {
	private String resource;
	private Map<String, Object> headers;
	private ReservaUsuarioModel reservaUsuarioModel;
	
	
	public CrearReservaTask(ReservaUsuarioModel reservaUsuarioModel) {
		this.reservaUsuarioModel = reservaUsuarioModel;
	}
	
	public static DatosUsuarioBuilder withName(String name){
		return new DatosUsuarioBuilder(name);
	}
	
	public CrearReservaTask usingTheResource(String resource){
		this.resource = resource;
		return this;
	}
	
	public CrearReservaTask withHeaders(Map<String, Object> headers){
		this.headers = headers;
		return this;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Post.to(resource)
				.with(
					requestSpecification -> requestSpecification
                  .relaxedHTTPSValidation()
                  .headers(headers)
                  .body(reservaUsuarioModel)
                  .log().body()
				)
		);
	}
	
	
	public static class DatosUsuarioBuilder{
		
		private String firstName;
		private String lastName;
		private Integer totalPrice;
		private Boolean depositpaid;
		private DateReservaModel bookingDates;
		private String additionalNeeds;
		
		public  DatosUsuarioBuilder (String firstName){
			this.firstName = firstName;
		}
		
		public DatosUsuarioBuilder datosLastName(String lastName){
			this.lastName = lastName;
			return this;
		}
		
		public DatosUsuarioBuilder datosTotalPrice(Integer totalPrice){
			this.totalPrice = totalPrice;
			return this;
		}
		
		public DatosUsuarioBuilder datosDepositpaid(Boolean depositpaid){
			this.depositpaid = depositpaid;
			return this;
		}
		
		public DatosUsuarioBuilder datosbookingDates(DateReservaModel bookingDates){
			this.bookingDates = bookingDates;
			return this;
		}
		
		public CrearReservaTask datosadditionalNeeds(String additionalNeeds){
			this.additionalNeeds = additionalNeeds;
			return new CrearReservaTask(ReservaUsuarioModel
                .builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .totalPrice(this.totalPrice)
                .depositpaid(this.depositpaid)
                .bookingDates(this.bookingDates)
                .additionalNeeds(this.additionalNeeds)
                .build());
		}
	}
}
