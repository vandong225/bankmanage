package com.bankmanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;




@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)

public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String messange) {
	    super(messange);
	  }
}
