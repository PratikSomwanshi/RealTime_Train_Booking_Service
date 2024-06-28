package com.pratik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratik.model.City;

public interface CityRepository extends JpaRepository<City, String> {

}
