package com.httydbar.exptransfer.util.exception;

/**
 * An exception thrown when try to encrypt a message with no specified public key.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.util.impl.RSACipher
 */
public class NoSpecifiedPublicKeyException extends NoSpecifiedKeyException
{
    public NoSpecifiedPublicKeyException()
    {
        super();
    }
    
    public NoSpecifiedPublicKeyException(String message)
    {
        super(message);
    }
    
    public NoSpecifiedPublicKeyException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public NoSpecifiedPublicKeyException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public NoSpecifiedPublicKeyException(Throwable cause)
    {
        super(cause);
    }
}
