package com.HallBooking.updateService.sor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HallBooking.common.Entity.HallInformation;
import com.HallBooking.common.Entity.OwnerInformation;
import com.HallBooking.common.Entity.UserInfromation;
import com.amazonaws.ClientConfiguration;

@FeignClient(name = "utilization-service")
public interface UtilizationInformation {
	@RequestMapping(value = "/getuserbyemail/{email}/{phonenum}", method = RequestMethod.GET)
	UserInfromation getUserbyEmail(@PathVariable(value = "email") String emailid,
			@PathVariable(value = "phonenum") String phonenum);

	@RequestMapping(value = "/getHallInfo/{munciplaId}", method = RequestMethod.GET)
	HallInformation GetHallDetails(@PathVariable(value = "munciplaId") String muncipalId);

	@RequestMapping(value = "/getownerinfo/{adhar}/{email}/{phonenum}", method = RequestMethod.GET)
	OwnerInformation GetOwnerInformation(@PathVariable(value = "adhar") String adharNum,@PathVariable(value="email") String email,
			@PathVariable(value="phonenum") String phoneNumber);
}
