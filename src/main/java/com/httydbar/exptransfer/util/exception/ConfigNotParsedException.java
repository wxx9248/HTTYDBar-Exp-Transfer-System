package com.httydbar.exptransfer.util.exception;

import com.httydbar.exptransfer.util.impl.ConfigManager;

/**
 * An exception that is thrown when any getter is called <b>before</b> global configuration is parsed into objects,
 * i.e. used before called ConfigManager.parseConfiguration().
 *
 * @author wxx9248
 * @see ConfigManager
 */
public class ConfigNotParsedException extends ConfigException
{
    public ConfigNotParsedException()
    {
        super();
    }
    
    public ConfigNotParsedException(String message)
    {
        super(message);
    }
    
    public ConfigNotParsedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ConfigNotParsedException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ConfigNotParsedException(Throwable cause)
    {
        super(cause);
    }
}
