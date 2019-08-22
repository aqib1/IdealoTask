package com.idealo.toyrobot.repository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;
import com.idealo.toyrobot.utils.helper.DataHelper;

@Service
public class RobotRepositoryServiceImpl implements RobotRepositoryService{

	@Override
	public List<Robot> findAll() {
		return DataHelper.getInstance().findAll();
	}

	@Override
	public Robot findById(String uuid) {
		return DataHelper.getInstance().findById(uuid);
	}

	@Override
	public int deleteById(String uuid) {
		return DataHelper.getInstance().deleteById(uuid);
	}

	@Override
	public int update(String uuid, Robot robot) {
		return DataHelper.getInstance().update(uuid, robot);
	}

	@Override
	public int deleteAll() {
		return DataHelper.getInstance().deleteAll();
	}

	@Override
	public String add(Robot robot) {
		return DataHelper.getInstance().add(robot);
	}

	
	
}
