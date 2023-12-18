package es.melit.melitspringbootinmobiliaria.controllers;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String message = "Parameter '" + e.getName() + "' must be of type " + e.getRequiredType().getSimpleName();
        String error = "Parameter error";
        LocalDateTime timestamp = LocalDateTime.now();
        String path = request.getRequestURI();
        ErrorResponse errorResponse = new ErrorResponse(timestamp, HttpStatus.BAD_REQUEST.value(), error, message, path);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private static class ErrorResponse {
    	private final LocalDateTime timestamp;
        private final int status;
        private final String error;
        private final String message;
        private final String path;

        public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        	this.timestamp = timestamp;
            this.status = status;
            this.error = error;
            this.message = message;
            this.path = path;
        }        

        public LocalDateTime getTimestamp() {
			return timestamp;
		}


		public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

		public String getError() {
			return error;
		}

		public String getPath() {
			return path;
		}
        
        
    }
}
