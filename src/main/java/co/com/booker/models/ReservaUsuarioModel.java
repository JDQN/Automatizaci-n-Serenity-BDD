package co.com.booker.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReservaUsuarioModel {
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("lastname")
	private String lastName;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("totalprice")
	private Integer totalPrice;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("depositpaid")
	private Boolean depositpaid;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("bookingdates")
	private DateReservaModel bookingDates;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("additionalneeds")
	private String additionalNeeds;
	
	public ReservaUsuarioModel() {
	}
	
	public ReservaUsuarioModel(String firstName, String lastName, Integer totalPrice,
	                           Boolean depositpaid, DateReservaModel bookingDates,
	                           String additionalNeeds) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalPrice = totalPrice;
		this.depositpaid = depositpaid;
		this.bookingDates = bookingDates;
		this.additionalNeeds = additionalNeeds;
	}
	
}
