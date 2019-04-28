package com.HallBooking.updateService.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.HallInformation;
import com.HallBooking.updateService.service.HallService;
import com.HallBooking.updateService.sor.UtilizationInformation;

@RestController
public class HallController {

	@Autowired
	HallService hallService;
	
	@Autowired
    private UtilizationInformation utiliationInfo;
		
	@RequestMapping(value="/savehall",method=RequestMethod.POST)
	public ResponseEntity<?> SaveHallInformation(@RequestBody HallRequest hallInfo) {	
		HallInformation hInfo = utiliationInfo.GetHallDetails(hallInfo.getMuncipalRegistration());	
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
	
	@RequestMapping(value="/getHallDetailsbyDate")
	public List<HallInformation> GetHallInformationsSearcgByDate(@RequestParam Date startDate,@RequestParam Date endDate) {
		return hallService.GetHallInformationSearchByDate(startDate, endDate);
	}
}
