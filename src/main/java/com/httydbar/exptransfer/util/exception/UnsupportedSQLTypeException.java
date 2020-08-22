package com.httydbar.exptransfer.util.exception;

import com.httydbar.exptransfer.util.impl.SQLParamManager;

/**
 * An exception that is thrown when unsupported SQL parameters are passed.
 *
 * @author wxx9248
 * @see SQLParamManager
 */
public class UnsupportedSQLTypeException extends UtilRuntimeException
{
    public UnsupportedSQLTypeException()
    {
        super();
    }
    
    public UnsupportedSQLTypeException(String message)
    {
        super(message);
    }
    
    public UnsupportedSQLTypeException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public UnsupportedSQLTypeException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public UnsupportedSQLTypeException(Throwable cause)
    {
        super(cause);
    }
}
