package com.HallBooking.updateService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HallBooking.common.Entity.UserInfromation;
import com.HallBooking.updateService.dto.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public void SaveUserInformation(UserInfromation userInfo) {
		userDao.SaveUserInformationDao(userInfo);
		
	}

}
