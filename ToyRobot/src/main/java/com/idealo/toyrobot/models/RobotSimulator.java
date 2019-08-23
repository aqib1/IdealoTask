package com.idealo.toyrobot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import com.example.model.CardinalDirections;
import com.idealo.toyrobot.exceptions.CordsOutOfBoundException;
import com.idealo.toyrobot.utils.Constants;

public class RobotSimulator {

	private AtomicInteger xPosition;
	private AtomicInteger yPosition;
	private CardinalDirections cardinalDirections;
	private List<String> simulationReport = new ArrayList<>();

	public RobotSimulator() {
	}

	public RobotSimulator(Integer xPosition, Integer yPosition, CardinalDirections cardinalDirections) {
		this.xPosition = new AtomicInteger(xPosition);
		this.yPosition = new AtomicInteger(yPosition);
		this.cardinalDirections = cardinalDirections;
	}

	public Integer getxPosition() {
		return xPosition.get();
	}

	public void setxPosition(Integer xPosition) {
		this.xPosition = new AtomicInteger(xPosition);
	}

	public Integer getyPosition() {
		return yPosition.get();
	}

	public void setyPosition(Integer yPosition) {
		this.yPosition = new AtomicInteger(yPosition);
	}

	public CardinalDirections getCardinalDirections() {
		return cardinalDirections;
	}

	public void setCardinalDirections(CardinalDirections cardinalDirections) {
		this.cardinalDirections = cardinalDirections;
	}

	public void submitReports() {
		simulationReport.add(
				String.join(",", String.valueOf(xPosition), String.valueOf(yPosition), cardinalDirections.toString()));
	}

	public List<String> getSimulationReport() {
		return simulationReport;
	}

	/*
	 * (0,0) is SOUTH WEST which make our graph like below
	 * 
	 * SOUTH WEST -- -- EAST NORTH
	 * 
	 * Increment in x position will cause robot to move in east Increment in y
	 * position will cause robot to move in north Decrement in y position will cause
	 * robot to move in south Decrement in x position will cause robot to move in
	 * west
	 * 
	 */

	public void moveToNorth() {
		if (yPosition.get() < Constants.TABLE_MAX_LIMIT)
			yPosition.incrementAndGet();
		else
			throwCordsException();
	}

	private void throwCordsException() {
		throw new CordsOutOfBoundException(
				"(X,Y) [" + xPosition + "," + yPosition + "] are out of bounds, table limit (X,Y) ["
						+ Constants.TABLE_MIN_LIMIT + "," + Constants.TABLE_MAX_LIMIT + "]");
	}

	public void moveToSouth() {
		if (yPosition.get() > Constants.TABLE_MIN_LIMIT)
			yPosition.decrementAndGet();
		else
			throwCordsException();
	}

	public void moveToEast() {
		if (xPosition.get() < Constants.TABLE_MAX_LIMIT)
			xPosition.incrementAndGet();
		else
			throwCordsException();
	}

	public void moveToWest() {
		if (xPosition.get() > Constants.TABLE_MIN_LIMIT)
			xPosition.decrementAndGet();
		else
			throwCordsException();
	}

	public boolean isOnTable() {
		return xPosition != null && yPosition != null && cardinalDirections != null;
	}

}
