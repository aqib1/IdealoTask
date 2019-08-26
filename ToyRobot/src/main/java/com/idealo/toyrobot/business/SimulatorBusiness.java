package com.idealo.toyrobot.business;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.service.SimulatorService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/23/2019
 */
@Component
public class SimulatorBusiness {
	
	private static final Logger logger = LoggerFactory.getLogger(SimulatorBusiness.class);
	
	@Autowired
	private SimulatorService simulatorService;

	/**
	 * @param id
	 * @param requestDto
	 * @return
	 */
	public RobotSimulationResponseDto simulateRobot(String id, RobotSimulationRequestDto requestDto) {
		checkCoreRequirements(requestDto);
		return simulatorService.simulateRobot(id, requestDto);
	}

	/**
	 * @param id
	 * @return
	 */
	public RobotSimulationStackResponseDto getSimulationsAgainstId(String id) {
		return simulatorService.getSimulationsAgainstId(id);
	}

	/**
	 * @param requestDto
	 */
	private void checkCoreRequirements(RobotSimulationRequestDto requestDto) {
		logger.info("Checking core requirements against request ["+requestDto+"]");
		if (Objects.isNull(requestDto)) {
			throw new InvalidRequestException("Null request not allowed");
		}
		if (Objects.isNull(requestDto.getCommandsList())) {
			throw new InvalidRequestException("Null command list not allowed");
		}
		if (requestDto.getCommandsList().isEmpty()) {
			throw new InvalidRequestException("Empty command list not allowed");
		}
	}
}
