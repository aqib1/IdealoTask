package com.idealo.toyrobot.business;

import static com.idealo.toyrobot.utils.Constants.ERROR;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.exceptions.EmptyDataSetException;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.exceptions.RobotNotFoundException;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.service.RobotService;

@Component
public class RobotBusiness {

	@Autowired
	private RobotService robotService;

	public RobotResponseDto createToyRobot(RobotRequestDto request) {
		checkCoreRequirements(request);
		return robotService.createToyRobot(request);
	}

	public void updateRobot(String id, RobotRequestDto request) {
		checkCoreRequirements(request);
		robotService.updateRobot(id, request);
	}

	public Robot getRobotById(String id) {
		Robot robot = robotService.getRobotById(id);
		if (Objects.isNull(robot)) {
			throw new RobotNotFoundException("\nRobot again id [" + id + "] not found!");
		}
		return robot;
	}

	public void deleteRobotById(String id) {
		int r = robotService.deleteRobotById(id);
		if (r == ERROR)
			throw new RobotNotFoundException("\nRobot again id [" + id + "] not found!");
	}
	
	public List<Robot> getAllRobots() {
		List<Robot> robots = robotService.getAllRobots();
		if(robots.isEmpty())
			throw new EmptyDataSetException("\nData is empty!! [Please add robots first]");
		return robots;
	}
	
	private void checkCoreRequirements(RobotRequestDto request) {
		if (Objects.isNull(request)) {
			throw new InvalidRequestException("Request is empty or null");
		}
		if (Objects.isNull(request.getPlaceCommand()) || request.getPlaceCommand().isEmpty()) {
			throw new InvalidRequestException("Place command is empty or null, please set command first.");
		}
		if (Objects.isNull(request.getRobotName()) || request.getRobotName().isEmpty()) {
			throw new InvalidRequestException("Robot name is required, please set a name for your robot.");
		}
	}
}
