package com.idealo.toyrobot.utils.helper;

import java.util.UUID;

import com.example.model.CardinalDirections;
import com.example.model.ToyRobotCreationRequest;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.models.ToyRobot;
import com.idealo.toyrobot.utils.Constants;

public class IOHelper {

	public static ToyRobot IOPlaceExecutor(ToyRobotCreationRequest request) {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setUuid(UUID.randomUUID().toString());
		toyRobot.setRobotName(request.getRobotName());
		String cmmd = request.getPlaceCommand();
		if (!cmmd.contains(Constants.PLACE_COMMAND_PREFIX)) {
			throw new InvalidRequestException("Request place command, does not contain place keyword.");
		} else {
			try {
				String[] cardinalData = cmmd.split(" ")[1].split(",");
				toyRobot.getToyRobotSimulator().setxPosition(Integer.parseInt(cardinalData[0]));
				toyRobot.getToyRobotSimulator().setyPosition(Integer.parseInt(cardinalData[1]));
				toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.valueOf(cardinalData[2]));
			} catch (Exception e) {
				throw new InvalidRequestException("Cardinal data is not in the correct format.", e);
			}

		}

		return toyRobot;
	}

	private IOHelper() {

	}
}
