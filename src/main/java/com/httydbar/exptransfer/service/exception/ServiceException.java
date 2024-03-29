package com.httydbar.exptransfer.service.exception;

/**
 * The base exception class for all services.
 *
 * @author wxx9248
 */
public class ServiceException extends Exception
{
    public ServiceException()
    {
        super();
    }
    
    public ServiceException(String message)
    {
        super(message);
    }
    
    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ServiceException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ServiceException(Throwable cause)
    {
        super(cause);
    }
}
