package com.pratik.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.model.City;
import com.pratik.model.Train;
import com.pratik.repository.CityRepository;
import com.pratik.repository.TrainRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class TrainService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private TrainRepository trainRepository;

	@Autowired
	private CityRepository cityRepository;

	public List<Train> getAllTrains() {
		return trainRepository.findAll();
	}

	public Optional<Train> getTrainById(Long id) {
		return trainRepository.findById(id);
	}

	@Transactional
	public Train createTrain(Train tr) {

		Train train = new Train();
		train.setTid(tr.getTid());
		train.setName(tr.getName());

		City departureCity = entityManager.find(City.class, tr.getDepartureCity().getCid());
		if (departureCity == null) {
			departureCity = new City();
			departureCity.setCid(tr.getDepartureCity().getCid());
			departureCity = cityRepository.save(departureCity);
		}
		train.setDepartureCity(departureCity);

		City arrivalCity = entityManager.find(City.class, tr.getArrivalCity().getCid());
		if (arrivalCity == null) {
			arrivalCity = new City();
			arrivalCity.setCid(tr.getArrivalCity().getCid());
			arrivalCity = cityRepository.save(arrivalCity);
		}
		train.setArrivalCity(arrivalCity);

		Train x = trainRepository.save(train);

		return x;
	}

	public void deleteTrain(Long id) {
		trainRepository.deleteById(id);
	}
}
