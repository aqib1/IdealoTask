package com.idealo.toyrobot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;
import com.idealo.toyrobot.service.PlaceService;
import com.idealo.toyrobot.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService {

	@Autowired
	private PlaceService placeService;

	@Autowired
	private RobotRepositoryService robotRepositoryService;

	@Override
	public RobotResponseDto createToyRobot(RobotRequestDto request) {
		Robot toyRobot = placeService.IOPlaceExecutor(request);
		return new RobotResponseDto().toyRobotId(robotRepositoryService.add(toyRobot));
	}

	@Override
	public void updateRobot(String id, RobotRequestDto request) {
		Robot toyRobot = placeService.IOPlaceExecutor(request);
		robotRepositoryService.update(id, toyRobot);
	}

	@Override
	public Robot getRobotById(String id) {
		return robotRepositoryService.findById(id);
	}

	@Override
	public int deleteRobotById(String id) {
		return robotRepositoryService.deleteById(id);
	}

}
