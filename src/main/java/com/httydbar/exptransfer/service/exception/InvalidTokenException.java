package com.httydbar.exptransfer.service.exception;

/**
 * The base exception class for all services.
 *
 * @author wxx9248
 */
public class InvalidTokenException extends ServiceException
{
    public InvalidTokenException()
    {
        super();
    }
    
    public InvalidTokenException(String message)
    {
        super(message);
    }
    
    public InvalidTokenException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public InvalidTokenException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public InvalidTokenException(Throwable cause)
    {
        super(cause);
    }
}
