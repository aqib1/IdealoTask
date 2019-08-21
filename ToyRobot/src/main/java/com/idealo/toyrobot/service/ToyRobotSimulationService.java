package com.idealo.toyrobot.service;

import com.example.model.ToyRobotCreationRequest;
import com.example.model.ToyRobotCreationResponse;

public interface ToyRobotSimulationService {

	ToyRobotCreationResponse createToyRobot(ToyRobotCreationRequest request);
}
