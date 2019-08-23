package com.idealo.toyrobot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.RobotRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.toyrobot.business.RobotBusiness;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.utils.URLS;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RobotControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RobotBusiness robotBusiness;

	private MediaType MEDIA_TYPE_JSON_UTF8;

	@Before
	public void init() {
		mockingRobotBusiness();
	}

	public void mockingRobotBusiness() {
		Mockito.when(robotBusiness.createToyRobot(Mockito.any(RobotRequestDto.class)))
				.thenReturn(DataHelper.getResponseDto());
		Mockito.doNothing().when(robotBusiness).updateRobot(Mockito.anyString(), Mockito.any(RobotRequestDto.class));
		Mockito.when(robotBusiness.getRobotById(Mockito.anyString())).thenReturn(DataHelper.getDetailedResponseDto());

		MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
	}

	@Test
	public void testCreateRobot() throws JsonProcessingException, Exception {
		mockMvc.perform(post(URLS.TOY_ROBOT_URL_BASE).accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(DataHelper.getRequestRobotRequestDto()))
				.contentType(MEDIA_TYPE_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.toyRobotId").value(DataHelper.UUID_ROBOT)).andDo(print());
	}

	@Test
	public void testUpdateRobot() throws JsonProcessingException, Exception {
		mockMvc.perform(put(URLS.TOY_ROBOT_URL_BASE_FOR_TEST + URLS.URL_TOY_ROBOT_URL_UPDATE, DataHelper.UUID_ROBOT)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(DataHelper.getUpdatedRequestRobotRequestDto()))
				.contentType(MEDIA_TYPE_JSON_UTF8)).andExpect(status().isOk()).andDo(print());
	}
}
