package com.idealo.toyrobot.repository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@Service
public class RobotRepositoryServiceImpl implements RobotRepositoryService{

	/**
	 * @return
	 */
	@Override
	public List<Robot> findAll() {
		return DataRepository.getInstance().findAll();
	}

	/**
	 * @param uuid
	 * @return
	 */
	@Override
	public Robot findById(String uuid) {
		return DataRepository.getInstance().findById(uuid);
	}

	/**
	 * @param uuid
	 * @return
	 */
	@Override
	public int deleteById(String uuid) {
		return DataRepository.getInstance().deleteById(uuid);
	}

	/**
	 * @param uuid
	 * @param robot
	 * @return
	 */
	@Override
	public int update(String uuid, Robot robot) {
		return DataRepository.getInstance().update(uuid, robot);
	}

	/**
	 * @return
	 */
	@Override
	public int deleteAll() {
		return DataRepository.getInstance().deleteAll();
	}

	/**
	 * @param robot
	 * @return
	 */
	@Override
	public String add(Robot robot) {
		return DataRepository.getInstance().add(robot);
	}

	
	
}
