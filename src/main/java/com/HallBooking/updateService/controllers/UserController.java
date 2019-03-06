package com.HallBooking.updateService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.HallBooking.common.Entity.UserInfromation;
import com.HallBooking.updateService.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	RestTemplate restTemplate;

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ResponseEntity<UserInfromation> saveUser(@RequestBody UserInfromation userInfo) {
		restTemplate = new RestTemplate();
		UserInfromation info = restTemplate.getForObject(
				"http://localhost:8099/getuserbyemail/" + userInfo.getEmail() +"/"+ userInfo.getPhoneNumber(),
				UserInfromation.class);
		if (info == null) {
			return new ResponseEntity<UserInfromation>(HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.CONFLICT);
	}
}
