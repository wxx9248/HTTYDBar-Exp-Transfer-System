package com.httydbar.exptransfer.service.exception;

/**
 * The base exception of all runtime exception for all DAO operations.
 *
 * @author wxx9248
 */
public class AlgorithmNotFoundException extends ServiceRuntimeException
{
    public AlgorithmNotFoundException()
    {
        super();
    }
    
    public AlgorithmNotFoundException(String message)
    {
        super(message);
    }
    
    public AlgorithmNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public AlgorithmNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public AlgorithmNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
