package com.idealo.toyrobot.service;

import com.example.model.RobotRequestDto;
import com.idealo.toyrobot.models.Robot;

public interface PlaceService {
	Robot IOPlaceExecutor(RobotRequestDto request);
}
