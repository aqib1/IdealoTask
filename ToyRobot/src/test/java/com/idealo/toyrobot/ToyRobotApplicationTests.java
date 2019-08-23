package com.idealo.toyrobot;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToyRobotApplicationTests {

	@Test
	public void mainMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "main";
		Class<?> c = RobotApplication.class;
		Method method = c.getDeclaredMethod(methodName, String[].class);
		Assert.assertNotNull(method);
	}

}
