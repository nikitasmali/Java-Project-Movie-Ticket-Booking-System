package com.moviebs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieBookingSystemApplication
{

	public static void main(String[] args) 
	{
		SpringApplication.run(MovieBookingSystemApplication.class, args);
		System.out.println("Running");
	}

}
