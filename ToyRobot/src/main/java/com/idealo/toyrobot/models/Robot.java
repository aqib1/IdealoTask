package com.idealo.toyrobot.models;

import java.time.LocalDate;
import java.util.UUID;

import com.idealo.toyrobot.utils.Constants;


public class Robot {

	private String uuid;
	private String robotName;
	private String createdAt;
	private RobotSimulator toyRobotSimulator;

	public Robot() {
		this(0,UUID.randomUUID().toString(),Constants.DEFAULT_ROBOT_NAME,LocalDate.now().toString());
	}

	public Robot(int id, String uuid, String robotName, String createdAt) {
		super();
		this.uuid = uuid;
		this.robotName = robotName;
		this.createdAt = createdAt;
		this.toyRobotSimulator = new RobotSimulator();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRobotName() {
		return robotName;
	}

	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public RobotSimulator getToyRobotSimulator() {
		return toyRobotSimulator;
	}

	@Override
	public String toString() {
		return "ToyRobot [uuid=" + uuid + ", robotName=" + robotName + ", createdAt=" + createdAt + "]";
	}
	
}
