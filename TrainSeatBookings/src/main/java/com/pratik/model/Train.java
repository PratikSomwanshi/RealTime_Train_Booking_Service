package com.pratik.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Train {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "train_id", nullable = false)
	private String tid;

	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departure_city_id", referencedColumnName = "city_id")
	private City departureCity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "arrival_city_id", referencedColumnName = "city_id")
	private City arrivalCity;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	public Train() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
}
