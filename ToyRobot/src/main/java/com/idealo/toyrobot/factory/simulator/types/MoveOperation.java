package com.idealo.toyrobot.factory.simulator.types;

import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;

public class MoveOperation implements Simulator {

	@Override
	public void execute(Robot toyRobot) {
		if (!toyRobot.getToyRobotSimulator().isOnTable()) {

		} else {
			moveRobot(toyRobot);
		}
	}

	private void moveRobot(Robot toyRobot) {
		switch (toyRobot.getToyRobotSimulator().getCardinalDirections()) {
		case NORTH:
			toyRobot.getToyRobotSimulator().moveToNorth();
			break;
		case SOUTH:
			toyRobot.getToyRobotSimulator().moveToSouth();
			break;
		case EAST:
			toyRobot.getToyRobotSimulator().moveToEast();
			break;
		case WEST:
			toyRobot.getToyRobotSimulator().moveToWest();
			break;
		default:

		}
	}
}
