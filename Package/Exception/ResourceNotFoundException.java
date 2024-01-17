package com.moviebs.exception;

public class ResourceNotFoundException extends RuntimeException
{
	
	//unique identifier for the serialized version of the class
	private static final long serialVersionUID = 1L;
	
	//represents the name of the resource that was not found
	private String resourceName;
	
	//represents the name of the field used to search for the resource
	private String fieldName;
	
	//Represents the value of the field used to search for the resource
	private Object fieldValue;
	
	//parameterized constructor
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) 
	{
		super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	//invoking getters and setters
	public String getResourceName()
	{
		return resourceName;
	}

	public void setResourceName(String resourceName)
	{
		this.resourceName = resourceName;
	}

	public String getFieldName() 
	{
		return fieldName;
	}

	public void setFieldName(String fieldName) 
	{
		this.fieldName = fieldName;
	}

	public Object getFieldValue() 
	{
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) 
	{
		this.fieldValue = fieldValue;
	}
	
}
