package com.idealo.toyrobot.repository.service;

import java.util.List;

import com.idealo.toyrobot.models.Robot;

public interface RobotRepositoryService {

	List<Robot> findAll();

	Robot findById(String uuid);

	int deleteById(String uuid);

	int update(String uuid, Robot robot);

	int deleteAll();

	String add(Robot robot);
}
