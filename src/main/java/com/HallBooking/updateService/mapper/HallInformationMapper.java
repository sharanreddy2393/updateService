package com.HallBooking.updateService.mapper;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
import com.HallBooking.common.Entity.HallInformation;

public interface HallInformationMapper {

	public HallInformation mapHallInformation(HallRequest hallInfo);
	
	public BookingInformation MapBookingInformation(BookingInformationDTO bookingInfo);
}
