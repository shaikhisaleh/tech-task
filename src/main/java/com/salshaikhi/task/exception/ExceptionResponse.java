package com.salshaikhi.task.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    String message;
    int code;
    String status;
    Date time;
}
