package com.HallBooking.updateService.sor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.HallBooking.common.Entity.UserInfromation;

@FeignClient(name="UTILIZATION-SERVICE",url="localhost:8099")
public interface UserInfoService {
	@GetMapping("/getuserbyemail")
	UserInfromation getUserbyEmail(@RequestBody String emailid, @RequestBody String phonenum);
}
