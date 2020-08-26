package com.httydbar.exptransfer.i18n.impl;

import com.httydbar.exptransfer.i18n.ILanguagePack;
import com.httydbar.exptransfer.i18n.impl.packs.SimplifiedChinese;

/**
 * A class that are used to store the currently used language of the system.
 *
 * @author wxx9248
 */
public class LanguageProvider
{
    private static final ILanguagePack CURRENT_LANGUAGE = SimplifiedChinese.getInstance();
    
    // Pure static, not instantiable.
    private LanguageProvider() {}
    
    /**
     * Getter of currently used language pack.
     *
     * @return Currently used language pack.
     */
    public static ILanguagePack getCurrentLanguage()
    {
        return CURRENT_LANGUAGE;
    }
}
