package com.wipro.trainbookingproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.trainbookingproject.Dto.TrainDto;
import com.wipro.trainbookingproject.entity.Train;

public interface ITrainService {
	
	Train insertTrain(TrainDto trainDto);
	
	Train updateTrain(TrainDto Dto, long trainNumber);
	
	Train findTrainById(long trainNumber);
	
	String deleteTrainById(long trainNumber);
	
	List<Train> findAllTrains();
	
	
	

}
