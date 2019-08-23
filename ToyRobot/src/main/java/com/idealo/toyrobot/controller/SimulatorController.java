package com.idealo.toyrobot.controller;

import static com.idealo.toyrobot.utils.URLS.SIMULATOR_URL_BASE;
import static com.idealo.toyrobot.utils.URLS.SIMULATOR_URL_SIMULATE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;

@RestController
@RequestMapping(SIMULATOR_URL_BASE)
public class SimulatorController {

	@RequestMapping(value = SIMULATOR_URL_SIMULATE, method = RequestMethod.POST)
	public ResponseEntity<RobotSimulationResponseDto> simulateRobot(@PathVariable("id") String id,
			@RequestBody RobotSimulationRequestDto requestDto) {

		return null;
	}
}
