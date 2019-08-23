package com.idealo.toyrobot.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;
import com.example.model.Simulations;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.exceptions.RobotNotFoundException;
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

	/**
	 * @param id
	 * @param requestDto
	 * @return
	 */
	@Override
	public RobotSimulationResponseDto simulateRobot(String id, RobotSimulationRequestDto requestDto) {
		Robot robot = robotRepositoryService.findById(id);
		if (!Objects.isNull(robot))
			simulateRobot(robot, requestDto.getCommandsList());
		else
			throw new RobotNotFoundException("\nRobot not found against the given id [" + id + "]");

		return new RobotSimulationResponseDto().report(robot.getToyRobotSimulator().getCurrentReport());
	}

	/**
	 * @param robot
	 * @param commandsList
	 */
	private void simulateRobot(Robot robot, List<String> commandsList) {
		for (String command : commandsList) {
			Simulations simulation = getSimulationFromCommand(command);
			Simulator simulator = CommandFactory.getSimulator(simulation);
			simulator.execute(robot);
			if (simulation == Simulations.REPORT)
				break;
		}
	}

	/**
	 * @param command
	 * @return
	 */
	private Simulations getSimulationFromCommand(String command) {
		try {
			return Simulations.valueOf(command.toUpperCase());
		} catch (Exception e) {
			throw new InvalidRequestException("\nCommand send is not from valid commands [Move,Left,Right,Report]");
		}
	}

	/**
	 * @param id
	 */
	@Override
	public RobotSimulationStackResponseDto getSimulationsAgainstId(String id) {
		Robot robot = robotRepositoryService.findById(id);
		if (!Objects.isNull(robot))
			return new RobotSimulationStackResponseDto().reportList(robot.getToyRobotSimulator().getSimulationReport());
		else
			throw new RobotNotFoundException("\nRobot not found against the given id [" + id + "]");
	}

}
