package com.httydbar.exptransfer.service.exception;

/**
 * The base exception class for all services.
 *
 * @author wxx9248
 */
public class TiebaNotSubscribedException extends ServiceException
{
    public TiebaNotSubscribedException()
    {
        super();
    }
    
    public TiebaNotSubscribedException(String message)
    {
        super(message);
    }
    
    public TiebaNotSubscribedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public TiebaNotSubscribedException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public TiebaNotSubscribedException(Throwable cause)
    {
        super(cause);
    }
}
