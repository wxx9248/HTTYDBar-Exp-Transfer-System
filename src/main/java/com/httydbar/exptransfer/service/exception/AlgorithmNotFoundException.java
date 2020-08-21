package com.httydbar.exptransfer.service.exception;

/**
 * A runtime exception thrown when a certain algorithm is not found.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.service.UsernamePasswordVerificationService
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
