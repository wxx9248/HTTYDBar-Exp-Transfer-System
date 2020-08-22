package com.httydbar.exptransfer.util.exception;

/**
 * The base exception of all runtime exception for all utilities.
 *
 * @author wxx9248
 */
public class UtilRuntimeException extends RuntimeException
{
    public UtilRuntimeException()
    {
        super();
    }
    
    public UtilRuntimeException(String message)
    {
        super(message);
    }
    
    public UtilRuntimeException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public UtilRuntimeException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public UtilRuntimeException(Throwable cause)
    {
        super(cause);
    }
}
