package com.moviebs.model;
import lombok.*;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="movie_details")
public class Movie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	//string representing the name of the movie
	@Column(name="movie_name", nullable = false, length = 20)
	private String movieName;
	
	//string representing the language of the movie
	@Column(name="language", nullable = false, length = 10)
	private String movieLanguage;
	
	//string representing the genre of the movie
	@Column(name="genre", nullable = false, length = 10)
	private String movieGenre;
	
	//string representing the movietype of the movie
	@Column(name="type", nullable = false, length = 10)
	private String movieType;
	
	//string representing the location of the movie
	@Column(name="location", nullable = false, length = 10)
	private String location;
	
	//string representing the timing of the movie
	@Column(name="timing", nullable = false,length = 10)
	private String movieTime;
	
	//integer representing the seat_available of the movie
	@Column(name="seat_available", nullable = false, length = 3)
	private int seatAvailable;
	
	//float representing the movie_price of the movie
	@Column(name="movie_price", nullable = false, length = 3)
	private float price;	

}
