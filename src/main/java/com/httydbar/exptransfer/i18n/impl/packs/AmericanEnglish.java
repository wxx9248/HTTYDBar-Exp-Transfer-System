package com.httydbar.exptransfer.i18n.impl.packs;

import com.httydbar.exptransfer.i18n.ILanguagePack;
import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Language pack for en-US.
 *
 * @author wxx9248
 */
public class AmericanEnglish implements ILanguagePack
{
    private static final AmericanEnglish                  INSTANCE     = new AmericanEnglish();
    private static final Map<LanguageFieldHandle, String> LANGUAGE_MAP = new HashMap<LanguageFieldHandle, String>()
    {
        {
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_NO_DEFAULT_DATABASE, "Default database not set");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_CANNOT_LOAD_DRIVER, "Cannot load database driver");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_CANNOT_CONNECT_TO_DATABASE,
                "Cannot connect to database");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_FAILED_CLOSING_DATABASE_CONNECTION,
                "Failed to close database connection");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_DATABASE_CLOSED,
                "Database was closed or not connected");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_ILLEGAL_ARGUMENT, "Illegal argument");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_UNKNOWN, "Unknown database error");
            
            put(LanguageFieldHandle.E_UTIL_SQL_PARAM_MANAGER_UNSUPPORTED_SQL_DATA_TYPE, "Unsupported SQL data type");
            put(LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_LOADED, "Configuration used before loaded");
            put(LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_PARSED, "Configuration used before parsed");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_PADDING_NOT_FOUND,
                "The specified padding method is not found (RSA)");
            put(LanguageFieldHandle.E_UTIL_MD5_DIGEST_ALGORITHM_NOT_FOUND,
                "The specified algorithm is not found (MD5)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_ALGORITHM_NOT_FOUND,
                "The specified algorithm is not found (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PRIVATE_KEY, "Private key unspecified (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PUBLIC_KEY, "Public key unspecified (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN_PRIVATE_KEY_SPEC,
                "Unknown private key specification (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN_PUBLIC_KEY_SPEC,
                "Unknown public key specification (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_INVALID_PUBLIC_KEY, "Invalid public key (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_INVALID_PRIVATE_KEY, "Invalid private key (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_ILLEGAL_BLOCK_SIZE, "Invalid block size (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_BAD_PADDING, "Bad padding (RSA)");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN, "Unknown error (RSA)");
            
            put(LanguageFieldHandle.E_SERVICE_USERNAME_PASSWORD_VERIFICATION_SERVICE_UNKNOWN,
                "Unknown error during username and password verification");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_INVALID_BDUSS_OR_STOKEN, "Invalid BDUSS or SToken");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_TIEBA_ID_TOKEN_MISMATCH,
                "Tieba ID does not match BDUSS and SToken");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_TIEBA_NOT_SUBSCRIBED,
                "HTTYD bar is not subscribed");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_ZERO_RECORD_UPDATED, "No record updated");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_MULTIPLE_RECORDS_UPDATED,
                "Multiple records updated");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_UNMATCHED_REQUEST, "Unmatched request");
            
            put(LanguageFieldHandle.E_WEB_SERVLET_INVALID_AUTH_TYPE, "Invalid value of authType");
            put(LanguageFieldHandle.E_WEB_SERVLET_USERNAME_PASSWORD_MISMATCH, "Username and password mismatch");
            put(LanguageFieldHandle.E_WEB_SERVLET_UNKNOWN_ERROR, "Unknown Servlet error");
            
            put(LanguageFieldHandle.I_WEB_SERVLET_USERNAME_PASSWORD_PASS, "Verification passed");
            put(LanguageFieldHandle.I_WEB_SERVLET_MIGRATION_SUCCESS, "Credit migration success");
        }
    };
    
    // Singleton, not instantiable through constructors.
    private AmericanEnglish() {}
    
    /**
     * Getter of the instance of the class.
     *
     * @return The instance of the class.
     */
    public static AmericanEnglish getInstance() { return INSTANCE; }
    
    /**
     * Getters of the language map.
     *
     * @return The en-US language map.
     */
    @Override
    public Map<LanguageFieldHandle, String> getMap() { return LANGUAGE_MAP; }
    
    /**
     * Get the corresponding language field (different translations) based on the LanguageFieldHandle specified.
     *
     * @param handle A language handle specified in enum class LanguageFieldHandle.
     *
     * @return Corresponding language field
     *
     * @see LanguageFieldHandle
     */
    @Override
    public String getField(@NotNull LanguageFieldHandle handle) { return LANGUAGE_MAP.get(handle); }
}
