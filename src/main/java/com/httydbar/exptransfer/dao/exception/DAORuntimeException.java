package com.httydbar.exptransfer.dao.exception;

/**
 * The base exception of all runtime exception for all DAO operations.
 *
 * @author wxx9248
 */
public class DAORuntimeException extends RuntimeException
{
    public DAORuntimeException()
    {
        super();
    }
    
    public DAORuntimeException(String message)
    {
        super(message);
    }
    
    public DAORuntimeException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DAORuntimeException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DAORuntimeException(Throwable cause)
    {
        super(cause);
    }
}
