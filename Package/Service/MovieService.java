package com.moviebs.service;
import java.util.*;
import com.moviebs.dto.*;
import com.moviebs.model.*;

public interface MovieService 
{
 	//method to create movie
	String createMovie(Movie movie);
	
	//get the list of all movies
	List<Movie> getAllMovies();
	
	//update the movie through id
	MovieDTO updateMovie(int id, Movie movie);
	
	//delete movie through id
	String deleteMovieById(int id);
	
	//get movie by moviename
	List<MovieDTO> getMovieByName(String movieName);
	
	//get movie by movielocation
	List<MovieDTO> getMovieByLocation(String movieLocation);
	
	//get movie by moviegenre
	List<MovieDTO> getMovieByGenre(String movieGenre);
	
	//get list of movie by price
	List<MovieDTO> getMovieByPrice(float moviePrice);
	//List<MovieDTO> getMovieBYPriceBetween(float startPrice, float endPrice);
}