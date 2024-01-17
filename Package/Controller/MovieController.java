package com.moviebs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.moviebs.dto.MovieDTO;
import com.moviebs.model.Movie;
import com.moviebs.service.MovieService;
import com.moviebs.util.MovieConverter;

@RestController
public class MovieController 
{
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieConverter movieConverter;
	
	// POST request to add a movie
	@PostMapping("/addMovie/{role}")
	public ResponseEntity<String> createMovie(@PathVariable("role") String role,@RequestBody MovieDTO movieDTO)
	{
		
		// converts the MovieDTO to a Movie entity using the movieConverter
		final Movie movie= movieConverter.convertToMovieEntity(movieDTO);
		if(role.equals("admin"))
		{
			//calls the createMovie method from the movieService
			movieService.createMovie(movie);
			return new ResponseEntity<String>("Movie is added Successfully", 
					HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<String>("You are not an admin", HttpStatus.BAD_REQUEST);
		}
	}
	
	//Handles the GET request to retrieve all movies
	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies()
	{
		return movieService.getAllMovies();
	}
	
	//Handles the PUT request to update a movie
	@PutMapping("/{role}/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable("role") String role, @PathVariable("id") int id, @RequestBody MovieDTO movieDTO)
	{
		if(role.equals("admin"))
		{
			Movie movie1= movieConverter.convertToMovieEntity(movieDTO);
			return new ResponseEntity<MovieDTO>(movieService.updateMovie(id, movie1), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("You are not an admin", HttpStatus.BAD_REQUEST);
		}
	}
	
	// Handles the DELETE request to delete a movie
	@DeleteMapping("/{role}/{id}")
	public ResponseEntity<String> deleteMovieById(@PathVariable("role") String role, @PathVariable ("id") int id)
	{
		if(role.equals("admin"))
		{
			return new ResponseEntity<String>(movieService.deleteMovieById(id), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("You are not an admin", HttpStatus.BAD_REQUEST);
		}
	}
	
	//Handles the GET request to retrieve movies by genre
	@GetMapping("/getMovieByGenre/{genre}")
	public List<MovieDTO> getMovieByGenre(@PathVariable("genre") String genre)
	{
		return movieService.getMovieByGenre(genre);
	}
	
	// Handles the GET request to retrieve movies by price
	@GetMapping("/getMovieByPrice/{price}")
	public List<MovieDTO> getMovieByPrice(@PathVariable("price") float moviePrice)
	{
		return movieService.getMovieByPrice(moviePrice);
	}
	
//	@GetMapping("/getMovieByPriceBetween/{startPrice}/{endPrice}")
//	public List<MovieDTO> getMovieByPriceBetween(@PathVariable("startPrice") float startPrice,
//			@PathVariable("endPrice") float endPrice)
//	{
//		return movieService.getMovieBYPriceBetween(startPrice, endPrice);
//	}	

}
