package com.idealo.toyrobot.factory.simulator.types;

import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public class ReportSimulation implements Simulator {

	/**
	 * @param toyRobot
	 */
	@Override
	public void execute(Robot toyRobot) {
		if (!toyRobot.getToyRobotSimulator().isOnTable()) {

		} else {
			reportRobot(toyRobot);
		}
		
	}

	/**
	 * @param toyRobot
	 * 
	 */
	private void reportRobot(Robot toyRobot) {
		toyRobot.getToyRobotSimulator().submitReports();
	}

}
