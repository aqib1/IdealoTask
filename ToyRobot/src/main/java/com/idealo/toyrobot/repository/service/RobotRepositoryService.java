package com.idealo.toyrobot.repository.service;

import java.util.List;

import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/20/2019
 */
public interface RobotRepositoryService {

	/**
	 * @return
	 */
	List<Robot> findAll();

	/**
	 * @param uuid
	 * @return
	 */
	Robot findById(String uuid);

	/**
	 * @param uuid
	 * @return
	 */
	int deleteById(String uuid);

	/**
	 * @param uuid
	 * @param robot
	 * @return
	 */
	int update(String uuid, Robot robot);

	/**
	 * @return
	 */
	int deleteAll();

	/**
	 * @param robot
	 * @return
	 */
	String add(Robot robot);
}
