package com.httydbar.exptransfer.util.exception;

/**
 * The base exception class for all utilities.
 *
 * @author wxx9248
 */
public class UtilException extends Exception
{
    public UtilException()
    {
        super();
    }
    
    public UtilException(String message)
    {
        super(message);
    }
    
    public UtilException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public UtilException(String message, Throwable cause, boolean enableSuppression,
                         boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public UtilException(Throwable cause)
    {
        super(cause);
    }
}
