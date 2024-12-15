package org.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        throw new RuntimeException("Product Id or Product name or price is invalid");
    }
}
