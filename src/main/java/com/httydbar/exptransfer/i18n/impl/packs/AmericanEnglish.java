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
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_UNKNOWN, "Unknown error");
            
            put(LanguageFieldHandle.E_UTIL_SQL_PARAM_MANAGER_UNSUPPORTED_SQL_DATA_TYPE, "Unsupported SQL data type");
            
            put(LanguageFieldHandle.E_SERVICE_USERNAME_PASSWORD_VERIFICATION_SERVICE_ALGORITHM_NOT_FOUND,
                "The specified algorithm is not found (MD5)");
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
     * @return Corresponding language field
     *
     * @see LanguageFieldHandle
     */
    @Override
    public String getField(@NotNull LanguageFieldHandle handle) { return LANGUAGE_MAP.get(handle); }
}
