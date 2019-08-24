package com.idealo.toyrobot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.CardinalDirections;
import com.example.model.RobotRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.service.impl.PlaceCommandServiceImpl;
import com.idealo.toyrobot.utils.Constants;
import com.idealo.toyrobot.utils.URLS;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobotControllerIntegerationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PlaceCommandServiceImpl placeCommandServiceImpl;

	private MediaType MEDIA_TYPE_JSON_UTF8;

	@Before
	public void init() {
		mockingRobotBusiness();
	}

	public void mockingRobotBusiness() {
		Mockito.when(placeCommandServiceImpl.IOPlaceCommandExecutor(Mockito.any(RobotRequestDto.class)))
		.thenReturn(DataHelper.getRobot(1, 1, CardinalDirections.WEST));
		MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void testCreateRobot() throws JsonProcessingException, Exception {
		mockMvc.perform(post(URLS.TOY_ROBOT_URL_BASE).accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(DataHelper.geRobotRequestDto()))
				.contentType(MEDIA_TYPE_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.toyRobotId").value(DataHelper.UUID_ROBOT)).andDo(print());
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void testUpdateRobot() throws JsonProcessingException, Exception {
		mockMvc.perform(put(URLS.TOY_ROBOT_URL_BASE_FOR_TEST + URLS.URL_TOY_ROBOT_URL_UPDATE, DataHelper.UUID_ROBOT)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(DataHelper.getUpdatedRobotRequestDto()))
				.contentType(MEDIA_TYPE_JSON_UTF8)).andExpect(status().isOk()).andDo(print());
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void testGetRobotById() throws JsonProcessingException, Exception {
		mockMvc.perform(get(URLS.TOY_ROBOT_URL_BASE_FOR_TEST + URLS.URL_TOY_ROBOT_URL_GET_BY_ID, DataHelper.UUID_ROBOT))
				.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.uuid").value(DataHelper.UUID_ROBOT))
				.andExpect(jsonPath("$.robotName").value(Constants.DEFAULT_ROBOT_NAME))
				.andExpect(jsonPath("$.createdAt").value(LocalDate.now().toString())).andExpect(status().isOk()).andDo(print());
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void z_testDeleteRobotById() throws JsonProcessingException, Exception {
		mockMvc.perform(get(URLS.TOY_ROBOT_URL_BASE_FOR_TEST + URLS.URL_TOY_ROBOT_URL_DELETE, DataHelper.UUID_ROBOT))
				.andExpect(status().isOk()).andDo(print());
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void testGetAllRobots() throws JsonProcessingException, Exception {
		mockMvc.perform(get(URLS.TOY_ROBOT_URL_BASE_FOR_TEST)).andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.[0].uuid").value(DataHelper.UUID_ROBOT))
				.andExpect(jsonPath("$.[0].robotName").value(Constants.DEFAULT_ROBOT_NAME))
				.andExpect(jsonPath("$.[0].createdAt").value(LocalDate.now().toString())).andExpect(status().isOk()).andDo(print());
	}
}
