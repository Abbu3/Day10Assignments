package com.wipro.busbookingproject.service;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.wipro.busbookingproject.entity.Bus;
import com.wipro.busbookingproject.repository.BusRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Service
public class BusServiceImpl implements IBusService {
	@Autowired
	BusRepository busRepository;
	
	
	public Bus insertBus(Bus bus) {
		return busRepository.save(bus);
	}

	@Override
	public Bus findByTicketId(long busId) {
		
		log.info("finding the daya by busId");
		return busRepository.findById(busId).orElse(null);
	}

	@Override
	public List<Bus> findByTicketPriceGreaterThan(double ticketPrice) {
		// TODO Auto-generated method stub
		return busRepository.findByTicketPriceGreaterThan(ticketPrice);
	}
	
	@Override
	public List<Bus> findAllBuses() {
		// TODO Auto-generated method stub
		return busRepository.findAll(Sort.by("ticketPrice"));
	}

	@Override
	public ResponseEntity<String> deleteById(long busId) {
		
		busRepository.deleteById(busId);
		return new ResponseEntity<String>("record deleted ", HttpStatus.OK);
		
	}

//	@Override
//	public Bus updateBus(Date departureDate, long busId) {
//		// TODO Auto-generated method stub
//		return busRepository.updateBus(departureDate, busId);
//	}

//	@Override
//	public Bus updateBus(Bus bus, long busId) {
//		
//		return busRepository.updateBus(bus, busId);
//	}

}
