package com.httydbar.exptransfer.util;

import org.jetbrains.annotations.NotNull;

public class ExtendedAccount extends Account
{
    private final String tiebaID;
    private final String bduss;
    private final String sToken;
    
    public ExtendedAccount(@NotNull String username, @NotNull String password, @NotNull String tiebaID,
                           @NotNull String bduss, @NotNull String sToken)
    {
        super(username, password);
        this.tiebaID = tiebaID;
        this.bduss   = bduss;
        this.sToken  = sToken;
    }
    
    public String getTiebaID()
    {
        return tiebaID;
    }
    
    public String getBDUSS()
    {
        return bduss;
    }
    
    public String getSToken()
    {
        return sToken;
    }
}
