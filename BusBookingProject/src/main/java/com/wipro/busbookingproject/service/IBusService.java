package com.wipro.busbookingproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import java.sql.Date;


import com.wipro.busbookingproject.entity.Bus;

public interface IBusService {
	
	Bus insertBus(Bus bus);
	Bus findByTicketId(long busId);
	
	List<Bus> findByTicketPriceGreaterThan(double ticketPrice);
	
	List<Bus> findAllBuses();
	
	ResponseEntity<String> deleteById(long busId);
	
	//Bus updateBus(Date departureDate, long busId);

	

}
