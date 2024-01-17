package com.moviebs.service;
import com.moviebs.dto.*;
import com.moviebs.model.*;
public interface BookingService 
{
	//get all the booking details by booking id
	Booking getBookingDetailById(int bookingId);
	
	//booking ticket 
	TicketDTO bookTicket(BookingDTO bookingDTO);
	
	//cancel the ticket through ticket id
	String cancelTicket(int id);
}