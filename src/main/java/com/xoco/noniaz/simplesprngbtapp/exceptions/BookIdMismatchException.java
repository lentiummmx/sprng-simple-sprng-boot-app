package com.xoco.noniaz.simplesprngbtapp.exceptions;

public class BookIdMismatchException extends RuntimeException {
    public BookIdMismatchException() {
        super("Book Id Mismatch ...");
    }

    public BookIdMismatchException(String message) {
        super(message);
    }

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookIdMismatchException(Throwable cause) {
        super(cause);
    }

    public BookIdMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
