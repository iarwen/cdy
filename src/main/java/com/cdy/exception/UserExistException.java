package com.cdy.exception;

public class UserExistException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = -2865396085726128288L;

    public UserExistException(String errorMsg)
    {
        super(errorMsg);
    }
}
