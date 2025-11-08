package com.api_payroll.payroll.service.exception;

public class ObjectNotFoundException extends RuntimeException {
    public static final long serialVersionId = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
