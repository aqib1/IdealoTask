package com.idealo.toyrobot.models;

import java.time.LocalDate;
import java.util.UUID;

import com.idealo.toyrobot.utils.Constants;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public class Robot {

	private String uuid;
	private String robotName;
	private String createdAt;
	private RobotSimulator toyRobotSimulator;

	public Robot() {
		this(0, UUID.randomUUID().toString(), Constants.DEFAULT_ROBOT_NAME, LocalDate.now().toString());
	}

	/**
	 * @param id
	 * @param uuid
	 * @param robotName
	 * @param createdAt
	 */
	public Robot(int id, String uuid, String robotName, String createdAt) {
		super();
		this.uuid = uuid;
		this.robotName = robotName;
		this.createdAt = createdAt;
		this.toyRobotSimulator = new RobotSimulator();
	}

	/**
	 * @return
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return
	 */
	public String getRobotName() {
		return robotName;
	}

	/**
	 * @param robotName
	 */
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	/**
	 * @return
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return
	 */
	public RobotSimulator getToyRobotSimulator() {
		return toyRobotSimulator;
	}

	/**
	 * @param toyRobotSimulator
	 */
	public void setToyRobotSimulator(RobotSimulator toyRobotSimulator) {
		this.toyRobotSimulator = toyRobotSimulator;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "ToyRobot [uuid=" + uuid + ", robotName=" + robotName + ", createdAt=" + createdAt + "]";
	}

}
