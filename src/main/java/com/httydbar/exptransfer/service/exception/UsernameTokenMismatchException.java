package com.httydbar.exptransfer.service.exception;

/**
 * The base exception class for all services.
 *
 * @author wxx9248
 */
public class UsernameTokenMismatchException extends ServiceException
{
    public UsernameTokenMismatchException()
    {
        super();
    }
    
    public UsernameTokenMismatchException(String message)
    {
        super(message);
    }
    
    public UsernameTokenMismatchException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public UsernameTokenMismatchException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public UsernameTokenMismatchException(Throwable cause)
    {
        super(cause);
    }
}
