package com.app.order.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BuisnessException extends RuntimeException {
//    private final String msg;

    public BuisnessException(String s) {

    }
}
