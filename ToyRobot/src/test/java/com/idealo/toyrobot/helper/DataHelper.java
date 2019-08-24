package com.idealo.toyrobot.helper;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.example.model.CardinalDirections;
import com.example.model.RobotDetailsResponse;
import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.example.model.RobotSimulationRequestDto;
import com.example.model.RobotSimulationResponseDto;
import com.example.model.RobotSimulationStackResponseDto;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.models.RobotSimulator;
import com.idealo.toyrobot.utils.Constants;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
public class DataHelper {

	public static final String UUID_ROBOT = UUID.randomUUID().toString();

	/**
	 * @return
	 */
	public static RobotResponseDto getResponseDto() {
		return new RobotResponseDto().toyRobotId(UUID_ROBOT);
	}

	/**
	 * @return
	 */
	public static RobotRequestDto geRobotRequestDto() {
		return new RobotRequestDto().placeCommand("PLACE 0,0,WEST").robotName(Constants.DEFAULT_ROBOT_NAME);
	}

	/**
	 * @return
	 */
	public static RobotRequestDto getRequestRobotEmptyPlaceCommandDto() {
		return new RobotRequestDto().placeCommand("").robotName(Constants.DEFAULT_ROBOT_NAME);
	}

	/**
	 * @return
	 */
	public static RobotRequestDto getRequestRobotNullPlaceCommandDto() {
		return new RobotRequestDto().placeCommand(null).robotName(Constants.DEFAULT_ROBOT_NAME);
	}

	/**
	 * @return
	 */
	public static RobotRequestDto getRequestRobotNullNameDto() {
		return new RobotRequestDto().placeCommand("PLACE 0,0,WEST").robotName(null);
	}

	/**
	 * @return
	 */
	public static RobotRequestDto getRequestRobotEmptyNameDto() {
		return new RobotRequestDto().placeCommand("PLACE 0,0,WEST").robotName("");
	}

	/**
	 * @return
	 */
	public static RobotRequestDto getUpdatedRobotRequestDto() {
		return new RobotRequestDto().placeCommand("PLACE 0,1,NORTH").robotName(Constants.DEFAULT_ROBOT_NAME + 1);
	}

	/**
	 * @return
	 */
	public static RobotSimulationResponseDto getRobotSimulationResponseDto() {
		return new RobotSimulationResponseDto().report("1,1,EAST");
	}

	/**
	 * @return
	 */
	public static RobotSimulationRequestDto getRobotSimulationRequestDto() {
		return new RobotSimulationRequestDto().commandsList(List.of("MOVE,REPORT"));
	}

	/**
	 * @return
	 */
	public static RobotSimulationRequestDto getRobotSimulationEmptyRequestDto() {
		return new RobotSimulationRequestDto().commandsList(Collections.emptyList());
	}

	/**
	 * @return
	 */
	public static RobotSimulationStackResponseDto getRobotSimulationStackResponseDto() {
		return new RobotSimulationStackResponseDto().reportList(List.of("1,1,EAST"));
	}

	/**
	 * @return
	 */
	public static RobotDetailsResponse getDetailedResponseDto() {
		return new RobotDetailsResponse().uuid(UUID_ROBOT).robotName(Constants.DEFAULT_ROBOT_NAME)
				.createdAt("8/24/2019");
	}

	/**
	 * @return
	 */
	public static Robot getRobot(int xCordinate, int yCordinate, CardinalDirections cardinalDirections) {
		Robot robot = new Robot();
		robot.setRobotName(Constants.DEFAULT_ROBOT_NAME);
		robot.setCreatedAt(LocalDate.now().toString());
		robot.setUuid(UUID_ROBOT);
		RobotSimulator simulator = new RobotSimulator();
		simulator.setxPosition(xCordinate);
		simulator.setyPosition(yCordinate);
		simulator.setCardinalDirections(cardinalDirections);
		robot.setToyRobotSimulator(simulator);
		return robot;
	}

	private DataHelper() {

	}
}
