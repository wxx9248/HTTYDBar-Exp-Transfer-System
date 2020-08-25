package com.httydbar.exptransfer.service;

import com.github.libsgh.tieba.api.TieBaApi;
import com.github.libsgh.tieba.model.MyTB;
import com.httydbar.exptransfer.dao.IDatabaseDAOWithAccount;
import com.httydbar.exptransfer.dao.exception.DAOException;
import com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory;
import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.service.exception.*;
import com.httydbar.exptransfer.util.ICipher;
import com.httydbar.exptransfer.util.exception.ConfigException;
import com.httydbar.exptransfer.util.exception.NoSpecifiedKeyException;
import com.httydbar.exptransfer.util.impl.*;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * A service class that is used to migrate Tieba experience value to forum database
 *
 * @author wxx9248
 */
public class ExpMigrationService
{
    // Pure static, not instantiable.
    private ExpMigrationService() {}
    
    public static int migrate(ExtendedAccount extendedAccount)
            throws DAOException, SQLException, ConfigException, NoSpecifiedKeyException, TiebaNotSubscribedException,
                   InvalidTokenException
    {
        int uid = UsernamePasswordVerificationService.verify(extendedAccount);
        if (uid > 0)
        {
            // Get BDUSS and SToken
            ICipher cipher = RSACipher.getInstance(ConfigManager.getPrivateRSAKey(), ConfigManager.getPublicRSAKey());
            
            String tiebaID = extendedAccount.getTiebaID();
            
            String bduss = new String(cipher.decrypt(ByteCodec.Base64String.toByteArray(extendedAccount.getBDUSS())),
                                      StandardCharsets.UTF_8);
            
            String sToken = new String(cipher.decrypt(ByteCodec.Base64String.toByteArray(extendedAccount.getSToken())),
                                       StandardCharsets.UTF_8);
            
            
            // Get the list of followed bars
            TieBaApi   tiebaAPI     = new TieBaApi();
            List<MyTB> myLikedTieba = tiebaAPI.getMyLikedTB(bduss, sToken);
            int        exp          = -1;
            
            if (myLikedTieba.size() > 0)
            {
                for (MyTB myTB : myLikedTieba)
                {
                    if (myTB.getTbName().equals("驯龙高手"))
                    {
                        exp = myTB.getEx();
                        break;
                    }
                }
            }
            else
            {
                throw new InvalidTokenException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_INVALID_BDUSS_OR_STOKEN));
            }
            
            if (exp == -1)
            {
                throw new TiebaNotSubscribedException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_TIEBA_NOT_SUBSCRIBED));
            }
            
            // Update credits
            IDatabaseDAOWithAccount databaseDAO = new DatabaseDAOFactory().getInstance(
                    ConfigManager.getDatabaseAccount(), ConfigManager.getDatabaseConfiguration());
            SQLParamManager sqlParamManager = new SQLParamManager();
            
            databaseDAO.connect();
            PreparedStatement preparedStatement = databaseDAO.getPreparedStatement(
                    "UPDATE pre_common_member SET credits = ? WHERE uid = ?;");
            
            sqlParamManager.addParam(exp);
            sqlParamManager.addParam(uid);
            sqlParamManager.populatePreparedStatement(preparedStatement);
            
            switch (databaseDAO.doUpdate(preparedStatement))
            {
                case 0:
                    throw new ZeroRecordUpdatedException(LanguageProvider.getCurrentLanguage().getField(
                            LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_ZERO_RECORD_UPDATED));
                case 1:
                    return exp;
                default:
                    throw new MultipleRecordsUpdatedException(LanguageProvider.getCurrentLanguage().getField(
                            LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_MULTIPLE_RECORDS_UPDATED));
            }
        }
        else
            throw new UnmatchedRequestException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_UNMATCHED_REQUEST));
    }
}
