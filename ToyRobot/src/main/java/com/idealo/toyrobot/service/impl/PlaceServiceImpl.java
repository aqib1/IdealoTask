package com.idealo.toyrobot.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.model.CardinalDirections;
import com.example.model.ToyRobotCreationRequest;
import com.idealo.toyrobot.exceptions.CordsOutOfBoundException;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.models.ToyRobot;
import com.idealo.toyrobot.service.PlaceService;
import com.idealo.toyrobot.utils.Constants;

@Service
public class PlaceServiceImpl implements PlaceService {

	public ToyRobot IOPlaceExecutor(ToyRobotCreationRequest request) {
		ToyRobot toyRobot = getToyRobotByRequest(request);
		String cmmd = request.getPlaceCommand();

		if (!cmmd.contains(Constants.PLACE_COMMAND_PREFIX)) {
			throw new InvalidRequestException("\nRequest place command, does not contain place keyword.");
		} else {
			try {
				setPlaceDataToToyRobot(cmmd, toyRobot);
			} catch (Exception e) {
				throw new InvalidRequestException("\nCardinal data is not in the correct format.", e);
			}
		}

		return toyRobot;
	}

	private void setPlaceDataToToyRobot(String cmmd, ToyRobot toyRobot) {
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

	private ToyRobot getToyRobotByRequest(ToyRobotCreationRequest request) {

		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setUuid(UUID.randomUUID().toString());
		toyRobot.setRobotName(request.getRobotName());

		return toyRobot;
	}
}
