package com.HallBooking.updateService.dto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HallBooking.common.Entity.HallInformation;

@Repository
@Transactional
public class HallDaoImpl implements HallDao{

	@Autowired
	EntityManager entityManager;

	@Override
	public void SaveHallInfromation(HallInformation hallInfo) {
		entityManager.persist(hallInfo);
		
	}
}
