package com.idealo.toyrobot.models;

import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/24/2019
 */
public class RobotSimulatorTest {
	@Test
	public void testGetterSetter() {
		PojoClass pojoClass = PojoClassFactory.getPojoClass(RobotSimulator.class);
		Validator validator = ValidatorBuilder.create()
							  .with(new SetterTester())
							  .with(new GetterTester())
							  .build();
		validator.validate(pojoClass);
	}
}
