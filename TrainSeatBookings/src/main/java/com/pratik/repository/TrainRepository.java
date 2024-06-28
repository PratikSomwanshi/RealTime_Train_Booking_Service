package com.pratik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratik.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {

}