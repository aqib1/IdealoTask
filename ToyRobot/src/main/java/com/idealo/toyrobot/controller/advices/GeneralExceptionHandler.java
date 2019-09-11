package com.idealo.toyrobot.controller.advices;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 */
@RestControllerAdvice
public class GeneralExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { InvalidRequestException.class })
	public ResponseEntity<String> handleInvalidRequestException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Invalid Request! => (InvalidRequestException)]";
		logger.error(error, e);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { InvalidParamException.class })
	public ResponseEntity<String> handleInvalidParamException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Invalid param! => (InvalidParamException)]";
		logger.error(error, e);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { CordsOutOfBoundException.class })
	public ResponseEntity<String> handleCordsOutOfBoundException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[coordinates out of bounds! => (CordsOutOfBoundException)]";
		logger.error(error, e);
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { RobotNotFoundException.class })
	public ResponseEntity<String> handleRobotNotFoundException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Robot not found! => (RobotNotFoundException)]";
		logger.error(error, e);
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { EmptyDataSetException.class })
	public ResponseEntity<String> handleEmptyDataSetException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ "\n[Data not found! => (EmptyDataSetException)]";
		logger.error(error, e);
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

}
