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
public class RightSimulationTest {
	@Test
	public void rightMovementNorth() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.NORTH);
		Simulator simulator = CommandFactory.getSimulator(Simulations.RIGHT);
		simulator.execute(robot);
		Assert.assertEquals(CardinalDirections.WEST, robot.getToyRobotSimulator().getCardinalDirections());
	}

	@Test
	public void rightMovementEast() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.EAST);
		Simulator simulator = CommandFactory.getSimulator(Simulations.RIGHT);
		simulator.execute(robot);
		Assert.assertEquals(CardinalDirections.NORTH, robot.getToyRobotSimulator().getCardinalDirections());
	}

	@Test
	public void rightMovementWest() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.WEST);
		Simulator simulator = CommandFactory.getSimulator(Simulations.RIGHT);
		simulator.execute(robot);
		Assert.assertEquals(CardinalDirections.SOUTH, robot.getToyRobotSimulator().getCardinalDirections());
	}

	@Test
	public void rightMovementSouth() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.SOUTH);
		Simulator simulator = CommandFactory.getSimulator(Simulations.RIGHT);
		simulator.execute(robot);
		Assert.assertEquals(CardinalDirections.EAST, robot.getToyRobotSimulator().getCardinalDirections());
	}
}
