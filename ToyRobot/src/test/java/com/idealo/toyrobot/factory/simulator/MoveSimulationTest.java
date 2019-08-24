package com.idealo.toyrobot.factory.simulator;

import org.junit.Assert;
import org.junit.Test;

import com.example.model.CardinalDirections;
import com.example.model.Simulations;
import com.idealo.toyrobot.exceptions.CordsOutOfBoundException;
import com.idealo.toyrobot.factory.CommandFactory;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
public class MoveSimulationTest {
	@Test
	public void movementNorth() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.NORTH);
		Simulator simulator = CommandFactory.getSimulator(Simulations.MOVE);
		int y = robot.getToyRobotSimulator().getyPosition();
		simulator.execute(robot);
		Assert.assertTrue(y < robot.getToyRobotSimulator().getyPosition());
	}

	@Test
	public void movementEast() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.EAST);
		Simulator simulator = CommandFactory.getSimulator(Simulations.MOVE);
		int x = robot.getToyRobotSimulator().getxPosition();
		simulator.execute(robot);
		Assert.assertTrue(x < robot.getToyRobotSimulator().getxPosition());
	}

	@Test
	public void movementWest() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.WEST);
		Simulator simulator = CommandFactory.getSimulator(Simulations.MOVE);
		int x = robot.getToyRobotSimulator().getxPosition();
		simulator.execute(robot);
		Assert.assertTrue(x > robot.getToyRobotSimulator().getxPosition());
	}

	@Test
	public void movementSouth() {
		Robot robot = DataHelper.getRobot(2, 2, CardinalDirections.SOUTH);
		Simulator simulator = CommandFactory.getSimulator(Simulations.MOVE);
		int y = robot.getToyRobotSimulator().getyPosition();
		simulator.execute(robot);
		Assert.assertTrue(y > robot.getToyRobotSimulator().getyPosition());
	}

	@Test(expected = CordsOutOfBoundException.class)
	public void movementInvalid() {
		Robot robot = DataHelper.getRobot(0, 0, CardinalDirections.SOUTH);
		Simulator simulator = CommandFactory.getSimulator(Simulations.MOVE);
		int y = robot.getToyRobotSimulator().getyPosition();
		simulator.execute(robot);
		Assert.assertTrue(y > robot.getToyRobotSimulator().getyPosition());
	}
}
