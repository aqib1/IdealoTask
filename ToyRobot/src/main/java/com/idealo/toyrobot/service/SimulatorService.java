package com.idealo.toyrobot.service;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/2019
 */
public interface SimulatorService {

	/**
	 * @param id
	 * @param requestDto
	 * @return
	 */
	RobotSimulationResponseDto simulateRobot(String id, RobotSimulationRequestDto requestDto);

	/**
	 * @param id
	 * @return
	 */
	RobotSimulationStackResponseDto getSimulationsAgainstId(String id);
}
