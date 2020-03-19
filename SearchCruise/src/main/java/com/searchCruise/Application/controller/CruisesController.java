package com.searchCruise.Application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	/*
	 * @CrossOrigin(origins = "http://localhost:8082")
	 * 
	 * @GetMapping("/cruises/{stateName}") public Cruises getState(@PathVariable
	 * String stateName) {
	 * 
	 * Cruises theCruise = cruisesService.getbyState(stateName);
	 * 
	 * if (theCruise == null) { throw new RuntimeException("state Name not found - "
	 * + stateName); }
	 * 
	 * return theCruise; }
	 */

	@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/cruises/{state}/{destination}")
	public Cruises getStateAndDestination(@PathVariable String state, @PathVariable String destination) {

		Cruises theCruise = cruisesService.getbyStateAndDestination(state, destination);

		if (theCruise == null) {
			throw new RuntimeException("state Name and destination not found - " + state + "  " + destination);
		}
		return theCruise;
	}

	@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/cruises/{sailingdate}")
	public Cruises getSailingdate(@PathVariable String sailingdate) throws Exception {
		System.out.println("date section");
		// String sDate1="31/12/1998";
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.US);

		// Date d=date1.parse(sailingdate);

		// Date d=sailingdate.format(date1);
		// System.out.println("date===" + date1);

		Cruises theCruise = cruisesService.getbySailingdate(sailingdate);

		System.out.println("the cruise==" + theCruise);
		if (theCruise == null) {
			throw new RuntimeException("Sailing date is not found - " + sailingdate);
		}
		
		return theCruise;
	}
}
