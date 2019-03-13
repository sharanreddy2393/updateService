package com.HallBooking.updateService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.HallInformation;
import com.HallBooking.updateService.dto.HallDao;

@Service
public class HallServiceImpl implements HallService{

	@Autowired 
	HallDao hallDao;

	@Override
	public void SaveHallInfromation(HallRequest hallInfo) {
		hallDao.SaveHallInfromation(hallInfo);	
	}
}
