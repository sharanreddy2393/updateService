package com.HallBooking.updateService.dto;

import com.HallBooking.common.DTO.UserRequest;

public interface UserDao {

	public void SaveUserInformationDao(UserRequest userInfo);
	public void SaveUserProfilePicture(String profilePic, String email);
}
