package co.com.booker.models;


public class IdReservaDTO {
	
	private Integer bookingid;
	private ReservaUsuarioModel booking;
	
	public IdReservaDTO() {
	}
	
	public IdReservaDTO(Integer bookingid, ReservaUsuarioModel booking) {
		this.bookingid = bookingid;
		this.booking = booking;
	}
	
	public Integer getBookingid() {
		return bookingid;
	}
	
	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}
	
	public ReservaUsuarioModel getBooking() {
		return booking;
	}
	
	public void setBooking(ReservaUsuarioModel booking) {
		this.booking = booking;
	}
	
}
