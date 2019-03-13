package com.HallBooking.updateService.dto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.HallInformation;

@Repository
@Transactional
public class HallDaoImpl implements HallDao{

	@Autowired
	EntityManager entityManager;

	HallInformation hall;
	
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
}
