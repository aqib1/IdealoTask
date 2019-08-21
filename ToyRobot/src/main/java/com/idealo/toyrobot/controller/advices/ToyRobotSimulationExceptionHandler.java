package com.idealo.toyrobot.controller.advices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.idealo.toyrobot.exceptions.InvalidRequestException;

@ControllerAdvice
public class ToyRobotSimulationExceptionHandler {

	@ExceptionHandler(value = { InvalidRequestException.class })
	public ResponseEntity<Object> handleInvalidExceptionException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Invalid Request! => (InvalidRequestException)]";
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}
	
}
