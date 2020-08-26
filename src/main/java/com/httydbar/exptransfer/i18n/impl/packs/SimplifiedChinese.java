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
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_ILLEGAL_ARGUMENT, "无效的参数");
            put(LanguageFieldHandle.E_DAO_IMPL_DATABASE_DAO_FACTORY_UNKNOWN, "未知数据库错误");
            
            put(LanguageFieldHandle.E_UTIL_SQL_PARAM_MANAGER_UNSUPPORTED_SQL_DATA_TYPE, "不支持的SQL数据类型");
            put(LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_LOADED, "使用了未加载的配置");
            put(LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_PARSED, "使用了未解析的配置");
            put(LanguageFieldHandle.E_UTIL_MD5_DIGEST_ALGORITHM_NOT_FOUND, "未找到指定算法（MD5）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_ALGORITHM_NOT_FOUND, "未找到指定算法（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_PADDING_NOT_FOUND, "未找到指定填充方式（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PRIVATE_KEY, "未指定私钥（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PUBLIC_KEY, "未指定公钥（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN_PRIVATE_KEY_SPEC, "未知的私钥格式（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN_PUBLIC_KEY_SPEC, "未知的公钥格式（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_INVALID_PUBLIC_KEY, "无效的公钥（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_INVALID_PRIVATE_KEY, "无效的私钥（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_ILLEGAL_BLOCK_SIZE, "无效的块大小（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_BAD_PADDING, "无效的填充方式（RSA）");
            put(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN, "未知的错误（RSA）");
            
            put(LanguageFieldHandle.E_SERVICE_USERNAME_PASSWORD_VERIFICATION_SERVICE_UNKNOWN, "在验证用户名和密码时发生未知错误");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_INVALID_BDUSS_OR_STOKEN, "无效的BDUSS或SToken");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_TIEBA_ID_TOKEN_MISMATCH, "贴吧ID和BDUSS值或SToken值不匹配");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_TIEBA_NOT_SUBSCRIBED, "未关注驯龙高手吧");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_ZERO_RECORD_UPDATED, "零更新记录数");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_MULTIPLE_RECORDS_UPDATED, "多更新记录数");
            put(LanguageFieldHandle.E_SERVICE_EXP_MIGRATION_SERVICE_UNMATCHED_REQUEST, "两次提交的用户名密码不一致");
            
            put(LanguageFieldHandle.E_WEB_SERVLET_INVALID_AUTH_TYPE, "authType值无效");
            put(LanguageFieldHandle.E_WEB_SERVLET_USERNAME_PASSWORD_MISMATCH, "用户名或密码不正确");
            put(LanguageFieldHandle.E_WEB_SERVLET_UNKNOWN_ERROR, "未知的Servlet错误");
            
            put(LanguageFieldHandle.I_WEB_SERVLET_USERNAME_PASSWORD_PASS, "验证通过");
            put(LanguageFieldHandle.I_WEB_SERVLET_MIGRATION_SUCCESS, "经验转移完成");
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
