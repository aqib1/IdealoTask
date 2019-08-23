package com.idealo.toyrobot.utils;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 *
 *        All URLS Details
 */
public class URLS {

	/************ TOY ROBOT CREATION API *********/
	public static final String TOY_ROBOT_URL_BASE_FOR_TEST = "/toyrobot/";
	public static final String TOY_ROBOT_URL_BASE = "/toyrobot/*";
	public static final String URL_TOY_ROBOT_URL_GET_BY_ID = "/{id}";
	public static final String URL_TOY_ROBOT_URL_DELETE = "/{id}";
	public static final String URL_TOY_ROBOT_URL_UPDATE = "/{id}";

	/************* SIMULATOR API *************/
	public static final String SIMULATOR_URL_BASE = "/simulator/*";
	public static final String SIMULATOR_URL_SIMULATE = "/{id}";

	private URLS() {

	}
}
