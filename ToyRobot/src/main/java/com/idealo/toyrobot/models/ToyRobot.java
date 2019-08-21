package com.idealo.toyrobot.models;

import java.time.LocalDate;
import java.util.UUID;


public class ToyRobot {

	private String uuid;
	private String robotName;
	private String createdAt;
	private ToyRobotSimulator toyRobotSimulator;

	public ToyRobot() {
		this(0,UUID.randomUUID().toString(),"TEST-01",LocalDate.now().toString());
	}

	public ToyRobot(int id, String uuid, String robotName, String createdAt) {
		super();
		this.uuid = uuid;
		this.robotName = robotName;
		this.createdAt = createdAt;
		this.toyRobotSimulator = new ToyRobotSimulator();
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

	public ToyRobotSimulator getToyRobotSimulator() {
		return toyRobotSimulator;
	}

	@Override
	public String toString() {
		return "ToyRobot [uuid=" + uuid + ", robotName=" + robotName + ", createdAt=" + createdAt + "]";
	}
	
}
