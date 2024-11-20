package com.deusley.api_rest.exceptions;

<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
=======
>>>>>>> e8b7943613ffa70f7274b5b7ec065f35be738692
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

<<<<<<< HEAD

=======
import javax.servlet.http.HttpServletRequest;
>>>>>>> e8b7943613ffa70f7274b5b7ec065f35be738692
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.NOT_FOUND.value(), er.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegratyViolation(DataIntegrityViolationException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.BAD_REQUEST.value(), er.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}