package com.pratik.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.model.City;
import com.pratik.repository.CityRepository;

@RestController
public class CityController {

	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/city")
	public Optional<City> get() {
		return cityRepository.findById("IN005");
	}
}
