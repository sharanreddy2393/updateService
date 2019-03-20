package com.HallBooking.updateService.service;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
import com.HallBooking.common.Entity.HallInformation;

public interface HallService {

	public void SaveHallInfromation(HallRequest hallInfo);
	public void BookingHall(BookingInformationDTO bookingInfo);
}
