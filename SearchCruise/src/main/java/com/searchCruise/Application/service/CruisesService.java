package com.searchCruise.Application.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.searchCruise.Application.model.Cruises;
import com.searchCruise.Application.repository.CruisesRepository;

@Service
public class CruisesService {

	@Autowired
	private CruisesRepository cruisesRepository;

	// reterive all
	public List<Cruises> findAllCrusies() {
		return cruisesRepository.findAll();
	}

	// reterive based on States
	public Cruises getbyState(String state) {
		return cruisesRepository.findByState(state);
	}

	// Reterive based on state and destination
	public Cruises getbyStateAndDestination(String state, String destination) {
		return cruisesRepository.findAllByStateAndDestination(state, destination);
	}

	// Reterive based on state and destination Sailing Date
	public List<Cruises> getbyStateAndDestinationAndSailingdate(String state, String destination, Date sailingdate) {
		List<Cruises> l = null;
		l = cruisesRepository.findAllByStateAndDestinationAndSailingdate(state, destination, sailingdate);
		return l;
	}

	// reterive by sailing Date
	public Cruises getbySailingdate(Date sailingdate) {

		System.out.println("Service code for date==" + sailingdate);
//		Date d=new Date("2015-02-02").toISOString();
		return cruisesRepository.findAllBySailingdate(sailingdate);

	}
}
