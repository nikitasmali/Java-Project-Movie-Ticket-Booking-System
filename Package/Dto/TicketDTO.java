package com.moviebs.dto;
import lombok.*;


@Data
public class TicketDTO 
{
	
	//floating-point variable that represents the ticket amount
	private float amount;
	
	//an integer variable that represents the invoice number associated with the ticket
	private int invoiceNumber;
	
	//a string variable that represents the date of the ticket.
	private String date;
	
	// an integer variable that represents the booking ID associated with the ticket
	private int bookingId;
	
	// a string variable that stores any additional notes or comments related to the ticket
	private String notes;
	

}
