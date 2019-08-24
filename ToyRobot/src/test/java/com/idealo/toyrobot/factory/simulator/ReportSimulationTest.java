package com.idealo.toyrobot.factory.simulator;

import org.junit.Assert;
import org.junit.Test;

import com.example.model.CardinalDirections;
import com.example.model.Simulations;
import com.idealo.toyrobot.factory.CommandFactory;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
public class ReportSimulationTest {
	
	@Test
	public void report() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.NORTH);
		Simulator simulator = CommandFactory.getSimulator(Simulations.LEFT);
		simulator.execute(robot);
		simulator = CommandFactory.getSimulator(Simulations.REPORT);
		simulator.execute(robot);
		Assert.assertEquals("2,2,EAST", robot.getToyRobotSimulator().getCurrentReport());
	}

}
