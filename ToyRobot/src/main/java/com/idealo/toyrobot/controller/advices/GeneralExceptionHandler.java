package com.idealo.toyrobot.controller.advices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.idealo.toyrobot.exceptions.CordsOutOfBoundException;
import com.idealo.toyrobot.exceptions.EmptyDataSetException;
import com.idealo.toyrobot.exceptions.InvalidParamException;
import com.idealo.toyrobot.exceptions.InvalidRequestException;
import com.idealo.toyrobot.exceptions.RobotNotFoundException;

@RestControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(value = { InvalidRequestException.class })
	public ResponseEntity<Object> handleInvalidRequestException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Invalid Request! => (InvalidRequestException)]";
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { InvalidParamException.class })
	public ResponseEntity<Object> handleInvalidParamException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Invalid param! => (InvalidParamException)]";
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { CordsOutOfBoundException.class })
	public ResponseEntity<Object> handleCordsOutOfBoundException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[coordinates out of bounds! => (CordsOutOfBoundException)]";
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(value = { RobotNotFoundException.class })
	public ResponseEntity<Object> handleRobotNotFoundException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Robot not found! => (RobotNotFoundException)]";
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(value = { EmptyDataSetException.class })
	public ResponseEntity<Object> handleEmptyDataSetException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Data not found! => (EmptyDataSetException)]";
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

}
