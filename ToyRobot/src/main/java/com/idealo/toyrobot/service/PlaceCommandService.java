package com.idealo.toyrobot.service;

import com.example.model.RobotRequestDto;
import com.idealo.toyrobot.models.Robot;

public interface PlaceCommandService {
	Robot IOPlaceCommandExecutor(RobotRequestDto request);
}
