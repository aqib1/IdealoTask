package com.idealo.toyrobot.factory.simulator.types;

import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.models.Robot;

public class ReportSimulator implements Simulator {

	@Override
	public void execute(Robot toyRobot) {
		if (!toyRobot.getToyRobotSimulator().isOnTable()) {

		} else {
			reportRobot(toyRobot);
		}
		
	}

	private void reportRobot(Robot toyRobot) {
		toyRobot.getToyRobotSimulator().submitReports();
	}

}
