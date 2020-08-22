package com.httydbar.exptransfer.util.exception;

/**
 * An exception thrown when try to decrypt a message with no specified private key.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.util.impl.RSACipher
 */
public class NoSpecifiedPrivateKeyException extends NoSpecifiedKeyException
{
    public NoSpecifiedPrivateKeyException()
    {
        super();
    }
    
    public NoSpecifiedPrivateKeyException(String message)
    {
        super(message);
    }
    
    public NoSpecifiedPrivateKeyException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public NoSpecifiedPrivateKeyException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public NoSpecifiedPrivateKeyException(Throwable cause)
    {
        super(cause);
    }
}
