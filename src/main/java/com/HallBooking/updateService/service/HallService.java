package com.HallBooking.updateService.service;


import java.sql.Date;
import java.util.List;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
import com.HallBooking.common.Entity.HallInformation;

public interface HallService {

	public void SaveHallInfromation(HallRequest hallInfo);
	public void BookingHall(BookingInformationDTO bookingInfo);
	public List<HallInformation> GetHallInformationSearchByDate(Date StartDate, Date endDate);
}
