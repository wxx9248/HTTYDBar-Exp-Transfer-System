package com.httydbar.exptransfer.util.impl;

import org.jetbrains.annotations.NotNull;

/**
 * A class that describes a database system.
 *
 * @author wxx9248
 */
public class Database
{
    private final String databaseDriver;
    private final String databaseBaseURL;
    private final String databaseName;
    private final String additionalParameters;
    
    /**
     * Constructor of the Database class.
     *
     * @param databaseDriver       The driver class of database, e.g. "com.mysql.cj.jdbc.Driver"
     * @param databaseBaseURL      URL of the database server, e.g. "jdbc:mysql://localhost:3306"
     * @param databaseName         The name of targeted database
     * @param additionalParameters Additional parameters of the database server URL, e.g. "?useUnicode=true&characterEncoding=utf-8"
     */
    public Database(@NotNull String databaseDriver, @NotNull String databaseBaseURL, @NotNull String databaseName,
                    @NotNull String additionalParameters)
    {
        this.databaseDriver       = databaseDriver;
        this.databaseBaseURL      = databaseBaseURL;
        this.databaseName         = databaseName;
        this.additionalParameters = additionalParameters;
    }
    
    public String getDatabaseDriver()       { return databaseDriver; }
    
    public String getDatabaseServerURL()    { return databaseBaseURL; }
    
    public String getDatabaseName()         { return databaseName; }
    
    public String getAdditionalParameters() { return additionalParameters; }
}
