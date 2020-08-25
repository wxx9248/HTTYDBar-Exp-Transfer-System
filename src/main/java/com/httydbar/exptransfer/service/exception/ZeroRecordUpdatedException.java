package com.httydbar.exptransfer.service.exception;

/**
 * The base exception of all runtime exception for all services.
 *
 * @author wxx9248
 */
public class ZeroRecordUpdatedException extends ExceptionalException
{
    public ZeroRecordUpdatedException()
    {
        super();
    }
    
    public ZeroRecordUpdatedException(String message)
    {
        super(message);
    }
    
    public ZeroRecordUpdatedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ZeroRecordUpdatedException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ZeroRecordUpdatedException(Throwable cause)
    {
        super(cause);
    }
}
