package co.com.cidenet.employees.model.exception;

import lombok.Data;

@Data
public class BusinessException extends Exception{


    private String description;
    private int statusCode;

    public BusinessException(int statusCode, String description) {
        super();
        this.description = description;
        this.statusCode = statusCode;
    }
}
