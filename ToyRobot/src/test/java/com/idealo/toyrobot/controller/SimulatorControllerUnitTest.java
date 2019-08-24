package com.idealo.toyrobot.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;
import com.idealo.toyrobot.business.SimulatorBusiness;
import com.idealo.toyrobot.helper.DataHelper;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class SimulatorControllerUnitTest {

	@MockBean
	private SimulatorBusiness simulatorBusiness;
	
	@Autowired
	private SimulatorController simulatorController;

	@Before
	public void init() {
		mockingSimulatorBusiness();
	}

	private void mockingSimulatorBusiness() {
		Mockito.when(simulatorBusiness.simulateRobot(Mockito.anyString(), Mockito.any(RobotSimulationRequestDto.class)))
				.thenReturn(DataHelper.getRobotSimulationResponseDto());
		Mockito.when(simulatorBusiness.getSimulationsAgainstId(Mockito.anyString()))
				.thenReturn(DataHelper.getRobotSimulationStackResponseDto());
	}
	
	@Test
	public void testFirstSimulateRobot() {
		ResponseEntity<RobotSimulationResponseDto> response = simulatorController.simulateRobot(DataHelper.UUID_ROBOT, DataHelper.getRobotSimulationRequestDto());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("1,1,EAST", response.getBody().getReport());
	}
	
	@Test
	public void getSimulationsAgainstId() {
		ResponseEntity<RobotSimulationStackResponseDto> response = simulatorController.getSimulationsAgainstId(DataHelper.UUID_ROBOT);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("1,1,EAST", response.getBody().getReportList().get(0));
	}
	
	
}
