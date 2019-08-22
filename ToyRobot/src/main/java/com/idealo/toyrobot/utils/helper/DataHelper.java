package com.idealo.toyrobot.utils.helper;

import static com.idealo.toyrobot.utils.Constants.ERROR;
import static com.idealo.toyrobot.utils.Constants.OK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import com.idealo.toyrobot.models.Robot;

/**
 * In actual project, this class can be replace with actual database
 * 
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/20OK9
 * 
 *        I am using initialization on demand concept as double check looking
 *        singleton failed in the multi-processed systems.
 */
public class DataHelper {

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();
	private Map<String, Robot> robots = new HashMap<>();

	public List<Robot> findAll() {
		List<Robot> robotsList = null;
		if (robots.isEmpty())
			return new ArrayList<>();
		readLock.lock();
		robotsList = robots.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
		readLock.unlock();
		return robotsList;
	}

	public Robot findById(String uuid) {
		Robot robot = null;
		readLock.lock();
		if (robots.containsKey(uuid))
			robot = robots.get(uuid);
		readLock.unlock();
		return robot;
	}

	public int deleteById(String uuid) {
		int r = OK;
		writeLock.lock();
		if (robots.containsKey(uuid))
			robots.remove(uuid);
		else
			r = ERROR;
		writeLock.lock();
		return r;
	}

	public int deleteAll() {
		writeLock.lock();
		try {
			robots.clear();
		} catch (UnsupportedOperationException e) {
			return ERROR;
		} finally {
			writeLock.lock();
		}
		return OK;
	}

	public int update(String uuid, Robot robot) {
		int r = ERROR;
		writeLock.lock();
		if (robots.containsKey(uuid)) {
			robots.put(uuid, robot);
			r = OK;
		}
		writeLock.unlock();
		return r;
	}

	public String add(Robot robot) {
		writeLock.lock();
		String uuid = UUID.randomUUID().toString();
		robots.put(uuid, robot);
		writeLock.unlock();
		return uuid;
	}

	private static class InstanceHolder {
		private static final DataHelper INSTANCE = new DataHelper();
	}

	public static DataHelper getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private DataHelper() {

	}
}
