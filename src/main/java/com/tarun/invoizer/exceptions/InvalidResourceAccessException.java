package com.tarun.invoizer.exceptions;

public class InvalidResourceAccessException extends Throwable {
    public InvalidResourceAccessException()
    {
        super("Invalid resource access attempt blocked");
    }
}
