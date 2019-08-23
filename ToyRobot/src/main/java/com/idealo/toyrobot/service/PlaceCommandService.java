package com.idealo.toyrobot.service;

import com.example.model.RobotRequestDto;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/2019
 */
public interface PlaceCommandService {
	Robot IOPlaceCommandExecutor(RobotRequestDto request);
}
