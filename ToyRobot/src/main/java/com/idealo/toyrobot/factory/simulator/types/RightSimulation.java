package com.idealo.toyrobot.factory.simulator.types;

import com.example.model.CardinalDirections;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;

public class RightSimulation implements Simulator {

	@Override
	public void execute(Robot toyRobot) {
		if (!toyRobot.getToyRobotSimulator().isOnTable()) {
			
		} else {
			rightMovement(toyRobot);
		}
	}

	private void rightMovement(Robot toyRobot) {
		switch (toyRobot.getToyRobotSimulator().getCardinalDirections()) {
		case NORTH:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.WEST);
			break;
		case SOUTH:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.EAST);
			break;
		case EAST:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.NORTH);
			break;
		case WEST:
			toyRobot.getToyRobotSimulator().setCardinalDirections(CardinalDirections.SOUTH);
			break;
		default:

		}
	}

}
