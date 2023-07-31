package com.example.kurs2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QveationAlredyExistsException extends RuntimeException {
    public QveationAlredyExistsException() {
        super();
    }

    public QveationAlredyExistsException(String message) {
        super(message);
    }

    public QveationAlredyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public QveationAlredyExistsException(Throwable cause) {
        super(cause);
    }

    public QveationAlredyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
