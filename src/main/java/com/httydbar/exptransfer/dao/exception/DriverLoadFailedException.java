package com.httydbar.exptransfer.dao.exception;

/**
 * A <b>runtime</b> exception that is thrown when failed to load the database driver.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory
 */
public class DriverLoadFailedException extends DAORuntimeException
{
    public DriverLoadFailedException()
    {
        super();
    }
    
    public DriverLoadFailedException(String message)
    {
        super(message);
    }
    
    public DriverLoadFailedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DriverLoadFailedException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DriverLoadFailedException(Throwable cause)
    {
        super(cause);
    }
}
