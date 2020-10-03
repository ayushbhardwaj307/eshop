package com.upgrad.eshop.exceptions;

public class ProductDetailsNotFound extends Exception {
    public ProductDetailsNotFound() {
        super();
    }

    public ProductDetailsNotFound(String message) {
        super(message);
    }

    public ProductDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDetailsNotFound(Throwable cause) {
        super(cause);
    }

    protected ProductDetailsNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
