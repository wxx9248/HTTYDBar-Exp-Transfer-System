package com.httydbar.exptransfer.util.exception;

import com.httydbar.exptransfer.util.impl.ConfigManager;

/**
 * An exception that is thrown when ConfigManager.parseConfiguration() or any getter is called <b>before</b> global configuration is loaded into memory,
 * i.e. used before called ConfigManager.loadJSONConfig().
 *
 * @author wxx9248
 * @see ConfigManager
 */
public class ConfigNotLoadedException extends UtilException
{
    public ConfigNotLoadedException()
    {
        super();
    }
    
    public ConfigNotLoadedException(String message)
    {
        super(message);
    }
    
    public ConfigNotLoadedException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ConfigNotLoadedException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ConfigNotLoadedException(Throwable cause)
    {
        super(cause);
    }
}
