package com.idealo.toyrobot.utils;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 */
public class Constants {

	public static final int TABLE_MAX_LIMIT = 4;
	public static final int TABLE_MIN_LIMIT = 0;
	public static final String PLACE_COMMAND_REGEX = "^(PLACE)\\s\\d+,\\d+,(NORTH|WEST|EAST|SOUTH)$";
	public static final String DEFAULT_ROBOT_NAME = "ROBOT - 1";

	public static final int OK = 1;
	public static final int ERROR = -1;

	private Constants() {

	}
}
