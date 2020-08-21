package com.httydbar.exptransfer.dao.exception;

/**
 * The base exception class for all DAO operations
 *
 * @author wxx9248
 */
public class DAOException extends Exception
{
    public DAOException()
    {
        super();
    }
    
    public DAOException(String message)
    {
        super(message);
    }
    
    public DAOException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DAOException(String message, Throwable cause, boolean enableSuppression,
                        boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public DAOException(Throwable cause)
    {
        super(cause);
    }
}
