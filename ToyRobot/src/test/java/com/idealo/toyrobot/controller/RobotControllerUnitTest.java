package com.idealo.toyrobot.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.RobotDetailsResponse;
import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.business.RobotBusiness;
import com.idealo.toyrobot.helper.DataHelper;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobotControllerUnitTest {

	@MockBean
	private RobotBusiness robotBusiness;

	@Autowired
	private RobotController robotController;

	@Before
	public void init() {
		Mockito.when(robotBusiness.createToyRobot(Mockito.any(RobotRequestDto.class)))
				.thenReturn(DataHelper.getResponseDto());
		Mockito.doNothing().when(robotBusiness).updateRobot(Mockito.anyString(), Mockito.any(RobotRequestDto.class));
		Mockito.doNothing().when(robotBusiness).deleteRobotById(Mockito.anyString());
		Mockito.when(robotBusiness.getRobotById(Mockito.anyString())).thenReturn(DataHelper.getDetailedResponseDto());
		Mockito.when(robotBusiness.getAllRobots()).thenReturn(List.of(DataHelper.getDetailedResponseDto()));
	}

	@Test
	public void testCreateRobot() {
		ResponseEntity<RobotResponseDto> response = robotController.createRobot(DataHelper.geRobotRequestDto());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(DataHelper.UUID_ROBOT, response.getBody().getToyRobotId());
	}

	@Test
	public void testUpdateRobot() {
		ResponseEntity<?> response = robotController.updateRobot(DataHelper.UUID_ROBOT, DataHelper.geRobotRequestDto());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testGetRobotById() {
		ResponseEntity<RobotDetailsResponse> response = robotController.getRobotById(DataHelper.UUID_ROBOT);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(DataHelper.UUID_ROBOT, response.getBody().getUuid());
	}

	@Test
	public void testDeleteRobotById() {
		ResponseEntity<?> response = robotController.deleteRobotById(DataHelper.UUID_ROBOT);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testGetAllRobots() {
		ResponseEntity<List<RobotDetailsResponse>> response = robotController.getAllRobots();
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(DataHelper.UUID_ROBOT, response.getBody().get(0).getUuid());
	}
}
