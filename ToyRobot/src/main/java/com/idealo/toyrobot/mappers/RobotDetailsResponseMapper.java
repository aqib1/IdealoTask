package com.idealo.toyrobot.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.model.RobotDetailsResponse;
import com.idealo.toyrobot.models.Robot;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/22/2019
 */
@Mapper(componentModel = "spring")
public interface RobotDetailsResponseMapper {

	@Mappings({ @Mapping(target = "uuid", source = "robot.uuid"),
			@Mapping(target = "robotName", source = "robot.robotName"),
			@Mapping(target = "createdAt", source = "robot.createdAt") })
	RobotDetailsResponse robotToRobotDetailsResponse(Robot robot);

	List<RobotDetailsResponse> robotsListToRobotDetailsResponseList(List<Robot> robots);
}
