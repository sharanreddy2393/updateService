package com.HallBooking.updateService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HallBooking.common.DTO.OwnerRequest;
import com.HallBooking.updateService.dto.OwnerDao;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	OwnerDao dao;
	
	@Override
	public void SaveHall(OwnerRequest ownerRequest) {
		dao.SaveHall(ownerRequest);
	}

}
