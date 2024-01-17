package com.moviebs.serviceimpl;
import com.moviebs.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.moviebs.model.*;
import com.moviebs.repos.*;
import org.springframework.stereotype.Service;



@Service
public class AmoutServiceImpl implements AmountService
{
	
		//indicates that it is a dependency that will be automatically injected into the AmoutServiceImpl class
		@Autowired
		private MovieRepository movieRepository;
		
		@Override
		public float getTicketAmount(List<Ticket> TicketList)
		{
		
			//store the cumulative ticket amount
			float totalTicketAmount = 0f;
			
			//store the amount for each individual ticket
	        float singleTicketAmount = 0f;
	        
	        //track the number of available seats after each ticket purchase
	        int seatsAvailable = 0;
		
	        for(Ticket t : TicketList)
	        {
	        	int movieId= t.getMovieId();
	        	Optional<Movie> movie= movieRepository.findById(movieId);
	        	
	        	//proceeds to calculate the ticket amount
	        	if(movie.isPresent())
	        	{
	        		Movie movie1= movie.get();
	        		if(movie1.getSeatAvailable() < t.getSeats())
	        		{
	        			singleTicketAmount= movie1.getPrice() * movie1.getSeatAvailable();
	        			t.setSeats(movie1.getSeatAvailable());
	        		}
	        		else
	        		{
	        			singleTicketAmount= t.getSeats() * movie1.getPrice();
	        			seatsAvailable=movie1.getSeatAvailable() - t.getSeats();
	        		}
	        		totalTicketAmount= totalTicketAmount + singleTicketAmount;
	        		movie1.setSeatAvailable(seatsAvailable);
	        		
	        		// set back to 0 to prepare for the next iteration
	        		seatsAvailable=0;
	        		t.setMovieName(movie1.getMovieName());
	        		t.setTotalAmount(singleTicketAmount);
	        		movieRepository.save(movie1);
	        	}
	        }
	        return totalTicketAmount;
		}

}
