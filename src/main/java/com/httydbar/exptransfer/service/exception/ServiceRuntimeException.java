package com.httydbar.exptransfer.service.exception;

/**
 * The base exception of all runtime exception for all services.
 *
 * @author wxx9248
 */
public class ServiceRuntimeException extends RuntimeException
{
    public ServiceRuntimeException()
    {
        super();
    }
    
    public ServiceRuntimeException(String message)
    {
        super(message);
    }
    
    public ServiceRuntimeException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ServiceRuntimeException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ServiceRuntimeException(Throwable cause)
    {
        super(cause);
    }
}
