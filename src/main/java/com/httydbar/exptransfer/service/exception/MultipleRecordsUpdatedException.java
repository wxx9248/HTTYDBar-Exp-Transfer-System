package com.httydbar.exptransfer.service.exception;

/**
 * The base exception of all runtime exception for all services.
 *
 * @author wxx9248
 */
public class MultipleRecordsUpdatedException extends ExceptionalException
{
    public MultipleRecordsUpdatedException()
    {
        super();
    }
    
    public MultipleRecordsUpdatedException(String message)
    {
        super(message);
    }
    
    public MultipleRecordsUpdatedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public MultipleRecordsUpdatedException(String message, Throwable cause, boolean enableSuppression,
                                           boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public MultipleRecordsUpdatedException(Throwable cause)
    {
        super(cause);
    }
}
