package com.idealo.toyrobot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.example.model.RobotSimulationRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.toyrobot.business.SimulatorBusiness;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.utils.URLS;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class SimulatorControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SimulatorBusiness simulatorBusiness;

	private MediaType MEDIA_TYPE_JSON_UTF8;

	@Before
	public void init() {
		mockingSimulatorBusiness();
	}

	private void mockingSimulatorBusiness() {
		Mockito.when(simulatorBusiness.simulateRobot(Mockito.anyString(), Mockito.any(RobotSimulationRequestDto.class)))
				.thenReturn(DataHelper.getRobotSimulationResponseDto());
		Mockito.when(simulatorBusiness.getSimulationsAgainstId(Mockito.anyString()))
				.thenReturn(DataHelper.getRobotSimulationStackResponseDto());
		MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void testSimulateRobot() throws JsonProcessingException, Exception {
		mockMvc.perform(post(URLS.SIMULATOR_URL_BASE_FOR_TEST + URLS.SIMULATOR_URL_SIMULATE, DataHelper.UUID_ROBOT)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(DataHelper.getRobotSimulationRequestDto()))
				.contentType(MEDIA_TYPE_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.report").value("1,1,EAST")).andDo(print());
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void testGetSimulationsAgainstId() throws JsonProcessingException, Exception {
		mockMvc.perform(get(URLS.SIMULATOR_URL_BASE_FOR_TEST + URLS.SIMULATOR_URL_SIMULATE, DataHelper.UUID_ROBOT)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(jsonPath("$.reportList[0]").value("1,1,EAST")).andDo(print());
	}
}
