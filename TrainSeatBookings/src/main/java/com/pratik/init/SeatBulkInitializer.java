package com.pratik.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.pratik.model.Seat;
import com.pratik.service.SeatService;

@Component
public class SeatBulkInitializer implements ApplicationRunner {

	@Autowired
	private SeatService seatService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!seatService.areSeatsPresent()) {
			List<Seat> seatsToInsert = generateSeatsToInsert();
			seatService.bulkInsertSeats(seatsToInsert);
			System.out.println("Bulk insert completed.");
		} else {
			System.out.println("Seats already present, skipping bulk insert.");
		}
	}

	private List<Seat> generateSeatsToInsert() {
		List<Seat> seats = new ArrayList<>();
		seats.add(new Seat("A1", false, 1L));
		seats.add(new Seat("A2", true, 1L));
		// Add more seats as needed
		return seats;
	}
}
