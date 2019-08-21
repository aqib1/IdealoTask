package com.idealo.toyrobot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.ToyRobotCreationRequest;
import com.example.model.ToyRobotCreationResponse;
import com.idealo.toyrobot.models.ToyRobot;
import com.idealo.toyrobot.service.PlaceService;
import com.idealo.toyrobot.service.ToyRobotSimulationService;

@Service
public class ToyRobotSimulationServiceImpl implements ToyRobotSimulationService{

	@Autowired
	private PlaceService placeService;
	
	@Override
	public ToyRobotCreationResponse createToyRobot(ToyRobotCreationRequest request) {
		
		ToyRobot toyRobot = placeService.IOPlaceExecutor(request);
		
		return new ToyRobotCreationResponse().toyRobotId(toyRobot.getUuid());
	}

}
