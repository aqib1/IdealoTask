package com.idealo.toyrobot.controller;

import static com.idealo.toyrobot.utils.URLS.TOY_ROBOT_URL_BASE;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_URL_DELETE;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_URL_GET_BY_ID;
import static com.idealo.toyrobot.utils.URLS.URL_TOY_ROBOT_URL_UPDATE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
@RestController
@RequestMapping(TOY_ROBOT_URL_BASE)
public class RobotController {
	private static final Logger logger = LoggerFactory.getLogger(RobotController.class);
	@Autowired
	private RobotBusiness robotBusiness;

	/**
	 * @param request
	 * @return
	 * <p></p>
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RobotResponseDto> createRobot(@RequestBody RobotRequestDto request) {
		RobotResponseDto response = robotBusiness.createToyRobot(request);
		logger.info("Response from createToyRobot recieved [" + response + "]");
		return ResponseEntity.ok().body(response);
	}

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = URL_TOY_ROBOT_URL_UPDATE, method = RequestMethod.PUT)
	public ResponseEntity<?> updateRobot(@PathVariable("id") String id, @RequestBody RobotRequestDto request) {
		robotBusiness.updateRobot(id, request);
		logger.info("Request [" + request + "] successfully updated against id[" + id + "]");
		return ResponseEntity.ok().build();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = URL_TOY_ROBOT_URL_GET_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<RobotDetailsResponse> getRobotById(@PathVariable("id") String id) {
		RobotDetailsResponse response = robotBusiness.getRobotById(id);
		logger.info("Response from getRobotById recieved [" + response + "]");
		return ResponseEntity.ok().body(response);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = URL_TOY_ROBOT_URL_DELETE, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRobotById(@PathVariable("id") String id) {
		robotBusiness.deleteRobotById(id);
		logger.info("Robot info successfully deleted against id[" + id + "]");
		return ResponseEntity.ok().build();
	}

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RobotDetailsResponse>> getAllRobots() {
		List<RobotDetailsResponse> response = robotBusiness.getAllRobots();
		logger.info("Response from getAllRobots recieved [" + response + "]");
		return ResponseEntity.ok().body(response);
	}
}
