package com.moviebs.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.moviebs.service.*;
import com.moviebs.dto.*;
import com.moviebs.model.*;

//indicates that this class is a controller that handles RESTful API requests
@RestController

//specifies that this controller handles requests with the base URL path "/booking"
@RequestMapping("/booking")
public class BookingTicketController 
{
	@Autowired
	private BookingService bookingService;
	
	//retrieves booking details by calling the getBookingDetailById method of the bookingService 
	@GetMapping("/{id}") 
	public Booking getBookingDetails(@PathVariable int bookingId)
	{
		Booking booking= bookingService.getBookingDetailById(bookingId);
		
		//returns the Booking object
		return booking;
	}
	
	@PostMapping("/bookTicket")
	
	//calls the bookTicket method of the bookingService
	public TicketDTO bookTicket(@RequestBody BookingDTO bookingDTO)
	{
		
		// returns the resulting TicketDTO object.
		return bookingService.bookTicket(bookingDTO);
	}
	
	
	@DeleteMapping("/{id}")
	
	//calls the cancelTicket method of the bookingService  
	public String cancelTicket(@PathVariable("id") int id)
	{
		
		//returns the cancellation status
		return bookingService.cancelTicket(id);
	}

}
