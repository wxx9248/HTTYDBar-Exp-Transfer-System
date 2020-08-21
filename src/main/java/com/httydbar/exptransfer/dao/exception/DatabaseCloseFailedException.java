package com.httydbar.exptransfer.dao.exception;

/**
 * An exception that is thrown when failed to close a database connection.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory
 */
public class DatabaseCloseFailedException extends DAOException
{
    public DatabaseCloseFailedException()
    {
        super();
    }
    
    public DatabaseCloseFailedException(String message)
    {
        super(message);
    }
    
    public DatabaseCloseFailedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DatabaseCloseFailedException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DatabaseCloseFailedException(Throwable cause)
    {
        super(cause);
    }
}
