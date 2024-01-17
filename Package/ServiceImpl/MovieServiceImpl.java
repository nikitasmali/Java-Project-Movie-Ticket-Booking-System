package com.moviebs.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviebs.service.*;
import com.moviebs.repos.*;
import com.moviebs.dto.*;
import com.moviebs.exception.*;
import com.moviebs.model.*;
import com.moviebs.util.*;
import java.util.*;


@Service
public class MovieServiceImpl implements MovieService
{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieConverter movieConverter;
	
	@Override
	
	// Saves a movie object to the movie repository and returns a message indicating whether the movie was added successfully
	public String createMovie(Movie movie) 
	{
		String message=null;
		movieRepository.save(movie);
		if(movie!=null)
		{
			message="Movie is added Successfully";
		}
		return message;
	}

	@Override
	
	//Retrieves all movies from the movie repository and returns a list of Movie objects
	public List<Movie> getAllMovies() 
	{
		
		return movieRepository.findAll();
	}

	@Override
	
	// Updates the details of a movie with the given ID
	public MovieDTO updateMovie(int id, Movie movie) 
	{
		Movie existingMovie = movieRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Movie", "ID", id));
		existingMovie.setMovieName(movie.getMovieName());
		existingMovie.setLocation(movie.getLocation());
		existingMovie.setMovieLanguage(movie.getMovieLanguage());
		existingMovie.setMovieTime(movie.getMovieTime());
		existingMovie.setMovieType(movie.getMovieType());
		existingMovie.setPrice(movie.getPrice());
		existingMovie.setSeatAvailable(movie.getSeatAvailable());
		
		movieRepository.save(existingMovie);
		
		
		//returns a MovieDTO (a data transfer object) representing the updated movie
		return movieConverter.convertToMovieDTO(existingMovie);
	}

	@Override
	
	//Deletes a movie with the specified ID from the repository
	public String deleteMovieById(int id)
	{
		String message=null;
		Optional<Movie> movie= Optional.ofNullable(movieRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Movie", "ID", id)));
		if(movie.isPresent())
		{
			movieRepository.deleteById(id);
			message= "Movie have been deleted";
		}
		else 
		{
			message= "Movie details not found";
		}
		return message;
	}

	@Override
	
	// Retrieves a list of movies with the given name from the repository
	public List<MovieDTO> getMovieByName(String movieName) 
	{
		List<Movie> movies= movieRepository.getMovieByName(movieName);
		List<MovieDTO> movieDTO= new ArrayList<>();
		for(Movie m: movies)
		{
			movieDTO.add(movieConverter.convertToMovieDTO(m));
		}
		return movieDTO;
	}

	@Override
	
	//Retrieves a list of movies with the specified location from the repository
	public List<MovieDTO> getMovieByLocation(String movieLocation)
	{
		List<Movie> movies= movieRepository.getMovieByLocation(movieLocation);
		List<MovieDTO> movieDTO= new ArrayList<>();
		for(Movie m: movies)
		{
			movieDTO.add(movieConverter.convertToMovieDTO(m));
		}
		return movieDTO;
	}

	@Override
	
	//Retrieves a list of movies with the given price from the repository
	public List<MovieDTO> getMovieByPrice(float moviePrice) 
	{
		List<Movie> movies= movieRepository.getMovieByPrice(moviePrice);
		List<MovieDTO> movieDTO= new ArrayList<>();
		for(Movie m: movies)
		{
			movieDTO.add(movieConverter.convertToMovieDTO(m));
		}
		return movieDTO;
	}



	@Override
	
	//Retrieves a list of movies with the specified genre from the repository
	public List<MovieDTO> getMovieByGenre(String movieGenre) 
	{
		List<Movie> movie2= movieRepository.getMovieByGenre(movieGenre);
		List<MovieDTO> movieDTO2= new ArrayList<>();
		for(Movie m:movie2)
		{
			
			//converts the Movie objects to MovieDTO
			movieDTO2.add(movieConverter.convertToMovieDTO(m));
		}
		
		//returns the list
		return movieDTO2;
	}
}
	
