package com.httydbar.exptransfer.service;

import com.github.libsgh.tieba.api.TieBaApi;
import com.httydbar.exptransfer.dao.exception.DatabaseConnectionFailedException;
import com.httydbar.exptransfer.util.exception.ConfigNotLoadedException;
import com.httydbar.exptransfer.util.exception.ConfigNotParsedException;
import com.httydbar.exptransfer.util.impl.ConfigManager;
import com.httydbar.exptransfer.util.impl.ExtendedAccount;

import java.sql.SQLException;

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
            throws DatabaseConnectionFailedException, SQLException, ConfigNotLoadedException, ConfigNotParsedException
    {
        int uid = UsernamePasswordVerificationService.verify(extendedAccount);
        if (uid > 0)
        {
            TieBaApi tiebaAPI      = new TieBaApi();
            String   privateRSAKey = ConfigManager.getPrivateRSAKey();
            
            return 0;
        }
        else
            return -1;
    }
}
