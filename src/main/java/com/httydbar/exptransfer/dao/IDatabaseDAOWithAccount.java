package com.httydbar.exptransfer.dao;

import com.httydbar.exptransfer.dao.exception.DatabaseConnectionFailedException;

public interface IDatabaseDAOWithAccount extends IDatabaseDAO
{
    void connect() throws DatabaseConnectionFailedException;
}
