package com.idealo.toyrobot.business;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.ToyRobotCreationRequest;
import com.example.model.ToyRobotCreationResponse;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.service.ToyRobotSimulationService;

@Component
public class ToyRobotSimulationBusiness {

	@Autowired
	private ToyRobotSimulationService tRSService;

	public ToyRobotCreationResponse createToyRobot(ToyRobotCreationRequest request) {
		if (Objects.isNull(request)) {
			throw new InvalidRequestException("Request is empty or null");
		}
		if (Objects.isNull(request.getPlaceCommand()) || request.getPlaceCommand().isEmpty()) {
			throw new InvalidRequestException("Place command is empty or null, please set command first.");
		}
		if (Objects.isNull(request.getRobotName()) || request.getRobotName().isEmpty()) {
			throw new InvalidRequestException("Robot name is required, please set a name for your robot.");
		}

		return tRSService.createToyRobot(request);
	}

	public void simulateToyRobot(String id, ToyRobotCreationRequest request) {

	}

	public void getToyRobotSimulation(String id) {

	}
}
