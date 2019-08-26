package com.idealo.toyrobot.business;

import static com.idealo.toyrobot.utils.Constants.ERROR;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.model.RobotDetailsResponse;
import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.exceptions.EmptyDataSetException;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.exceptions.RobotNotFoundException;
import com.idealo.toyrobot.mappers.RobotDetailsResponseMapper;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.service.RobotService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
@Component
public class RobotBusiness {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotBusiness.class);

	@Autowired
	private RobotService robotService;

	@Autowired
	private RobotDetailsResponseMapper robotDetailsResponseMapper;

	/**
	 * @param request
	 * @return
	 */
	public RobotResponseDto createToyRobot(RobotRequestDto request) {
		checkCoreRequirements(request);
		return robotService.createToyRobot(request);
	}

	/**
	 * @param id
	 * @param request
	 */
	public void updateRobot(String id, RobotRequestDto request) {
		checkCoreRequirements(request);
		robotService.updateRobot(id, request);
	}

	/**
	 * @param id
	 * @return
	 */
	public RobotDetailsResponse getRobotById(String id) {
		logger.info("Getting response against id "+ id);
		Robot robot = robotService.getRobotById(id);
		if (Objects.isNull(robot)) {
			throw new RobotNotFoundException("\nRobot again id [" + id + "] not found!");
		}
		return robotDetailsResponseMapper.robotToRobotDetailsResponse(robot);
	}

	/**
	 * @param id
	 */
	public void deleteRobotById(String id) {
		logger.info("deleting response against id "+ id);
		int r = robotService.deleteRobotById(id);
		if (r == ERROR)
			throw new RobotNotFoundException("\nRobot again id [" + id + "] not found!");
	}

	/**
	 * @return
	 */
	public List<RobotDetailsResponse> getAllRobots() {
		logger.info("Getting all robots");
		List<Robot> robots = robotService.getAllRobots();
		if (robots.isEmpty())
			throw new EmptyDataSetException("\nData is empty!! [Please add robots first]");
		return robotDetailsResponseMapper.robotsListToRobotDetailsResponseList(robots);
	}

	/**
	 * @param request
	 */
	private void checkCoreRequirements(RobotRequestDto request) {
		logger.info("Checking core requirements for request ["+request+"]");
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
