package com.httydbar.exptransfer.dao;

import com.httydbar.exptransfer.dao.exception.DatabaseCloseFailedException;
import com.httydbar.exptransfer.dao.exception.DatabaseClosedException;
import com.httydbar.exptransfer.dao.exception.DatabaseConnectionFailedException;
import com.httydbar.exptransfer.util.impl.Account;
import com.httydbar.exptransfer.util.impl.Database;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An interface that describes a database DAO object, which manages the connection of a database system.
 *
 * @author wxx9248
 */
public interface IDatabaseDAO
{
    void connect(@NotNull Account account) throws DatabaseConnectionFailedException;
    
    void close() throws DatabaseCloseFailedException;
    
    Database getDatabase();
    
    Connection getConnection();
    
    PreparedStatement getPreparedStatement(@NotNull String query) throws DatabaseClosedException, SQLException;
    
    int doUpdate(@NotNull PreparedStatement preparedStatement) throws DatabaseClosedException, SQLException;
    
    ResultSet doQuery(@NotNull PreparedStatement preparedStatement) throws DatabaseClosedException, SQLException;
}
