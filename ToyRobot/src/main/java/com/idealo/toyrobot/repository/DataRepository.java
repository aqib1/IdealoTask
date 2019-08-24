package com.idealo.toyrobot.repository;

import static com.idealo.toyrobot.utils.Constants.ERROR;
import static com.idealo.toyrobot.utils.Constants.OK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idealo.toyrobot.models.Robot;

/**
 * In actual project, this class can be replace with actual database
 * 
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/2019
 * 
 *        I am using initialization on demand concept as double check looking
 *        singleton failed in the multi-processed systems. Its a class with
 *        default access modifier so that no one can access that from outside of
 *        package
 */
class DataRepository {
	private static final Logger logger = LoggerFactory.getLogger(DataRepository.class);
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();
	private Map<String, Robot> robots = new HashMap<>();

	/**
	 * @return
	 */
	public List<Robot> findAll() {
		List<Robot> robotsList = null;
		if (robots.isEmpty())
			return new ArrayList<>();
		logger.info("Acquiring shared read lock in findAll");
		readLock.lock();
		robotsList = robots.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
		readLock.unlock();
		logger.info("Unlock shared read lock in findAll");
		return robotsList;
	}

	/**
	 * @param uuid
	 * @return
	 */
	public Robot findById(String uuid) {
		Robot robot = null;
		logger.info("Acquiring shared read lock in findById");
		readLock.lock();
		if (robots.containsKey(uuid))
			robot = robots.get(uuid);
		readLock.unlock();
		logger.info("Unlock shared read lock in findById");
		return robot;
	}

	/**
	 * @param uuid
	 * @return
	 */
	public int deleteById(String uuid) {
		int r = OK;
		logger.info("Acquiring write lock in deleteById");
		writeLock.lock();
		if (robots.containsKey(uuid))
			robots.remove(uuid);
		else
			r = ERROR;
		writeLock.lock();
		logger.info("Unlock write lock in deleteById");
		return r;
	}

	/**
	 * @return
	 */
	public int deleteAll() {
		logger.info("Acquiring write lock in deleteAll");
		writeLock.lock();
		try {
			robots.clear();
		} catch (UnsupportedOperationException e) {
			return ERROR;
		} finally {
			writeLock.lock();
			logger.info("Unlock write lock in deleteAll");
		}
		return OK;
	}

	/**
	 * @param uuid
	 * @param robot
	 * @return
	 */
	public int update(String uuid, Robot robot) {
		int r = ERROR;
		logger.info("Acquiring write lock in update");
		writeLock.lock();
		if (robots.containsKey(uuid)) {
			robots.put(uuid, robot);
			r = OK;
		}
		writeLock.unlock();
		logger.info("Unlock write lock in update");
		return r;
	}

	/**
	 * @param robot
	 * @return
	 */
	public String add(Robot robot) {
		logger.info("Acquiring write lock in add");
		writeLock.lock();
		String uuid = robot.getUuid();
		robots.put(uuid, robot);
		writeLock.unlock();
		logger.info("Unlock write lock in add");
		return uuid;
	}

	/**
	 * @author Aqib_Javed
	 * @version 1.0
	 * @since 8/22/2019
	 */
	private static class InstanceHolder {
		private static final DataRepository INSTANCE = new DataRepository();
	}

	/**
	 * @return
	 */
	public static DataRepository getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private DataRepository() {

	}
}
