package com.pratik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.dto.SuccessResponse;
import com.pratik.exception.CustomException;
import com.pratik.model.Seat;
import com.pratik.repository.SeatRepository;

@RestController
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	private SeatRepository seatRepository;

	@GetMapping
	public ResponseEntity<SuccessResponse<Seat>> getAllSeats() {

		try {
			List<Seat> seats = seatRepository.findAllWithTrainDetails();

			SuccessResponse<Seat> response = new SuccessResponse<>(true, "Successfully Fetched All Record", seats);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
