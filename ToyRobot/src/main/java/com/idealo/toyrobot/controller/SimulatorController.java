package com.idealo.toyrobot.controller;

import static com.idealo.toyrobot.utils.URLS.SIMULATOR_URL_BASE;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RobotSimulationRequestDto;

@RestController
@RequestMapping(SIMULATOR_URL_BASE)
public class SimulatorController {

	public void simulateRobot(@RequestBody RobotSimulationRequestDto requestDto) {

	}
}
