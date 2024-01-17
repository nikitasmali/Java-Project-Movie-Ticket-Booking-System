package com.moviebs.service;
import java.util.*;

import com.moviebs.model.*;
public interface AmountService
{
	
	//a float representing the method getticketamount through list of tickets
	float getTicketAmount(List<Ticket> TicketList);
}