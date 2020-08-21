package com.httydbar.exptransfer.i18n.impl.packs;

import com.httydbar.exptransfer.i18n.ILanguagePack;
import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Language pack for zh-CN.
 *
 * @author wxx9248
 * @see AmericanEnglish
 */
public final class SimplifiedChinese implements ILanguagePack
{
    private static final SimplifiedChinese                INSTANCE     = new SimplifiedChinese();
    private static final Map<LanguageFieldHandle, String> LANGUAGE_MAP = new HashMap<LanguageFieldHandle, String>()
    {
        {
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_NO_DEFAULT_DATABASE, "未提供默认数据库");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_CANNOT_LOAD_DRIVER, "不能加载数据库驱动类");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_CANNOT_CONNECT_TO_DATABASE, "不能连接到数据库");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_FAILED_CLOSING_DATABASE_CONNECTION, "不能关闭数据库连接");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_DATABASE_CLOSED, "数据库已关闭或未连接");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_ILLEGAL_ARGUMENT, "非法参数");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_UNKNOWN, "未知错误");
            
            put(LanguageFieldHandle.E_UTIL_SQL_PARAM_MANAGER_UNSUPPORTED_SQL_DATA_TYPE, "不支持的SQL数据类型");
            
            put(LanguageFieldHandle.E_SERVICE_USERNAME_PASSWORD_VERIFICATION_SERVICE_ALGORITHM_NOT_FOUND,
                "未找到指定算法（MD5）");
        }
    };
    
    private SimplifiedChinese() {}
    
    public static SimplifiedChinese getInstance()
    {
        return INSTANCE;
    }
    
    @Override
    public Map<LanguageFieldHandle, String> getMap()
    {
        return LANGUAGE_MAP;
    }
    
    @Override
    public String getField(@NotNull LanguageFieldHandle handle)
    {
        return LANGUAGE_MAP.get(handle);
    }
}
