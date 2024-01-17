package com.moviebs.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="customer_details")
public class Customer 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 	
	//indicates that the value cannot be null
	@NotEmpty(message = "Name can't be empty!")
	//specifies the minimum and maximum length of the column
 	@Size(min = 2, max = 25, message = "Please enter proper name")
    private String name;
    
	//indicates that the value cannot be null
	@NotEmpty(message = "email can't be empty!")
	@Column(unique = true)
    private String email;
 	
	//Parameterized Constructor
    public Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
    }
}
