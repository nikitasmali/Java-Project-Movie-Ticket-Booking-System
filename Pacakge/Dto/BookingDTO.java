package com.moviebs.dto;
import lombok.*;
import java.util.*;

import com.moviebs.model.*;


@Data
public class BookingDTO 
{
	
	//represents a list of tickets
	private List<Ticket> ticket;
	
	//represents the email address of the customer
	private String customerEmail;
	
	//represents the name of the customer
	private String customerName;

}
