package com.idealo.toyrobot.factory.simulator;

import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public interface Simulator {
	/**
	 * @param toyRobot
	 */
	void execute(Robot toyRobot);
}
