package com.httydbar.exptransfer.dao.exception;

/**
 * An exception that is thrown when the method getInstance() of a DatabaseDAOFactory object was called,
 * which is, however, not initialized with a default database.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory
 */
public class NoDefaultDatabaseException extends IllegalArgumentException
{
    public NoDefaultDatabaseException()
    {
        super();
    }
    
    public NoDefaultDatabaseException(String message)
    {
        super(message);
    }
    
    public NoDefaultDatabaseException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public NoDefaultDatabaseException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public NoDefaultDatabaseException(Throwable cause)
    {
        super(cause);
    }
}
