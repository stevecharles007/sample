package com.dealer.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dealer.exception.nameNotFoundExcp;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
		@ExceptionHandler(value= nameNotFoundExcp.class)
		public ResponseEntity<Object> noname(nameNotFoundExcp ne){
			return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(value=IdNotFoundException.class)
		public ResponseEntity<Object> noId(IdNotFoundException in){
			return new ResponseEntity<>(in.getMessage(),HttpStatus.NOT_FOUND);
		}

	}



