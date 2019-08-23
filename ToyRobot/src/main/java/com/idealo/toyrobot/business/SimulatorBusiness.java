package com.idealo.toyrobot.business;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.service.SimulatorService;

@Component
public class SimulatorBusiness {
	
	@Autowired
	private SimulatorService simulatorService;

	public RobotSimulationResponseDto simulateRobot(String id, RobotSimulationRequestDto requestDto) {
		checkCoreRequirements(requestDto);
		
		return null;
	}

	private void checkCoreRequirements(RobotSimulationRequestDto requestDto) {
		if (Objects.isNull(requestDto)) {
			throw new InvalidRequestException("Null request not allowed");
		}
		if (Objects.isNull(requestDto.getCommandsList())) {
			throw new InvalidRequestException("Null command list not allowed");
		}
		if (Objects.isNull(requestDto.getCommandsList().isEmpty())) {
			throw new InvalidRequestException("Empty command list not allowed");
		}
	}
}
