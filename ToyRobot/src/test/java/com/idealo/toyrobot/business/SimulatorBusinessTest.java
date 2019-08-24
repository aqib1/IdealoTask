package com.idealo.toyrobot.business;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.service.SimulatorService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class SimulatorBusinessTest {

	@MockBean
	private SimulatorService simulatorService;

	@Autowired
	private SimulatorBusiness simulatorBusiness;

	@Before
	public void init() {
		mockingServiceComponents();
	}

	private void mockingServiceComponents() {
		Mockito.when(simulatorService.simulateRobot(Mockito.anyString(), Mockito.any(RobotSimulationRequestDto.class)))
				.thenReturn(DataHelper.getRobotSimulationResponseDto());
		Mockito.when(simulatorService.getSimulationsAgainstId(Mockito.anyString()))
				.thenReturn(DataHelper.getRobotSimulationStackResponseDto());
	}

	@Test
	public void testSimulateRobot() {
		RobotSimulationResponseDto response = simulatorBusiness.simulateRobot(DataHelper.UUID_ROBOT,
				DataHelper.getRobotSimulationRequestDto());
		Assert.assertEquals("1,1,EAST", response.getReport());
	}

	@Test(expected = InvalidRequestException.class)
	public void testSimulateRobotWithNull() {
		simulatorBusiness.simulateRobot(DataHelper.UUID_ROBOT, null);
	}

	@Test(expected = InvalidRequestException.class)
	public void testSimulateRobotWithEmpty() {
		simulatorBusiness.simulateRobot(DataHelper.UUID_ROBOT, DataHelper.getRobotSimulationEmptyRequestDto());
	}

	@Test
	public void testGetSimulationsAgainstId() {
		RobotSimulationStackResponseDto response = simulatorBusiness.getSimulationsAgainstId(DataHelper.UUID_ROBOT);
		List<String> result = List.of("1,1,EAST");
		Assert.assertEquals(result, response.getReportList());
	}

}
