package com.idealo.toyrobot.service;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;

public interface SimulatorService {
	RobotSimulationResponseDto simulateRobot(String id, RobotSimulationRequestDto requestDto);
}
