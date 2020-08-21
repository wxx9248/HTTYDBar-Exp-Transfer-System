package com.httydbar.exptransfer.dao.exception;

/**
 * An exception that is thrown when performing operations on a closed database.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory
 */
public class DatabaseClosedException extends DAOException
{
    public DatabaseClosedException()
    {
        super();
    }
    
    public DatabaseClosedException(String message)
    {
        super(message);
    }
    
    public DatabaseClosedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DatabaseClosedException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DatabaseClosedException(Throwable cause)
    {
        super(cause);
    }
}
