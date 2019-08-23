package com.idealo.toyrobot.service;

import java.util.List;

import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/2019
 *
 */
public interface RobotService {

	/**
	 * @param request
	 * @return
	 */
	RobotResponseDto createToyRobot(RobotRequestDto request);

	/**
	 * @param id
	 * @param request
	 */
	void updateRobot(String id, RobotRequestDto request);

	/**
	 * @param id
	 * @return
	 */
	Robot getRobotById(String id);

	/**
	 * @param id
	 * @return
	 */
	int deleteRobotById(String id);
	
	/**
	 * @return
	 */
	List<Robot> getAllRobots();
}
