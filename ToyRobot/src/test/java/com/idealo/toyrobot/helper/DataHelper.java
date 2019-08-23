package com.idealo.toyrobot.helper;

import java.util.UUID;

import com.example.model.RobotDetailsResponse;
import com.example.model.RobotRequestDto;
import com.example.model.RobotResponseDto;
import com.idealo.toyrobot.utils.Constants;

public class DataHelper {

	public static final String UUID_ROBOT = UUID.randomUUID().toString();

	public static RobotResponseDto getResponseDto() {
		return new RobotResponseDto().toyRobotId(UUID_ROBOT);
	}

	public static RobotRequestDto getRequestRobotRequestDto() {
		return new RobotRequestDto().placeCommand("PLACE 0,0,WEST").robotName(Constants.DEFAULT_ROBOT_NAME);
	}

	public static RobotRequestDto getUpdatedRequestRobotRequestDto() {
		return new RobotRequestDto().placeCommand("PLACE 0,1,NORTH").robotName(Constants.DEFAULT_ROBOT_NAME + 1);
	}

	private DataHelper() {

	}

	public static RobotDetailsResponse getDetailedResponseDto() {
		// TODO Auto-generated method stub
		return new RobotDetailsResponse().uuid(UUID_ROBOT).robotName(Constants.DEFAULT_ROBOT_NAME)
				.createdAt("8/24/2019");
	}
}
