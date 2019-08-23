package com.idealo.toyrobot.factory.simulator.types;

import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/2019
 */
public class MoveSimulator implements Simulator {

	/**
	 * @param toyRobot
	 */
	@Override
	public void execute(Robot toyRobot) {
		if (!toyRobot.getToyRobotSimulator().isOnTable()) {

		} else {
			moveRobot(toyRobot);
		}
	}

	/**
	 * @param toyRobot
	 */
	
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
