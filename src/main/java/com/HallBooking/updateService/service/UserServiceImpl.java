package com.HallBooking.updateService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HallBooking.common.DTO.UserRequest;
import com.HallBooking.updateService.dto.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public void SaveUserInformation(UserRequest userInfo) {
		userDao.SaveUserInformationDao(userInfo);
	}

	@Override
	public void SaveUserProfilePicture(String profilePic, String email) {
		userDao.SaveUserProfilePicture(profilePic,email);
	}

}
