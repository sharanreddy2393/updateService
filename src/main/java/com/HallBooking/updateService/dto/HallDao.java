package com.HallBooking.updateService.dto;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;

public interface HallDao {

	public void SaveHallInfromation(HallRequest hallInfo);
	public void BookingHall(BookingInformationDTO bookingInfo);
}
