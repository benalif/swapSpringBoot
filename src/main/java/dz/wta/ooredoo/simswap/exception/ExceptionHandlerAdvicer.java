package dz.wta.ooredoo.simswap.exception;

import static dz.wta.ooredoo.simswap.model.GenericResponse.ERROR_MESSAGE;
import static dz.wta.ooredoo.simswap.model.GenericResponse.GENERIC_ERROR;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dz.wta.ooredoo.simswap.model.ConstraintViolationResponse;
import dz.wta.ooredoo.simswap.model.GenericResponse;
import dz.wta.ooredoo.simswap.model.InvalidFieldsResponse;

@ControllerAdvice
public class ExceptionHandlerAdvicer extends ResponseEntityExceptionHandler {

	private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvicer.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> getException(Exception ex) {

		LOGGER.error("Handling " + ex.getClass().getSimpleName() + " du to: " + ex.getMessage());

		return new ResponseEntity<GenericResponse>(new GenericResponse(1, GENERIC_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub

		final List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getDefaultMessage()).collect(Collectors.toList());

		return new ResponseEntity<Object>(new InvalidFieldsResponse(1, ERROR_MESSAGE, errors), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintException(ConstraintViolationException ex) throws IOException {

		return new ResponseEntity<>(new ConstraintViolationResponse(1, "error", ex.getMessage()),
				HttpStatus.BAD_REQUEST);

	}
}
