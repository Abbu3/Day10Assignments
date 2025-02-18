package com.wipro.busbookingproject.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.busbookingproject.entity.Bus;
import com.wipro.busbookingproject.exceptionhandler.BusIdNotFoundException;
import com.wipro.busbookingproject.exceptionhandler.DeleteIsNotFound;
import com.wipro.busbookingproject.service.BusServiceImpl;
import com.wipro.busbookingproject.service.IBusService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/bus")
public class BusController {
	@Autowired
	IBusService iBusService;
	
	@PostMapping("/insert")
	public Bus insertBus(@RequestBody Bus bus) {
		
		return iBusService.insertBus(bus);
	}
	
	@GetMapping("/findByTicketId/{busId}")
	public Bus findByTicketId(@PathVariable long busId) throws BusIdNotFoundException {
	
		Bus byTicketId = iBusService.findByTicketId(busId);
		
		if(byTicketId != null) {
			return byTicketId;
		} else {
			throw new BusIdNotFoundException();
		}
	}

	@GetMapping("/findByTicketPriceGreaterThan/{ticketPrice}")
	public List<Bus> findByTicketPriceGreaterThan(@PathVariable double ticketPrice) {
		
		return iBusService.findByTicketPriceGreaterThan(ticketPrice);
	}

	@GetMapping("/sort")
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		return iBusService.findAllBuses();
	}
	
	@DeleteMapping("/delete/{busId}")
	public ResponseEntity<String> deleteById(@PathVariable long busId) throws DeleteIsNotFound {
		Bus byTicketId = iBusService.findByTicketId(busId);
		if(byTicketId != null) {
			ResponseEntity<String> deleteById = iBusService.deleteById(busId);
			return new ResponseEntity<String>("record deleted", HttpStatus.OK);
		} 
		 else {
			throw new DeleteIsNotFound();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PutMapping("/update")
//	public Bus updateBus(Date departureDate, long busId) {
//		// TODO Auto-generated method stub
//		return iBusService.updateBus(departureDate, busId);
//	}
//	
//	@PutMapping("/update")
//	public Bus updateBus(@RequestBody Bus bus) {
//		return iBusService.updateBus(bus);
//	}

}
