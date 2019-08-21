package com.idealo.toyrobot.business;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.client.ToyRobotCreationRequest;
import com.example.client.ToyRobotCreationResponse;
import com.idealo.toyrobot.exceptions.InvalidRequestException;

@Component
public class ToyRobotSimulationBusiness {

	public ToyRobotCreationResponse createToyRobot(ToyRobotCreationRequest request) {
		if (Objects.isNull(request) || Objects.isNull(request.getCommandType()) || request.getCommandType().isEmpty()) {
			throw new InvalidRequestException("Request is empty or null");
		}

		return null;
	}

	public void simulateToyRobot(String id, ToyRobotCreationRequest request) {

	}

	public void getToyRobotSimulation(String id) {

	}
}
