package com.cdy.exception;

public class NotLoginException extends RuntimeException{
    /**
     * 
     */
    private static final long serialVersionUID = -568986069921855087L;

    public NotLoginException(String errorMsg)
    {
        super(errorMsg);
    }
}
