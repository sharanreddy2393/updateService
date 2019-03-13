package com.HallBooking.updateService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.HallBooking.common.DTO.UserRequest;
import com.HallBooking.common.Entity.UserInfromation;
import com.HallBooking.updateService.amazonS3client.AmazonClient;
import com.HallBooking.updateService.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	RestTemplate restTemplate;
	
	private AmazonClient amazonClient;

    @Autowired
    UserController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ResponseEntity<UserInfromation> saveUser(@RequestBody UserRequest userInfo) {
		restTemplate = new RestTemplate();
		UserInfromation info = restTemplate.getForObject(
				"http://localhost:8099/getuserbyemail/" + userInfo.getEmail() +"/"+ userInfo.getPhoneNumber(),
				UserInfromation.class);
		if (info == null) {
			userService.SaveUserInformation(userInfo);
			return new ResponseEntity<UserInfromation>(HttpStatus.OK);
		} else
			return new ResponseEntity<UserInfromation>(HttpStatus.CONFLICT);
	}
    
	@PostMapping("/uploadfile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file,@RequestParam(value = "email") String emailId) {
        String profilePicUrl = amazonClient.uploadFile(file,emailId);
        userService.SaveUserProfilePicture(profilePicUrl, emailId);
        return "successfully uploaded";
    }
}
