package com.httydbar.exptransfer.service;

import com.httydbar.exptransfer.dao.IDatabaseDAOWithAccount;
import com.httydbar.exptransfer.dao.exception.DatabaseClosedException;
import com.httydbar.exptransfer.dao.exception.DatabaseConnectionFailedException;
import com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory;
import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.service.exception.ServiceRuntimeException;
import com.httydbar.exptransfer.util.IDigest;
import com.httydbar.exptransfer.util.exception.ConfigException;
import com.httydbar.exptransfer.util.exception.ConfigNotLoadedException;
import com.httydbar.exptransfer.util.exception.ConfigNotParsedException;
import com.httydbar.exptransfer.util.impl.*;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A service class that is used to verify the correctness of a username-password pair.
 *
 * @author wxx9248
 */
public class UsernamePasswordVerificationService
{
    // Pure static, not instantiable.
    private UsernamePasswordVerificationService() {}
    
    /**
     * Verify the correctness of a username-password pair.
     *
     * @param account An Account object that describes a forum account
     *
     * @return UID if succeeded, -1 if failed.
     *
     * @throws DatabaseConnectionFailedException When database connection is failed.
     * @throws SQLException                      When other SQL errors occurred.
     * @throws ConfigNotLoadedException          When global config has not been loaded.
     * @throws ConfigNotParsedException          When global config has not been parsed.
     */
    public static int verify(Account account) throws DatabaseConnectionFailedException, SQLException,
                                                     ConfigException
    {
        String username    = account.getUsername();
        String md5Password = account.getPassword();
        
        SQLParamManager         sqlParamManager    = new SQLParamManager();
        DatabaseDAOFactory      databaseDAOFactory = new DatabaseDAOFactory(ConfigManager.getDatabaseConfiguration());
        IDatabaseDAOWithAccount dataBaseDAO        = databaseDAOFactory.getInstance(ConfigManager.getDatabaseAccount());
        
        PreparedStatement preparedStatement;
        try
        {
            dataBaseDAO.connect();
            preparedStatement = dataBaseDAO.getPreparedStatement(
                    "SELECT uid, password, salt FROM pre_ucenter_members WHERE username = ?;");
        }
        catch (DatabaseClosedException e)
        {
            throw new ServiceRuntimeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_UNKNOWN), e);
        }
        
        sqlParamManager.addParam(username);
        
        ResultSet resultSet = sqlParamManager.populatePreparedStatement(preparedStatement).executeQuery();
        
        int    uid;
        String saltedPassword;
        String salt;
        
        if (resultSet.next())
        {
            uid            = resultSet.getInt("uid");
            saltedPassword = resultSet.getString("password");
            salt           = resultSet.getString("salt");
        }
        else
            return -1;
        
        IDigest md5Digest = MD5Digest.getInstance();
        
        if (saltedPassword.equals(ByteCodec.HexString.toHexString(md5Digest.digest((md5Password + salt).getBytes(
                StandardCharsets.UTF_8)), 32)))
        {
            return uid;
        }
        else
        {
            return -1;
        }
    }
}
