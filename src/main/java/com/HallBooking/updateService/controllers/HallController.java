package com.HallBooking.updateService.controllers;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
import com.HallBooking.common.Entity.HallInformation;
import com.HallBooking.common.Entity.UserInfromation;
import com.HallBooking.updateService.service.HallService;

@RestController
public class HallController {

	@Autowired
	HallService hallService;
	
	RestTemplate restTemplate;
	
	@RequestMapping(value="/savehall",method=RequestMethod.POST)
	public ResponseEntity<?> SaveHallInformation(@RequestBody HallRequest hallInfo) {	
		restTemplate = new RestTemplate();
		HallInformation hInfo= restTemplate.getForObject("http://localhost:8099/getHallInfo/"+hallInfo.getMuncipalRegistration(), HallInformation.class);
		if(hInfo == null)
		{
		hallService.SaveHallInfromation(hallInfo);
		return new ResponseEntity<HallInformation>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<HallInformation>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/bookhall",method=RequestMethod.POST)
	public ResponseEntity<?> BookingHall(@RequestBody BookingInformationDTO bookInfo) {
		hallService.BookingHall(bookInfo);
		 return new ResponseEntity<HallInformation>(HttpStatus.OK);
	}
	
}
