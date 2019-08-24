package com.idealo.toyrobot.repository;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import static com.idealo.toyrobot.utils.Constants.OK;

import java.util.List;

import com.example.model.CardinalDirections;
import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.repository.service.RobotRepositoryService;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobotRepositoryServiceImplTest {

	@Autowired
	private RobotRepositoryService robotRepositoryService;

	@Test
	public void testAdd() {
		String uuid = robotRepositoryService.add(DataHelper.getRobot(1, 1, CardinalDirections.NORTH));
		Assert.assertEquals(DataHelper.UUID_ROBOT, uuid);
	}

	@Test
	public void testUpdate() {
		int result = robotRepositoryService.update(DataHelper.UUID_ROBOT,
				DataHelper.getRobot(1, 2, CardinalDirections.NORTH));
		Assert.assertEquals(OK, result);
		;
	}

	@Test
	public void testFindById() {
		Robot robot = robotRepositoryService.findById(DataHelper.UUID_ROBOT);
		Assert.assertTrue(1 == robot.getToyRobotSimulator().getxPosition());
		Assert.assertTrue(1 == robot.getToyRobotSimulator().getyPosition());
		Assert.assertEquals(CardinalDirections.NORTH, robot.getToyRobotSimulator().getCardinalDirections());
	}

	@Test
	public void testFindAll() {
		List<Robot> listRobot = robotRepositoryService.findAll();
		Assert.assertNotNull(listRobot);
		Assert.assertEquals(CardinalDirections.NORTH, listRobot.get(0).getToyRobotSimulator().getCardinalDirections());
	}

	@Ignore
	@Test
	public void testDeleteAll() {
		int result = robotRepositoryService.deleteAll();
		Assert.assertEquals(OK, result);
	}

	@Ignore
	@Test
	public void testDeleteById() {
		int result = robotRepositoryService.deleteById(DataHelper.UUID_ROBOT);
		Assert.assertEquals(OK, result);
	}
}
