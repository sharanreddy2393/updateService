package com.HallBooking.updateService.dto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HallBooking.common.DTO.BookingInformationDTO;
import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.BookingInformation;
import com.HallBooking.common.Entity.HallInformation;
import com.HallBooking.common.Entity.UserInfromation;

@Repository
@Transactional
public class HallDaoImpl implements HallDao{

	@Autowired
	EntityManager entityManager;

	private HallInformation hall;
	private BookingInformation info;
	
	@Override
	public void SaveHallInfromation(HallRequest hallInfo) {
		entityManager.persist(mapHallInformation(hallInfo));
	}
	
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
		return hall;
	}

	@Override
	public void BookingHall(BookingInformationDTO bookingInfo) {
		entityManager.persist(MapBookingInformation(bookingInfo));
	}

	private BookingInformation MapBookingInformation(BookingInformationDTO bookingInfo) {
		info = new BookingInformation();
		info.setAdvanceAmount(bookingInfo.getAdvanceAmount());
		info.setFromDate(bookingInfo.getFromDate());
		info.setToDate(bookingInfo.getToDate());
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
