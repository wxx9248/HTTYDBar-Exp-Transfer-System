package com.httydbar.exptransfer.util.exception;

import com.httydbar.exptransfer.util.impl.ConfigManager;

/**
 * An exception that is thrown when ConfigManager.parseConfiguration() or any getter is called <b>before</b> global configuration is loaded into memory,
 * i.e. used before called ConfigManager.loadJSONConfig().
 *
 * @author wxx9248
 * @see ConfigManager
 */
public class ConfigException extends UtilException
{
    public ConfigException()
    {
        super();
    }
    
    public ConfigException(String message)
    {
        super(message);
    }
    
    public ConfigException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ConfigException(String message, Throwable cause, boolean enableSuppression,
                           boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public ConfigException(Throwable cause)
    {
        super(cause);
    }
}
