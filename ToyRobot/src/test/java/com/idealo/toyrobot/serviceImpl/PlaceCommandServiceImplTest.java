package com.idealo.toyrobot.serviceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.idealo.toyrobot.helper.DataHelper;
import com.idealo.toyrobot.models.Robot;
import com.idealo.toyrobot.service.PlaceCommandService;
import com.idealo.toyrobot.utils.Constants;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlaceCommandServiceImplTest {

	@Autowired
	private PlaceCommandService placeCommandService;

	@Test
	public void testIOPlaceCommandExecutor() {
		Robot robot = placeCommandService.IOPlaceCommandExecutor(DataHelper.geRobotRequestDto());
		Assert.assertEquals(Constants.DEFAULT_ROBOT_NAME, robot.getRobotName());
	}

}
