package com.httydbar.exptransfer.util;

import org.jetbrains.annotations.NotNull;

public class Database
{
    private final String databaseDriver;
    private final String databaseBaseURL;
    private final String databaseName;
    private final String additionalParameters;
    
    public Database(@NotNull String databaseDriver, @NotNull String databaseBaseURL, @NotNull String databaseName,
                    @NotNull String additionalParameters)
    {
        this.databaseDriver       = databaseDriver;
        this.databaseBaseURL      = databaseBaseURL;
        this.databaseName         = databaseName;
        this.additionalParameters = additionalParameters;
    }
    
    public String getDatabaseDriver() { return databaseDriver; }
    
    public String getDatabaseServerURL()
    {
        return databaseBaseURL;
    }
    
    public String getDatabaseName()
    {
        return databaseName;
    }
    
    public String getAdditionalParameters() { return additionalParameters; }
}
