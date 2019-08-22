package com.idealo.toyrobot.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.model.RobotDetailsResponse;
import com.idealo.toyrobot.models.Robot;

@Mapper(componentModel = "spring")
public interface RobotDetailsResponseMapper {

	@Mappings({ @Mapping(target = "uuid", source = "robot.uuid"),
			@Mapping(target = "robotName", source = "robot.robotName"),
			@Mapping(target = "createdAt", source = "robot.createdAt") })
	RobotDetailsResponse robotToRobotDetailsResponse(Robot robot);

	List<RobotDetailsResponse> robotsListToRobotDetailsResponseList(List<Robot> robots);
}
