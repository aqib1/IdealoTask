package com.idealo.toyrobot.service;

import com.example.model.ToyRobotCreationRequest;
import com.idealo.toyrobot.models.ToyRobot;

public interface PlaceService {
	ToyRobot IOPlaceExecutor(ToyRobotCreationRequest request);
}
