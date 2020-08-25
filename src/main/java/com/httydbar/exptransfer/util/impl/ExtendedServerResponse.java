package com.httydbar.exptransfer.util.impl;

import org.jetbrains.annotations.NotNull;

/**
 * A class that describes data that a extended server response should contain.
 *
 * @author wxx9248
 */
public class ExtendedServerResponse extends ServerResponse
{
    private final int credit;
    
    public ExtendedServerResponse(@NotNull String code, @NotNull String message, int credit)
    {
        super(code, message);
        this.credit = credit;
    }
    
    public int getCredit()
    {
        return credit;
    }
}
