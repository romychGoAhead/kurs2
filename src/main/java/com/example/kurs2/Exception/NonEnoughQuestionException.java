package com.example.kurs2.Exception;

public class NonEnoughQuestionException extends RuntimeException {
    public NonEnoughQuestionException() {
    }

    public NonEnoughQuestionException(String message) {
        super(message);
    }

    public NonEnoughQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonEnoughQuestionException(Throwable cause) {
        super(cause);
    }

    public NonEnoughQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
