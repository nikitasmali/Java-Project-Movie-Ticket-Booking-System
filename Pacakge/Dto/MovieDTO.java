package com.moviebs.dto;
import lombok.*;

@Data
public class MovieDTO
{
	//an integer represents the id for the movie
	private int movieId;
	
	//a string represents the moviename
	private String movieName;
	
	//a string represents the movie language
	private String movieLanguage;
	
	//a string represents the movietype
	private String movieType;
	
	//a string represents the moviegenre
	private String movieGenre;
	
	////a string represents the location
	private String location;
	
	//a string represents the movietime
	private String movieTime;
	
	//an integer represents the seats which are available
	private int seatAvailable;
	
	//a float represents the price
	private float price;

}
