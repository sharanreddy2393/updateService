package com.HallBooking.updateService.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
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

	@Override
	public void BookingHall(BookingInformationDTO bookingInfo) {
		hallDao.BookingHall(bookingInfo);
		
	}

	@Override
	public List<HallInformation> GetHallInformationSearchByDate(Date StartDate, Date endDate) {
		 return hallDao.GetHallInformationSearchByDate(StartDate, endDate);
	}
}
