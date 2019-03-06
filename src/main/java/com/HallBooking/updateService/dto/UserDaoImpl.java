package com.HallBooking.updateService.dto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HallBooking.common.Entity.UserInfromation;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	EntityManager entityManager;

	@Override
	public void SaveUserInformationDao(UserInfromation userInfo) {
		entityManager.persist(userInfo);
		
	}
}
