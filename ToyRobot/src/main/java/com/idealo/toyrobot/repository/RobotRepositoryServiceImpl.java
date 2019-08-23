package com.idealo.toyrobot.repository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;

@Service
public class RobotRepositoryServiceImpl implements RobotRepositoryService{

	@Override
	public List<Robot> findAll() {
		return DataRepository.getInstance().findAll();
	}

	@Override
	public Robot findById(String uuid) {
		return DataRepository.getInstance().findById(uuid);
	}

	@Override
	public int deleteById(String uuid) {
		return DataRepository.getInstance().deleteById(uuid);
	}

	@Override
	public int update(String uuid, Robot robot) {
		return DataRepository.getInstance().update(uuid, robot);
	}

	@Override
	public int deleteAll() {
		return DataRepository.getInstance().deleteAll();
	}

	@Override
	public String add(Robot robot) {
		return DataRepository.getInstance().add(robot);
	}

	
	
}
