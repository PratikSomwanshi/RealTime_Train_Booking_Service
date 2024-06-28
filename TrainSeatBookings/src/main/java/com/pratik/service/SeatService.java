package com.pratik.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratik.model.Seat;
import com.pratik.model.Train;
import com.pratik.repository.SeatRepository;
import com.pratik.repository.TrainRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private TrainRepository trainRepository;

	@Transactional(readOnly = true)
	public boolean areSeatsPresent() {
		return seatRepository.count() > 0;
	}

	@Transactional
	public void bulkInsertSeats(List<Seat> seats) {
		LocalDateTime now = LocalDateTime.now();

		for (Seat seat : seats) {

			if (seat.getTrainId() != null) {
				Train train = trainRepository.findById(seat.getTrainId()).orElse(null);
				if (train != null) {
					seat.setTrain(train);
				} else {

					throw new NullPointerException("Train Not found");
				}
			} else {

				throw new NullPointerException("Train Not found");
			}

			seat.setCreatedAt(now);
			seat.setUpdatedAt(now);
		}

		seatRepository.saveAll(seats);
	}
}
