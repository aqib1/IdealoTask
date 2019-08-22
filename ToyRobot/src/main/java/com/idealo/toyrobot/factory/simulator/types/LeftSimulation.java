package com.idealo.toyrobot.factory.simulator.types;

import com.example.model.CardinalDirections;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;

public class LeftSimulation implements Simulator{

	@Override
	public void execute(Robot toyRobot) {
		if (!toyRobot.getToyRobotSimulator().isOnTable()) {

		} else {
			leftMovement(toyRobot);
		}
	}

	private void leftMovement(Robot toyRobot) {
		switch (toyRobot.getToyRobotSimulator().getCardinalDirections()) {
		case NORTH:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.EAST);
			break;
		case SOUTH:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.WEST);
			break;
		case EAST:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.SOUTH);
			break;
		case WEST:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.NORTH);
			break;
		default:

		}
	}

}
