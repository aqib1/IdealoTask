package com.idealo.toyrobot.controller;

import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_CREATE;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_DELETE;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_GET_ALL;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_GET_BY_ID;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_UPDATE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RobotDetailsResponse;
import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.business.RobotBusiness;

@RestController
public class RobotController {

	@Autowired
	private RobotBusiness robotBusiness;

	@RequestMapping(value = URL_TOY_ROBOT_CREATE, method = RequestMethod.POST)
	public ResponseEntity<RobotResponseDto> createRobot(@RequestBody RobotRequestDto request) {
		RobotResponseDto response = robotBusiness.createToyRobot(request);
		return ResponseEntity.ok().body(response);
	}

	@RequestMapping(value = URL_TOY_ROBOT_UPDATE, method = RequestMethod.PUT)
	public ResponseEntity<?> updateRobot(@PathVariable("id") String id, RobotRequestDto request) {
		robotBusiness.updateRobot(id, request);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = URL_TOY_ROBOT_GET_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<RobotDetailsResponse> getRobotById(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(robotBusiness.getRobotById(id));
	}

	@RequestMapping(value = URL_TOY_ROBOT_DELETE, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRobotById(@PathVariable("id") String id) {
		robotBusiness.deleteRobotById(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = URL_TOY_ROBOT_GET_ALL, method = RequestMethod.GET)
	public ResponseEntity<List<RobotDetailsResponse>> getAllRobots() {
		return ResponseEntity.ok().body(robotBusiness.getAllRobots());
	}
}
