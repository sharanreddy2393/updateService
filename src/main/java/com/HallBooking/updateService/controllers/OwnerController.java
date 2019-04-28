package com.HallBooking.updateService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HallBooking.common.DTO.OwnerRequest;
import com.HallBooking.common.Entity.OwnerInformation;
import com.HallBooking.updateService.service.OwnerService;
import com.HallBooking.updateService.sor.UtilizationInformation;

@RestController
public class OwnerController {

	@Autowired
	OwnerService service;

	@Autowired
	UtilizationInformation utilization;

	OwnerInformation ownerInfo;

	@RequestMapping(value = "/saveowner", method = RequestMethod.POST)
	public String SaveOwner(@RequestBody OwnerRequest ownerRequest) {
		ownerInfo = utilization.GetOwnerInformation(ownerRequest.getAdharNumber(), ownerRequest.getEmail(),
				ownerRequest.getPhoneNumber());
		if (ownerInfo == null) {
			service.SaveHall(ownerRequest);
			return "saveHall";
		} else {
			return "data exist";
		}
	}
}
