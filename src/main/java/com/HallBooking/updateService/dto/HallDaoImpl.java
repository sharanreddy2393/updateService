package com.HallBooking.updateService.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

	
	@Override
	public List<HallInformation> GetHallInformationSearchByDate(Date fromdate, Date todate) {
		Query q=  entityManager.createNativeQuery("select * from hall_information h "
				+ "where h.hallid != (select hallid from booking_information b where ((b.fromdate=:fromdate"
				+ " and b.todate=:todate) or\r\n" + 
				"(b.fromdate = :fromdate or b.todate= :todate) "
				+ " or ( b.fromdate =:fromdate or b.todate= :todate) or\r\n" + 
				"( b.fromdate between :fromdate and :todate) "
				+ "or ( b.todate between :fromdate and :todate) ))");
		
		q.setParameter("fromdate", fromdate);
		q.setParameter("todate", todate);
		@SuppressWarnings("unchecked")
		List<HallInformation> hallInfo = q.getResultList();
		return hallInfo;
		
	}
}
