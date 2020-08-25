package com.httydbar.exptransfer.service.exception;

/**
 * The base exception of all runtime exception for all services.
 *
 * @author wxx9248
 */
public class ExceptionalException extends ServiceRuntimeException
{
    public ExceptionalException()
    {
        super();
    }
    
    public ExceptionalException(String message)
    {
        super(message);
    }
    
    public ExceptionalException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ExceptionalException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ExceptionalException(Throwable cause)
    {
        super(cause);
    }
}
