package com.idealo.toyrobot.service;

import java.util.List;

import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.models.Robot;

public interface RobotService {

	RobotResponseDto createToyRobot(RobotRequestDto request);

	void updateRobot(String id, RobotRequestDto request);

	Robot getRobotById(String id);

	int deleteRobotById(String id);
	
	List<Robot> getAllRobots();
}
