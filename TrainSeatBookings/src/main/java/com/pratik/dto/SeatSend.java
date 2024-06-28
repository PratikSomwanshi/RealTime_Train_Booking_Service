package com.pratik.dto;

import java.time.LocalDateTime;

import com.pratik.model.Seat;
import com.pratik.model.Train;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatSend {
	private Long id;
	private String seatNumber;
	private Boolean isBooked;
	private Long trainId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Train train;

	// Getters and setters
	// Constructor
	// Other methods as needed

	public SeatSend() {
		// TODO Auto-generated constructor stub
	}

	// Example constructor to convert Seat entity to SeatDTO
	public SeatSend(Seat seat) {
		this.id = seat.getId();
		this.seatNumber = seat.getSeatNumber();
		this.isBooked = seat.getIsBooked();
		this.trainId = seat.getTrainId();
		this.createdAt = seat.getCreatedAt();
		this.updatedAt = seat.getUpdatedAt();
		this.train = seat.getTrain();
	}
}
