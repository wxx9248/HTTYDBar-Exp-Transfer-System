package com.httydbar.exptransfer.service.exception;

/**
 * The base exception of all runtime exception for all services.
 *
 * @author wxx9248
 */
public class UnmatchedRequestException extends ExceptionalException
{
    public UnmatchedRequestException()
    {
        super();
    }
    
    public UnmatchedRequestException(String message)
    {
        super(message);
    }
    
    public UnmatchedRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public UnmatchedRequestException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public UnmatchedRequestException(Throwable cause)
    {
        super(cause);
    }
}
