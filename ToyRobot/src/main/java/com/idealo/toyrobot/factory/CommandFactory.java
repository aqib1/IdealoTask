package com.idealo.toyrobot.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Simulations;
import com.idealo.toyrobot.exceptions.InvalidParamException;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.factory.simulator.types.LeftSimulation;
import com.idealo.toyrobot.factory.simulator.types.MoveSimulation;
import com.idealo.toyrobot.factory.simulator.types.ReportSimulation;
import com.idealo.toyrobot.factory.simulator.types.RightSimulation;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public class CommandFactory {
	private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);
	/**
	 * @param simulations
	 * @return
	 */
	public static Simulator getSimulator(Simulations simulations) {
		logger.info("Simulations recieved ["+simulations+"]");
		Simulator simulator = null;
		switch (simulations) {
		case LEFT:
			simulator = new LeftSimulation();
			break;
		case RIGHT:
			simulator = new RightSimulation();
			break;
		case MOVE:
			simulator = new MoveSimulation();
			break;
		case REPORT:
			simulator = new ReportSimulation();
			break;
		default:
			throw new InvalidParamException("Simulator unknown! [Simulator type (" + simulations + ") Unknown]");
		}

		return simulator;
	}

	private CommandFactory() {

	}
}
