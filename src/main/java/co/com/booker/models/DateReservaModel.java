package co.com.booker.models;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DateReservaModel {
	
	private String checkin;
	private String checkout;
	
	public DateReservaModel() {
	}

	public DateReservaModel(String checkin, String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
}
