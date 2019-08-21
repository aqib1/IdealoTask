package com.idealo.toyrobot.models;

import com.example.model.CardinalDirections;
import com.idealo.toyrobot.utils.Constants;

public class ToyRobotSimulator {

	private Integer xPosition;
	private Integer yPosition;
	private CardinalDirections cardinalDirections;

	public ToyRobotSimulator() {
	}

	public ToyRobotSimulator(Integer xPosition, Integer yPosition, CardinalDirections cardinalDirections) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.cardinalDirections = cardinalDirections;
	}

	public Integer getxPosition() {
		return xPosition;
	}

	public void setxPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	public Integer getyPosition() {
		return yPosition;
	}

	public void setyPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}

	public CardinalDirections getCardinalDirections() {
		return cardinalDirections;
	}

	public void setCardinalDirections(CardinalDirections cardinalDirections) {
		this.cardinalDirections = cardinalDirections;
	}

	public String getCurrentLocationOnTable() {
		return String.join(",", String.valueOf(xPosition), String.valueOf(yPosition), cardinalDirections.toString());
	}
	
	
	/* (0,0) is SOUTH WEST which make our graph like below 
	*   		
	*   		SOUTH
	*   WEST --       -- EAST
	*   		NORTH
	*   
	*   Increment in x position will cause robot to move in east
	*   Increment in y position will cause robot to move in north
	*   Decrement in y position will cause robot to move in south
	*   Decrement in x position will cause robot to move in west
	*    
	*/
	
	
	public void moveToNorth() {
		if (yPosition < Constants.TABLE_MAX_LIMIT)
			yPosition++;
	}

	public void moveToSouth() {
		if (yPosition > Constants.TABLE_MIN_LIMIT)
			yPosition--;
	}

	public void moveToEast() {
		if (xPosition < Constants.TABLE_MAX_LIMIT)
			xPosition++;
	}

	public void moveToWest() {
		if (xPosition > Constants.TABLE_MIN_LIMIT)
			xPosition--;
	}

	public boolean isOnTable() {
		return xPosition != null && yPosition != null && cardinalDirections != null;
	}

}
