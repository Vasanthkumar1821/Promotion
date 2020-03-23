package com.searchCruise.Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.searchCruise.Application.repository.CruisesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchCruiseApplication.class)
public class SearchCruiseApplicationTest {

	@Autowired
	private CruisesRepository cruiseRepo;

	@Test
	public void findAllCruises() {
		System.out.println("All cruisess  : " + cruiseRepo.findAll());
	}

	@Test
	public void hey() {
		String sDate = "Wed Mar 25 00:00:00 EDT 2020";
		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		// Date cruiseDate = null;
		try {
			Date cruiseDate = sdf.parse(sDate);
			System.out.println("cruise output : " + cruiseRepo.findAllBySailingdate(cruiseDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
