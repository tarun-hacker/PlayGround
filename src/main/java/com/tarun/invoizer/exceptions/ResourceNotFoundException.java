package com.tarun.invoizer.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException()
    {
        super("No such resource on system");
    }
}
