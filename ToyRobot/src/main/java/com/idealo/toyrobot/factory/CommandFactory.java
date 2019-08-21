package com.idealo.toyrobot.factory;

import com.example.model.Simulations;
import com.idealo.toyrobot.exceptions.InvalidParamException;
import com.idealo.toyrobot.factory.simulator.Simulator;
import com.idealo.toyrobot.factory.simulator.types.LeftSimulation;
import com.idealo.toyrobot.factory.simulator.types.RightSimulation;

public class CommandFactory {

	public static Simulator getSimulator(Simulations simulations) {
		Simulator simulator = null;
		switch (simulations) {
		case LEFT:
			simulator = new LeftSimulation();
			break;
		case RIGHT:
			simulator = new RightSimulation();
			break;
		default:
			throw new InvalidParamException("Simulator unknown! [Simulator type (" + simulations + ") Unknown]");
		}

		return simulator;
	}

	private CommandFactory() {

	}
}