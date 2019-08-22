package com.idealo.toyrobot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;
import com.idealo.toyrobot.service.PlaceCommandService;
import com.idealo.toyrobot.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService {

	@Autowired
	private PlaceCommandService placeService;

	@Autowired
	private RobotRepositoryService robotRepositoryService;

	@Override
	public RobotResponseDto createToyRobot(RobotRequestDto request) {
		Robot toyRobot = placeService.IOPlaceCommandExecutor(request);
		return new RobotResponseDto().toyRobotId(robotRepositoryService.add(toyRobot));
	}

	@Override
	public void updateRobot(String id, RobotRequestDto request) {
		Robot toyRobot = placeService.IOPlaceCommandExecutor(request);
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

	@Override
	public List<Robot> getAllRobots() {
		return robotRepositoryService.findAll();
	}

}
