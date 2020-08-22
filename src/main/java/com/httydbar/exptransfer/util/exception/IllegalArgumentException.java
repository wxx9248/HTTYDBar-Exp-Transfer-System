package com.httydbar.exptransfer.util.exception;

/**
 * A runtime exception thrown when an illegal argument is passed.
 *
 * @author wxx9248
 */
public class IllegalArgumentException extends UtilRuntimeException
{
    public IllegalArgumentException()
    {
        super();
    }
    
    public IllegalArgumentException(String message)
    {
        super(message);
    }
    
    public IllegalArgumentException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public IllegalArgumentException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public IllegalArgumentException(Throwable cause)
    {
        super(cause);
    }
}
