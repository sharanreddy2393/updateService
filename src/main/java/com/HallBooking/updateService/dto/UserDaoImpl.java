package com.HallBooking.updateService.dto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HallBooking.common.DTO.UserRequest;
import com.HallBooking.common.Entity.UserInfromation;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	EntityManager entityManager;

	public UserInfromation user;
	
	@Override
	public void SaveUserInformationDao(UserRequest userInfo) {
		user = MapUserinformation(userInfo);
		entityManager.persist(user);
	}

	@Override
	public void SaveUserProfilePicture(String profilePic, String emailId) {
		Query query=entityManager.createQuery("update UserInfromation set profile_pic=:pic where email=:mail");
		query.setParameter("pic",profilePic);
		query.setParameter("mail", emailId);
		query.executeUpdate();
	}
	
	public UserInfromation MapUserinformation(UserRequest userInfo) {
		user = new UserInfromation();
		user.setlName(userInfo.getlName());
		user.setfName(userInfo.getfName());
		user.setEmail(userInfo.getEmail());
		user.setActiveStatus(userInfo.getActiveStatus());
		user.setPassword(userInfo.getPassword());
		user.setPhoneNumber(userInfo.getPhoneNumber());
		user.setProfilePicture(userInfo.getProfilePicture());
		return user;
	}
}
