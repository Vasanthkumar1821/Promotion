package com.searchCruise.Application.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.searchCruise.Application.model.Cruises;

@Repository
public interface CruisesRepository extends MongoRepository<Cruises, String> {
	public Cruises findByState(String state);

	public Cruises findAllByStateAndDestination(String state, String destination);

	public Cruises findAllByStateAndDestinationAndSailingdate(String state, String destination, Date sailingdate);

	public Cruises findAllBySailingdate(Date sailingdate);
}
