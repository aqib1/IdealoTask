package com.idealo.toyrobot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.Simulations;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.factory.CommandFactory;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;
import com.idealo.toyrobot.service.SimulatorService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/23/2019
 * 
 */
@Service
public class SimulatorServiceImpl implements SimulatorService {

	@Autowired
	private RobotRepositoryService robotRepositoryService;

	@Override
	public RobotSimulationResponseDto simulateRobot(String id, RobotSimulationRequestDto requestDto) {
		Robot robot = robotRepositoryService.findById(id);
		simulateRobot(robot, requestDto.getCommandsList());
		return new RobotSimulationResponseDto().reportList(robot.getToyRobotSimulator().getSimulationReport());
	}

	private void simulateRobot(Robot robot, List<String> commandsList) {
		for (String command : commandsList) {
			Simulations simulation = getSimulationFromCommand(command);
			Simulator simulator = CommandFactory.getSimulator(simulation);
			simulator.execute(robot);
		}
	}

	private Simulations getSimulationFromCommand(String command) {
		try {
			return Simulations.valueOf(command.toUpperCase());
		} catch (Exception e) {
			throw new InvalidRequestException("\nCommand send is not from valid commands [Move,Left,Right,Report]");
		}
	}

}
