package com.HallBooking.updateService.dto;

import com.HallBooking.common.DTO.HallRequest;
import com.HallBooking.common.Entity.HallInformation;

public interface HallDao {

	public void SaveHallInfromation(HallRequest hallInfo);
}
