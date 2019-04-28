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
import com.HallBooking.updateService.mapper.HallInformationMapper;

@Repository
@Transactional
public class HallDaoImpl implements HallDao{

	@Autowired
	EntityManager entityManager;

	HallInformationMapper mapper;
	
	private HallInformation hallDetails;
	private BookingInformation BookingDetails;
	
	@Override
	public void SaveHallInfromation(HallRequest hallInfo) {
		hallDetails = mapper.mapHallInformation(hallInfo);
		entityManager.persist(hallDetails);
	}
	
	
	@Override
	public void BookingHall(BookingInformationDTO bookingInfo) {
		BookingDetails= mapper.MapBookingInformation(bookingInfo);
		entityManager.persist(BookingDetails);
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
