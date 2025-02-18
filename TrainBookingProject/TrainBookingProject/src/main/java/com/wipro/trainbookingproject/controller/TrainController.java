package com.wipro.trainbookingproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.trainbookingproject.Dto.TrainDto;
import com.wipro.trainbookingproject.entity.Train;
import com.wipro.trainbookingproject.exception.DeleteIdNotFoundException;
import com.wipro.trainbookingproject.exception.TrainIdNotFoundException;
import com.wipro.trainbookingproject.globalexception.AllTrainsNotFoundException;
import com.wipro.trainbookingproject.service.ITrainService;
@RestController
@RequestMapping("/api/trains")
public class TrainController {
	
	@Autowired
	ITrainService iTrainService;
	
	
	@PostMapping("/insertTrain")
	@PreAuthorize("hasAuthority = ADMIN")
	public ResponseEntity<Train> insertTrain(@RequestBody TrainDto trainDto) {
	
		
			return new ResponseEntity<Train>(iTrainService.insertTrain(trainDto), HttpStatus.OK);
	}

	@PutMapping("/updateMapping/{trainNumber}")
	@PreAuthorize("hasAuthority = ADMIN")
	public ResponseEntity<Train> updateTrain(@RequestBody TrainDto trainDto, long trainNumber) {
		
		
		
		return new ResponseEntity<Train>(iTrainService.updateTrain(trainDto, trainNumber), HttpStatus.OK);
		
	}

	@GetMapping("/findTrainById/{trainNumber}")
	@PreAuthorize("hasAnyAuthority = {'USER', 'ADMIN'}")
	public ResponseEntity<Train> findTrainById(@PathVariable long trainNumber) throws TrainIdNotFoundException {
		
		Train trainById = iTrainService.findTrainById(trainNumber); 
		
		if(trainById != null) {
			return new ResponseEntity<Train>(trainById, HttpStatus.OK);
		} else {
			
			throw new TrainIdNotFoundException();
			
		}
		
	
	}

	@DeleteMapping("/delete/{trainNumber}")
	@PreAuthorize("hasAuthortiy = ADMIN")
	public ResponseEntity<String> deleteTrainById(@PathVariable long trainNumber) throws DeleteIdNotFoundException {
		
			Train trainById = iTrainService.findTrainById(trainNumber);
			if(trainById != null) {
				iTrainService.deleteTrainById(trainNumber);
				return new ResponseEntity<String>("Record Deleted", HttpStatus.OK);
			} else {
				throw new DeleteIdNotFoundException();
			}
	}

	@GetMapping("/findAllTrains")
	@PreAuthorize("hasAuthortiy = {'ADMIN', 'USER'}")
	public ResponseEntity<List<Train>> findAllTrains() throws AllTrainsNotFoundException {
		
		List<Train> allTrains = iTrainService.findAllTrains();
		
		if(allTrains != null) {
			return new ResponseEntity<List<Train>>(allTrains, HttpStatus.OK);
		} else {
			throw new AllTrainsNotFoundException();
		}
	}	

}
