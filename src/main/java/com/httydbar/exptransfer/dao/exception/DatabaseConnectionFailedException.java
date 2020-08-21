package com.httydbar.exptransfer.dao.exception;

/**
 * An exception that is thrown when database connection fails.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory
 */
public class DatabaseConnectionFailedException extends DAOException
{
    public DatabaseConnectionFailedException()
    {
        super();
    }
    
    public DatabaseConnectionFailedException(String message)
    {
        super(message);
    }
    
    public DatabaseConnectionFailedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DatabaseConnectionFailedException(String message, Throwable cause, boolean enableSuppression,
                                             boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DatabaseConnectionFailedException(Throwable cause)
    {
        super(cause);
    }
}
