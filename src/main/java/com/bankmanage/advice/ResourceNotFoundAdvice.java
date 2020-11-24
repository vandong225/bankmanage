package com.bankmanage.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bankmanage.exception.*;

@ControllerAdvice
class ResourceNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String ResourceNotFoundHandler(ResourceNotFoundException ex) {
    return ex.getMessage();
  }
}