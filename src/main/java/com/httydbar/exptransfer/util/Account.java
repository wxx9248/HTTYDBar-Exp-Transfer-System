package com.httydbar.exptransfer.util;

import org.jetbrains.annotations.NotNull;

public class Account
{
    private final String username;
    private final String password;
    
    public Account(@NotNull String username, @NotNull String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
}
