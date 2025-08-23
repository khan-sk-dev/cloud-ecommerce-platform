package com.app.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BuisnessException extends RuntimeException {
    private final String msg;
}
