package com.httydbar.exptransfer.service;

import com.httydbar.exptransfer.dao.IDatabaseDAOWithAccount;
import com.httydbar.exptransfer.dao.exception.DatabaseConnectionFailedException;
import com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory;
import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.service.exception.AlgorithmNotFoundException;
import com.httydbar.exptransfer.util.Account;
import com.httydbar.exptransfer.util.ConfigManager;
import com.httydbar.exptransfer.util.SQLParamManager;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsernamePasswordVerificationService
{
    /**
     * Verify the correctness of a username-password pair.
     *
     * @param account An Account object that describes a forum account
     *
     * @return UID if succeeded, -1 if failed.
     *
     * @throws DatabaseConnectionFailedException When database connection is failed.
     * @throws SQLException                      When other SQL errors occured.
     */
    public static int verify(Account account) throws DatabaseConnectionFailedException, SQLException
    {
        String username    = account.getUsername();
        String md5Password = account.getPassword();
        
        SQLParamManager         sqlParamManager    = new SQLParamManager();
        DatabaseDAOFactory      databaseDAOFactory = new DatabaseDAOFactory(ConfigManager.getDatabaseConfiguration());
        IDatabaseDAOWithAccount dataBaseDAO        = databaseDAOFactory.getInstance(ConfigManager.getDatabaseAccount());
        
        dataBaseDAO.connect();
        PreparedStatement preparedStatement = dataBaseDAO.getPreparedStatement(
                "SELECT uid, password, salt FROM pre_ucenter_members WHERE username = ?;");
        sqlParamManager.addParam(username);
        
        ResultSet resultSet = sqlParamManager.populatePreparedStatement(preparedStatement).executeQuery();
        resultSet.next();
        
        int    uid            = resultSet.getInt("uid");
        String saltedPassword = resultSet.getString("password");
        String salt           = resultSet.getString("salt");
        
        if (saltedPassword.equals(getMD5(md5Password + salt)))
        {
            return uid;
        }
        else
        {
            return -1;
        }
    }
    
    private static String getMD5(String input)
    {
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            
            byte[]     rawMessageDigest     = messageDigest.digest(input.getBytes());
            BigInteger numericMessageDigest = new BigInteger(1, rawMessageDigest);
            
            StringBuilder hexStringMessageDigestBuilder = new StringBuilder(numericMessageDigest.toString(16));
            // Front zero padding
            while (hexStringMessageDigestBuilder.length() < 32)
            {
                hexStringMessageDigestBuilder.insert(0, "0");
            }
            
            return hexStringMessageDigestBuilder.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new AlgorithmNotFoundException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_SERVICE_USERNAME_PASSWORD_VERIFICATION_SERVICE_ALGORITHM_NOT_FOUND), e);
        }
    }
}
