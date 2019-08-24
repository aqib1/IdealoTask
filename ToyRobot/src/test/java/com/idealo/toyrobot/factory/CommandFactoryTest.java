package com.idealo.toyrobot.factory;

import org.junit.Test;
import org.junit.Assert;
import com.example.model.Simulations;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.factory.simulator.types.LeftSimulation;
import com.idealo.toyrobot.factory.simulator.types.MoveSimulation;
import com.idealo.toyrobot.factory.simulator.types.ReportSimulation;
import com.idealo.toyrobot.factory.simulator.types.RightSimulation;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
public class CommandFactoryTest {

	@Test
	public void testGetSimulatorLeft() {
		Simulations simulations = Simulations.LEFT;
		Simulator simulator = CommandFactory.getSimulator(simulations);
		Assert.assertTrue(simulator instanceof LeftSimulation);
	}

	@Test
	public void testGetSimulatorRight() {
		Simulations simulations = Simulations.RIGHT;
		Simulator simulator = CommandFactory.getSimulator(simulations);
		Assert.assertTrue(simulator instanceof RightSimulation);
	}
	
	@Test
	public void testGetSimulatorMove() {
		Simulations simulations = Simulations.MOVE;
		Simulator simulator = CommandFactory.getSimulator(simulations);
		Assert.assertTrue(simulator instanceof MoveSimulation);
	}
	
	@Test
	public void testGetSimulatorReport() {
		Simulations simulations = Simulations.REPORT;
		Simulator simulator = CommandFactory.getSimulator(simulations);
		Assert.assertTrue(simulator instanceof ReportSimulation);
	}
}
