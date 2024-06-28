package com.pratik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratik.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	@Query("SELECT s FROM Seat s JOIN FETCH s.train")
	List<Seat> findAllWithTrainDetails();
}
