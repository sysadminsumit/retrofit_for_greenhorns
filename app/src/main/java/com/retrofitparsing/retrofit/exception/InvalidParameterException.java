package com.retrofitparsing.retrofit.exception;

public class InvalidParameterException extends BaseException {
    public InvalidParameterException(String cause) {
        super(cause);
    }

    public InvalidParameterException(String causeOfError, String suggestion) {
        super(causeOfError, suggestion);
    }

}
