package com.jwt.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails  {
    private Date date;
    private String message;
    private String requestURL;
}
