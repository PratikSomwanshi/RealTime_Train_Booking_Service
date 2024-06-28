package com.pratik.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat {
	@Id
	@GeneratedValue
	private Long id;

	private String seatNumber;

	private Boolean isBooked = false;

	@ManyToOne(fetch = FetchType.LAZY) // Many seats belong to one train
	@JoinColumn(name = "train_id", nullable = false) // Specify foreign key column
	private Train train;

	@Column(name = "train_id", insertable = false, updatable = false) // Additional field for trainId
	private Long trainId; // Store the ID of the associated Train entity

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Seat(String seatNumber, Boolean isBooked, Long trainId) {
		this.seatNumber = seatNumber;
		this.isBooked = isBooked;
		this.trainId = trainId;
	}

}
