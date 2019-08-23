package com.idealo.toyrobot.controller;

import static com.idealo.toyrobot.utils.URLS.SIMULATOR_URL_BASE;
import static com.idealo.toyrobot.utils.URLS.SIMULATOR_URL_SIMULATE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;
import com.idealo.toyrobot.business.SimulatorBusiness;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/21/2019
 */
@RestController
@RequestMapping(SIMULATOR_URL_BASE)
public class SimulatorController {

	@Autowired
	private SimulatorBusiness simulatorBusiness;

	/**
	 * @param id
	 * @param requestDto
	 * @return
	 */
	@RequestMapping(value = SIMULATOR_URL_SIMULATE, method = RequestMethod.POST)
	public ResponseEntity<RobotSimulationResponseDto> simulateRobot(@PathVariable("id") String id,
			@RequestBody RobotSimulationRequestDto requestDto) {
		return ResponseEntity.ok().body(simulatorBusiness.simulateRobot(id, requestDto));
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = SIMULATOR_URL_SIMULATE, method = RequestMethod.GET)
	public ResponseEntity<RobotSimulationStackResponseDto> getSimulationsAgainstId(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(simulatorBusiness.getSimulationsAgainstId(id));
	}

}
