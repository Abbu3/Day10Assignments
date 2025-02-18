package com.wipro.trainbookingproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.trainbookingproject.Dto.TrainDto;
import com.wipro.trainbookingproject.entity.Train;
import com.wipro.trainbookingproject.repository.TrainRepository;
@Service
public class TrainServiceImpl implements ITrainService {
	@Autowired
	TrainRepository trainRepository;

	@Override
	public Train insertTrain(TrainDto trainDto) {
		
			
		 Train train = new Train();
		train.setTrainNumber(trainDto.getTrainNumber());
		train.setTrainName(trainDto.getTrainName());
		train.setTicketId(trainDto.getTicketId());
		train.setPassengerName(trainDto.getPassengerName());
		train.setTicketPrice(trainDto.getTicketPrice());
		train.setDepartureTime(trainDto.getDepartureTime());
		train.setArrivalTime(trainDto.getArrivalTime());
		train.setMobileNumber(trainDto.getMobileNumber());
		train.setEmail(trainDto.getEmail());
		train.setSourceStation(trainDto.getSourceStation());
		train.setDestinationStation(trainDto.getDestinationStation());
		
		return trainRepository.save(train);
			
		}
//		Train train = new Train();
//		train.setTrainNumber(trainDto.getTrainNumber());
//		train.setTrainName(trainDto.getTrainName());
//		train.setTicketId(trainDto.getTicketId());
//		train.setTicketPrice(trainDto.getTicketPrice());
//		train.setDepartureTime(trainDto.getDepartureTime());
//		train.setArrivalTime(trainDto.getArrivalTime());
//		train.setMobileNumber(trainDto.getMobileNumber());
//		train.setEmail(trainDto.getEmail());
//		train.setSourceStation(trainDto.getSourceStation());
//		train.setDestinationLocation(trainDto.getDestinationLocation());
	


	@Override
	public Train updateTrain(TrainDto trainDto, long trainNumber) {
		
		Train train = new Train();
			train.setTrainNumber(trainDto.getTrainNumber());
			train.setTrainName(trainDto.getTrainName());
			train.setTicketId(trainDto.getTicketId());
			train.setPassengerName(trainDto.getPassengerName());
			train.setTicketPrice(trainDto.getTicketPrice());
			train.setDepartureTime(trainDto.getDepartureTime());
			train.setArrivalTime(trainDto.getArrivalTime());
			train.setMobileNumber(trainDto.getMobileNumber());
			train.setEmail(trainDto.getEmail());
			train.setSourceStation(trainDto.getSourceStation());
			train.setDestinationStation(trainDto.getDestinationStation());
			
		
		return trainRepository.save(train);
		
	}

	@Override
	public Train findTrainById(long trainNumber) {
		
		return trainRepository.findById(trainNumber).orElse(null);
	}

	
	@Override
	public List<Train> findAllTrains() {
		return trainRepository.findAll();
	}
	
	
	@Override
	public String deleteTrainById(long trainNumber) {
		trainRepository.deleteById(trainNumber);
		return "record deleted" +trainNumber;
	}
	
	

}
