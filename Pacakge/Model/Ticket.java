package com.moviebs.model;
import lombok.*;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="booked_ticket")
public class Ticket
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	//integer representing the id of the movie
	@Column(name="movie_id")
	private int movieId;
	
	//string representing the name of the movie
	@Column(name="movie_name")
	private String movieName;
	
	//integer representing the booked_seats of the movie
	@Column(name="booked_seats")
	private int seats;
	
	//float representing the total_amount of the movie
	@Column(name="total_amount")
	private float totalAmount;

	// parameterized constructor  	
	public Ticket(int movieId, int seats) 
	{
		super();
		this.movieId = movieId;
		this.seats = seats;
	}
	
	//parameterized constructor
	public Ticket(int movieId, String movieName, int seats, float totalAmount) 
	{
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.seats = seats;
		this.totalAmount = totalAmount;
	}

}
