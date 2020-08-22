package com.httydbar.exptransfer.dao.impl;

import com.httydbar.exptransfer.dao.IDatabaseDAO;
import com.httydbar.exptransfer.dao.IDatabaseDAOWithAccount;
import com.httydbar.exptransfer.dao.exception.*;
import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.util.impl.Account;
import com.httydbar.exptransfer.util.impl.Database;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

/**
 * A factory class the generates IDatabaseDAO objects, which are used to manipulate databases.
 *
 * @author wxx9248
 * @see IDatabaseDAO
 */
public class DatabaseDAOFactory
{
    private final Database defaultDatabase;
    
    /**
     * The constructor of class DatabaseDAOFactory, which takes in a Database object as the default database of all
     * IDatabaseDAO objects that are to be produced.
     *
     * @param defaultDatabase Default database of all IDatabaseDAO objects produced by the factory instance.
     *
     * @see IDatabaseDAO
     * @see Database
     */
    public DatabaseDAOFactory(Database defaultDatabase)
    {
        this.defaultDatabase = defaultDatabase;
    }
    
    /**
     * The constructor of class DatabaseDAOFactory, which takes no arguments.
     * Use <b>getInstance()</b> will result in a <i>NoDefaultDatabaseException</i>.
     *
     * @see com.httydbar.exptransfer.dao.exception.NoDefaultDatabaseException
     */
    public DatabaseDAOFactory()
    {
        this(null);
    }
    
    /**
     * This method is used to get an instance of DatabaseDAO class, with the default database.
     *
     * @return A produced DatabaseDAO object.
     *
     * @see DatabaseDAO
     */
    public DatabaseDAO getInstance()
    {
        if (defaultDatabase != null)
        {
            return new DatabaseDAO(defaultDatabase);
        }
        else
        {
            throw new NoDefaultDatabaseException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_NO_DEFAULT_DATABASE));
        }
    }
    
    /**
     * This method is used to get an instance of DatabaseDAO class, with a specified Database object.
     *
     * @param database Specified database object.
     *
     * @return A produced DatabaseDAO object.
     *
     * @see DatabaseDAO
     * @see Database
     */
    public DatabaseDAO getInstance(@NotNull Database database)
    {
        return new DatabaseDAO(database);
    }
    
    /**
     * This method is used to get an instance of DatabaseDAOWithAccount class, with a specified default account that are used in
     * the database connection.
     *
     * @param defaultAccount Specified default account in the DatabaseDAOWithAccount instance.
     *
     * @return A produced DatabaseDAOWithAccount object.
     *
     * @see DatabaseDAOWithAccount
     * @see Account
     */
    public DatabaseDAOWithAccount getInstance(@NotNull Account defaultAccount)
    {
        if (defaultDatabase != null)
        {
            return new DatabaseDAOWithAccount(defaultDatabase, defaultAccount);
        }
        else
        {
            throw new NoDefaultDatabaseException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_NO_DEFAULT_DATABASE));
        }
    }
    
    /**
     * This method is used to get an instance of DatabaseDAOWithAccount class, with a specified Database object and a specified default
     * account that are used in the database connection.
     *
     * @param defaultAccount Specified default account in the DatabaseDAOWithAccount instance.
     * @param database       Specified database object
     *
     * @return A produced DatabaseDAOWithAccount object.
     *
     * @see DatabaseDAOWithAccount
     * @see Database
     * @see Account
     */
    public DatabaseDAOWithAccount getInstance(@NotNull Account defaultAccount, @NotNull Database database)
    {
        return new DatabaseDAOWithAccount(database, defaultAccount);
    }
    
    
    /**
     * An implementation of the IDatabaseDAO interface, with a default account stored in the object.
     * Not accessible in the outside.
     *
     * @author wxx9248
     * @see IDatabaseDAO
     */
    private static class DatabaseDAO implements IDatabaseDAO
    {
        private final Database database;
        
        private Connection connection;
        
        /**
         * The constructor of DatabaseDAO class.
         *
         * @param database Describe the database that are to connect.
         */
        public DatabaseDAO(Database database)
        {
            this.database = database;
        }
        
        /**
         * Connect to the database.
         *
         * @param account Specify an account when connecting to the database
         *
         * @throws DatabaseConnectionFailedException When failed to connect to the database
         */
        @Override
        public void connect(@NotNull Account account) throws DatabaseConnectionFailedException
        {
            try
            {
                Class.forName(database.getDatabaseDriver());
            }
            catch (ClassNotFoundException e)
            {
                throw new DriverLoadFailedException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_CANNOT_LOAD_DRIVER), e);
            }
            
            try
            {
                if (connection != null && !connection.isClosed())
                    connection.close();
                
                connection = DriverManager.getConnection(
                        database.getDatabaseServerURL() + "/" + database.getDatabaseName() + database.getAdditionalParameters(),
                        account.getUsername(),
                        account.getPassword());
            }
            catch (SQLException e)
            {
                throw new DatabaseConnectionFailedException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_CANNOT_CONNECT_TO_DATABASE), e);
            }
        }
        
        /**
         * Close the database connection.
         *
         * @throws DatabaseCloseFailedException When failed to close the connection to the database.
         */
        @Override
        public void close() throws DatabaseCloseFailedException
        {
            if (connection != null)
            {
                try
                {
                    connection.close();
                    connection = null;
                }
                catch (SQLException e)
                {
                    throw new DatabaseCloseFailedException(LanguageProvider.getCurrentLanguage().getField(
                            LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_FAILED_CLOSING_DATABASE_CONNECTION), e);
                }
            }
        }
        
        @Override
        public Database getDatabase()
        {
            return database;
        }
        
        @Override
        public Connection getConnection()
        {
            return connection;
        }
        
        @Override
        public PreparedStatement getPreparedStatement(@NotNull String query) throws SQLException
        {
            return connection.prepareStatement(query);
        }
        
        /**
         * Perform modification operations to the database, e.g. CREATE, DELETE, ALTER, UPDATE
         *
         * @return The number of rows affected.
         */
        @Override
        public int doUpdate(@NotNull PreparedStatement preparedStatement)
                throws DAOException, SQLException
        {
            if (connection != null)
            {
                return preparedStatement.executeUpdate();
            }
            else
                throw new DatabaseClosedException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_DATABASE_CLOSED));
        }
        
        /**
         * Perform query operations to the database, e.g. SELECT
         *
         * @return The result set, as a List of Array.
         */
        @Override
        public ResultSet doQuery(@NotNull PreparedStatement preparedStatement)
                throws DAOException, SQLException
        {
            if (connection != null)
            {
                return preparedStatement.executeQuery();
            }
            else
                throw new DatabaseClosedException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_DATABASE_CLOSED));
        }
    }
    
    /**
     * An implementation of the IDatabaseDAO interface, with a default account and a default database stored in the object.
     * Not accessible in the outside.
     *
     * @author wxx9248
     * @see IDatabaseDAO
     */
    private static class DatabaseDAOWithAccount extends DatabaseDAO implements IDatabaseDAOWithAccount
    {
        private final Account defaultAccount;
        
        public DatabaseDAOWithAccount(Database database, Account defaultAccount)
        {
            super(database);
            this.defaultAccount = defaultAccount;
        }
        
        /**
         * Connect to the default database
         *
         * @throws DatabaseConnectionFailedException When failed to connect to the database.
         */
        @Override
        public void connect() throws DatabaseConnectionFailedException
        {
            connect(defaultAccount);
        }
    }
}
