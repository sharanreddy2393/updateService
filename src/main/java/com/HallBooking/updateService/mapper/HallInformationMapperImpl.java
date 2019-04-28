package com.HallBooking.updateService.mapper;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
import com.HallBooking.common.Entity.HallInformation;
import com.HallBooking.common.Entity.OwnerInformation;
import com.HallBooking.common.Entity.UserInfromation;

public class HallInformationMapperImpl implements HallInformationMapper{

	private HallInformation hall;
	private BookingInformation info;
	
	@Override
	public HallInformation mapHallInformation(HallRequest hallInfo) {
		hall= new HallInformation();
		hall.setHallName(hallInfo.getHallName());
		hall.setMuncipalRegistration(hallInfo.getMuncipalRegistration());
		hall.setHallDescription(hallInfo.getHallDescription());
		hall.setLocality(hallInfo.getLocality());
		hall.setCity(hallInfo.getCity());
		hall.setLandmark(hallInfo.getLandmark());
		hall.setState(hallInfo.getState());
		hall.setCountry(hallInfo.getCountry());
		hall.setPincode(hallInfo.getPincode());
		hall.setAdvanceAmount(hallInfo.getAdvanceAmount());
		hall.setFullAmount(hallInfo.getFullAmount());
		hall.setHallAvailability(hallInfo.getHallAvailability());
		hall.setHallCapacity(hallInfo.getHallCapacity());
		OwnerInformation oinfo = new OwnerInformation();
		oinfo.setOwnerId(hallInfo.getOwnerid());
		hall.setOwnerid(oinfo);
		return hall;
	}


	@Override
	public BookingInformation MapBookingInformation(BookingInformationDTO bookingInfo) {
		info = new BookingInformation();
		info.setAdvanceAmount(bookingInfo.getAdvanceAmount());
		info.setFromDate(new java.sql.Date( bookingInfo.getFromDate().getTime()));
		info.setToDate( new java.sql.Date(bookingInfo.getToDate().getTime()));
		info.setNumOfDays(bookingInfo.getNumOfDays());
		UserInfromation uinfo= new UserInfromation();
		uinfo.setUserId(bookingInfo.getUserId());
		info.setUserId(uinfo);
		HallInformation hinfo = new HallInformation();
		hinfo.setHallId(bookingInfo.getHallId());
		info.setHallId(hinfo);
		return info;
	}

}
