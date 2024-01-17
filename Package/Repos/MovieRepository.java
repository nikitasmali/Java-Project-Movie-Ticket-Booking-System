package com.moviebs.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moviebs.model.*;

import java.util.*;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>
{
	
	//custom JPQL query with a LIKE operator to perform a case-insensitive search for movies whose names start with the provided parameter.
	@Query("from Movie where lower(movieName) like :m%")
	List<Movie> getMovieByName(@Param("m") String movieName);
	
	// custom JPQL query with a LIKE operator to perform a case-insensitive search for movies whose location start with the provided parameter.
	@Query("from Movie where lower(location) like :m%")
	List<Movie> getMovieByLocation(@Param("m") String location);
	
	// custom JPQL query with a LIKE operator to perform a case-insensitive search for movies whose genre start with the provided parameter.
	@Query("from Movie where lower(genre) like :m%")
	List<Movie> getMovieByGenre(@Param("m") String genre);
	
	//get list of movies by price
	List<Movie> getMovieByPrice( float price);
	
	
	//List<Movie> getMovieByPriceBetween(float startPrice, float endPrice);
	
}


