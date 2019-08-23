package com.idealo.toyrobot.factory;

import com.example.model.Simulations;
import com.idealo.toyrobot.exceptions.InvalidParamException;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.factory.simulator.types.LeftSimulation;
import com.idealo.toyrobot.factory.simulator.types.MoveSimulator;
import com.idealo.toyrobot.factory.simulator.types.ReportSimulator;
import com.idealo.toyrobot.factory.simulator.types.RightSimulation;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public class CommandFactory {

	/**
	 * @param simulations
	 * @return
	 */
	public static Simulator getSimulator(Simulations simulations) {
		Simulator simulator = null;
		switch (simulations) {
		case LEFT:
			simulator = new LeftSimulation();
			break;
		case RIGHT:
			simulator = new RightSimulation();
			break;
		case MOVE:
			simulator = new MoveSimulator();
			break;
		case REPORT:
			simulator = new ReportSimulator();
			break;
		default:
			throw new InvalidParamException("Simulator unknown! [Simulator type (" + simulations + ") Unknown]");
		}

		return simulator;
	}

	private CommandFactory() {

	}
}
