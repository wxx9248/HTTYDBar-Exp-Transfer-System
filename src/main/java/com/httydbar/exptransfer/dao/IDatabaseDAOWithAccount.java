package com.httydbar.exptransfer.dao;

import com.httydbar.exptransfer.dao.exception.DatabaseConnectionFailedException;

/**
 * An extension of IDatabaseDAO, making it able to store a default account inside.
 *
 * @author wxx9248
 * @see IDatabaseDAO
 */
public interface IDatabaseDAOWithAccount extends IDatabaseDAO
{
    void connect() throws DatabaseConnectionFailedException;
}
