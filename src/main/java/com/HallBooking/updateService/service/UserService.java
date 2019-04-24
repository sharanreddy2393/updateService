package com.HallBooking.updateService.service;

import com.HallBooking.common.DTO.UserRequest;
import com.HallBooking.common.Entity.UserInfromation;

public interface UserService {

	public void SaveUserInformation(UserRequest userInfo);
	public void SaveUserProfilePicture(String profilePic, String email);
}
