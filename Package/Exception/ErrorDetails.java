package com.moviebs.exception;


import java.sql.Date;

//represents details of an error or exception
public class ErrorDetails
{
	
	//represents the timestamp when the error occurred
	private java.util.Date timestamp;
	
	//stores the error message or description
	private String message;
	
	//provides additional details about the error
	private String details;
	
	//invoking getters and setters
	public java.util.Date getTimestamp()
	{
		return timestamp;
	}
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	public String getDetails() 
	{
		return details;
	}
	public void setDetails(String details) 
	{
		this.details = details;
	}
	
	//parameterized constructor
	public ErrorDetails(java.util.Date date, String message, String details) {
		super();
		this.timestamp = date;
		this.message = message;
		this.details = details;
	}
	
	//default constructor
	public ErrorDetails() 
	{
		super();
	}
}
