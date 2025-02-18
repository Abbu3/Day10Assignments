package com.wipro.busbookingproject.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Bus {
	@Id
	@NotBlank
	@NotNull
	private long busId;
	@NotBlank
	private String busName;
	@Min(value = 5)
	@Max(value = 10)
	private long ticketId;
	//@Digits(integer = 4, fraction = 3)
	private double ticketPrice;
	@NotBlank
	private Date departureDate;	
	@NotBlank
	private Date arrivalDate;
	//@Pattern(regexp = "^[6-9]{1}[0-9]{9}$")
	private long mobileNumber;
	
	
	
	
	

}
