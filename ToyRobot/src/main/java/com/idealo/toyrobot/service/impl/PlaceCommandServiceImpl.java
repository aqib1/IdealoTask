package com.idealo.toyrobot.service.impl;

import org.springframework.stereotype.Service;

import com.example.model.CardinalDirections;
import com.example.model.RobotRequestDto;
import com.idealo.toyrobot.exceptions.CordsOutOfBoundException;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.service.PlaceCommandService;
import com.idealo.toyrobot.utils.Constants;

@Service
public class PlaceCommandServiceImpl implements PlaceCommandService {

	public Robot IOPlaceCommandExecutor(RobotRequestDto request) {
		Robot toyRobot = getToyRobotByRequest(request);
		String cmmd = request.getPlaceCommand();

		if (!cmmd.matches(Constants.PLACE_COMMAND_REGEX)) {
			throw new InvalidRequestException("\nRequest place command, does not contain valid format.");
		} else {
			try {
				setPlaceDataToToyRobot(cmmd, toyRobot);
			} catch (Exception e) {
				throw new InvalidRequestException("\nCardinal data is not in the correct format.", e);
			}
		}

		return toyRobot;
	}

	private void setPlaceDataToToyRobot(String cmmd, Robot toyRobot) {
		String[] cardinalData = cmmd.split(" ")[1].split(",");

		Integer xValue = Integer.parseInt(cardinalData[0]);
		Integer yValue = Integer.parseInt(cardinalData[1]);

		if (isToyRobotInTableLimit(xValue, yValue)) {
			toyRobot.getToyRobotSimulator().setxPosition(xValue);
			toyRobot.getToyRobotSimulator().setyPosition(yValue);
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.valueOf(cardinalData[2]));
		} else {
			throw new CordsOutOfBoundException("\nCoordinates of ToyRobot not exists in the max range table["
					+ Constants.TABLE_MIN_LIMIT + "," + Constants.TABLE_MAX_LIMIT + "]");
		}

	}

	private boolean isToyRobotInTableLimit(Integer xValue, Integer yValue) {
		return xValue <= Constants.TABLE_MAX_LIMIT && xValue >= Constants.TABLE_MIN_LIMIT
				&& yValue <= Constants.TABLE_MAX_LIMIT && yValue >= Constants.TABLE_MIN_LIMIT;
	}

	private Robot getToyRobotByRequest(RobotRequestDto request) {
		Robot toyRobot = new Robot();
		toyRobot.setRobotName(request.getRobotName());
		return toyRobot;
	}
}
