package com.upgrad.eshop.exceptions;

public class AddressNotFound extends Exception {

    public AddressNotFound() {
    }
    public AddressNotFound(String message) {
        super(message);
    }
    public AddressNotFound(String message, Throwable cause) {
        super(message, cause);
    }
    public AddressNotFound(Throwable cause) {
        super(cause);
    }
    public AddressNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
