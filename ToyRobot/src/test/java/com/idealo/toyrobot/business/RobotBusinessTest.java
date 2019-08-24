package com.idealo.toyrobot.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.service.RobotService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class RobotBusinessTest {

	@MockBean
	private RobotService robotService;

	@Autowired
	private RobotBusiness robotBusiness;

	@Before
	public void init() {
		mockingServiceComponents();
	}

	private void mockingServiceComponents() {
		Mockito.when(robotService.createToyRobot(Mockito.any(RobotRequestDto.class)))
				.thenReturn(DataHelper.getResponseDto());
		Mockito.doNothing().when(robotService).updateRobot(Mockito.anyString(), Mockito.any(RobotRequestDto.class));

	}

	@Test
	public void testCreateToyRobot() {
		RobotResponseDto responseDto = robotBusiness.createToyRobot(DataHelper.geRobotRequestDto());
		Assert.assertEquals(DataHelper.UUID_ROBOT, responseDto.getToyRobotId());
	}

	@Test(expected = InvalidRequestException.class)
	public void testCreateToyRobotWithNull() {
		robotBusiness.createToyRobot(null);
	}

	@Test(expected = InvalidRequestException.class)
	public void testCreateToyRobotWithEmptyCommand() {
		robotBusiness.createToyRobot(DataHelper.getRequestRobotEmptyPlaceCommandDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testCreateToyRobotWithNullCommand() {
		robotBusiness.createToyRobot(DataHelper.getRequestRobotNullPlaceCommandDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testCreateToyRobotWithEmptyName() {
		robotBusiness.createToyRobot(DataHelper.getRequestRobotEmptyNameDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testCreateToyRobotWithNullName() {
		robotBusiness.createToyRobot(DataHelper.getRequestRobotNullNameDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testUpdateRobotWithNullName() {
		robotBusiness.updateRobot(DataHelper.UUID_ROBOT, DataHelper.getRequestRobotNullNameDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testUpdateRobotWithEmptyName() {
		robotBusiness.updateRobot(DataHelper.UUID_ROBOT, DataHelper.getRequestRobotEmptyNameDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testUpdateRobotWithNullCommand() {
		robotBusiness.updateRobot(DataHelper.UUID_ROBOT, DataHelper.getRequestRobotNullPlaceCommandDto());
	}

	@Test(expected = InvalidRequestException.class)
	public void testUpdateRobotWithNull() {
		robotBusiness.updateRobot(DataHelper.UUID_ROBOT, null);
	}

	@Test(expected = InvalidRequestException.class)
	public void testUpdateRobotWithEmptyCommand() {
		robotBusiness.updateRobot(DataHelper.UUID_ROBOT, DataHelper.getRequestRobotEmptyPlaceCommandDto());
	}
}
