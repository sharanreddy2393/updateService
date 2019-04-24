package com.HallBooking.updateService.dto;

import java.sql.Date;
import java.util.List;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.HallInformation;

public interface HallDao {

	public void SaveHallInfromation(HallRequest hallInfo);
	public void BookingHall(BookingInformationDTO bookingInfo);
	public List<HallInformation> GetHallInformationSearchByDate(Date StartDate, Date endDate);
}
