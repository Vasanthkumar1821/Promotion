package com.searchCruise.Application.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.searchCruise.Application.model.Cruises;
import com.searchCruise.Application.service.CruisesService;

@RequestMapping("/api")
@RestController
public class CruisesController {
	@Autowired
	private CruisesService cruisesService;

	@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/cruises")
	public List<Cruises> getAll() {
		System.out.println("printing alllll");
		return cruisesService.findAllCrusies();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/cruises/{state}/{destination}")
	public Cruises getStateAndDestination(@PathVariable String state, @PathVariable String destination) {

		Cruises theCruise = cruisesService.getbyStateAndDestination(state, destination);

		if (theCruise == null) {
			throw new RuntimeException("state Name and destination not found - " + state + "  " + destination);
		}
		return theCruise;
	}

	// get all details based on sailing date and state and destination
	@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/cruises/{state}/{destination}/{sailingdate}")
	public List<Cruises> getStateAndDestinationAndSailingdate(@PathVariable String state,
			@PathVariable String destination, @PathVariable Date sailingdate) {

		// Cruises
		List<Cruises> theCruise = cruisesService.getbyStateAndDestinationAndSailingdate(state, destination,
				sailingdate);
System.out.println("list==="+theCruise);
		if (theCruise == null) {
			throw new RuntimeException("state Name and destination and sailing date not found - " + state + "  "
					+ destination + " " + sailingdate);
		}
		return theCruise;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/cruisesDate/{sailingdate}")
	public Cruises getCruiseSailingdate(@PathVariable Date sailingdate) throws Exception {
		System.out.println("date section");

		Cruises theCruise = cruisesService.getbySailingdate(sailingdate);

		System.out.println("the cruise==" + theCruise);

		return theCruise;
	}
}
