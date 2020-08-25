package com.httydbar.exptransfer.util.impl;

import org.jetbrains.annotations.NotNull;

/**
 * A class that describes data that a server response should contain.
 *
 * @author wxx9248
 */
public class ServerResponse
{
    private final String code;
    private final String message;
    
    public ServerResponse(@NotNull String code, @NotNull String message)
    {
        this.code    = code;
        this.message = message;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public String getMessage()
    {
        return message;
    }
}
