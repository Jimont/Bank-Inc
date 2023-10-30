package com.bank.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class BussinesException extends RuntimeException{
    private String code;
    private HttpStatus status;
    public BussinesException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
