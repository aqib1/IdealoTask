package com.idealo.toyrobot.controller;

import static com.idealo.toyrobot.utils.URLS.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.ToyRobotCreationRequest;
import com.example.model.ToyRobotCreationResponse;
import com.idealo.toyrobot.business.ToyRobotSimulationBusiness;

@RestController
public class ToyRobotSimulationController {

	@Autowired
	private ToyRobotSimulationBusiness tRSBusiness;

	@RequestMapping(value = URL_TOY_ROBOT, method = RequestMethod.POST)
	public ToyRobotCreationResponse createToyRobot(ToyRobotCreationRequest request) {
		tRSBusiness.createToyRobot(request);

		return null;
	}

	@RequestMapping(value = URL_TOY_ROBOT_UPDATE, method = RequestMethod.PUT)
	public void simulateToyRobot(@PathVariable("id") String id, ToyRobotCreationRequest request) {

	}

	@RequestMapping(value = URL_TOY_ROBOT_GET, method = RequestMethod.GET)
	public void getToyRobotSimulation(@PathVariable("id") String id) {

	}

	@RequestMapping(value = URL_TOY_ROBOT_DELETE, method = RequestMethod.DELETE)
	public void deleteToyRobotSimulation(@PathVariable("id") String id) {

	}
}
