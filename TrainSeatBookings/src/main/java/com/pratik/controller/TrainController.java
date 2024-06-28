package com.pratik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.exception.CustomException;
import com.pratik.model.Train;
import com.pratik.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	private TrainService trainService;

	@PostMapping
	public ResponseEntity<Train> set(@RequestBody Train train) {
		try {
			Train createdTrain = trainService.createTrain(train);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdTrain);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
