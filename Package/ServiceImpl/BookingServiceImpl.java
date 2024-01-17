package com.moviebs.serviceimpl;

import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.moviebs.exception.ResourceNotFoundException;
import com.moviebs.model.*;
import com.moviebs.repos.*;
import com.moviebs.service.*;
import com.moviebs.util.DateUtil;
import com.moviebs.dto.*;

@Service
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private AmountService amountService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Override
	
	//retrieves booking details based on a given booking ID
	public Booking getBookingDetailById(int bookingId) 
	{
		Optional<Booking> booking= Optional.ofNullable(bookingRepository.findById(bookingId).orElseThrow(()->
		new ResourceNotFoundException("Booking", "ID", bookingId)));
		return booking.isPresent() ? booking.get() : null;
	}


	@Override
	
	//books a ticket based on the provided BookingDTO object
	public TicketDTO bookTicket(BookingDTO bookingDTO) 
	{
		TicketDTO ticketDTO= new TicketDTO();
		float amount= amountService.getTicketAmount(bookingDTO.getTicket());
		if(amount!=0f)
			
		{
			
			// creates a new Customer object
			Customer customer= new Customer(bookingDTO.getCustomerName(), bookingDTO.getCustomerEmail());
			
			//checking if the customer already exists in the database using the CustomerService
			Integer customerIdFromDb = customerService.isCustomerPresent(customer);
			if(customerIdFromDb!=null)
			{
				customer.setId(customerIdFromDb);
			}
			else
			{
				customer= customerService.saveCustomer(customer);
			}
			
			// a new Booking object is created with the customer and ticket details
			Booking booking=  new Booking(customer,bookingDTO.getTicket());
			
			//saved using the BookingRepository
			booking= bookingRepository.save(booking);
			
			ticketDTO.setAmount(amount);
			ticketDTO.setDate(DateUtil.getCurrentDateTime());
			ticketDTO.setInvoiceNumber(new Random().nextInt(1000));
			ticketDTO.setBookingId(booking.getId());
			ticketDTO.setNotes("Thank you for booking, enjoy the show");
		}
		else
		{
			ticketDTO.setNotes("Error - "+"Something went wrong.");
		}
		return ticketDTO;
	}


	@Override
	
	//cancels a ticket based on the provided ticket ID.
	public String cancelTicket(int id) 
	{
		String message=null;
		
		//retrieves the booking from the BookingRepository using the ID
		Booking booking= bookingRepository.findById(id).get();
		if(booking!=null)
		{
			bookingRepository.deleteById(id);
			message="Ticket Deleted";
		}
		else
		{
			message="Ticket Id not found";
		}
		return message;
	}
}
