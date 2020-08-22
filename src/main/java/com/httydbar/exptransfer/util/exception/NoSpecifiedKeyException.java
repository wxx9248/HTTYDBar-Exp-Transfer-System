package com.httydbar.exptransfer.util.exception;

/**
 * An exception thrown when try to decrypt a message with no specified key.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.util.impl.RSACipher
 */
public class NoSpecifiedKeyException extends UtilException
{
    public NoSpecifiedKeyException()
    {
        super();
    }
    
    public NoSpecifiedKeyException(String message)
    {
        super(message);
    }
    
    public NoSpecifiedKeyException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public NoSpecifiedKeyException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public NoSpecifiedKeyException(Throwable cause)
    {
        super(cause);
    }
}
