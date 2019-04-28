package com.HallBooking.updateService.dto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HallBooking.common.DTO.OwnerRequest;
import com.HallBooking.common.Entity.OwnerInformation;

@Repository
@Transactional
public class OwnerDaoImpl implements OwnerDao{
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void SaveHall(OwnerRequest ownerRequest) {
		OwnerInformation info= MapOwnerInfo(ownerRequest);
		entityManager.persist(info);
	}
	
	private OwnerInformation MapOwnerInfo(OwnerRequest ownerRequest) {
		OwnerInformation info= new OwnerInformation();
		info.setfName(ownerRequest.getfName());
		info.setlName(ownerRequest.getlName());
		info.setAddress(ownerRequest.getAddress());
		info.setAdharNumber(ownerRequest.getAdharNumber());
		info.setEmail(ownerRequest.getEmail());
		info.setPassword(ownerRequest.getPassword());
		info.setPhoneNumber(ownerRequest.getPhoneNumber());
		info.setProfilePicture(ownerRequest.getProfilePicture());
		info.setActiveStatus(ownerRequest.getActiveStatus());
		return info;
		
	}

}
