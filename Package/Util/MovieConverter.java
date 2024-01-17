package com.moviebs.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.moviebs.dto.MovieDTO;
import com.moviebs.model.Movie;

@Component
public class MovieConverter
{
	
	//convert to movie entity through moviedto 
	public Movie convertToMovieEntity(MovieDTO movieDTO)
	{
		Movie movie= new Movie();
		if(movie!=null)
		{
			
			//copies the properties of source object to target object with same property
			BeanUtils.copyProperties(movieDTO, movie);
		}
		return movie;
	}
	
	//convert to moviedto through movie
	public MovieDTO convertToMovieDTO(Movie movie)
	{
		MovieDTO movieDTO= new MovieDTO();
		if(movieDTO!=null)
		{
			
			//copies the properties of source object to target object with same property
			BeanUtils.copyProperties(movie, movieDTO);
		}
		return movieDTO;
	}

}
