package com.httydbar.exptransfer.i18n.impl;

import com.httydbar.exptransfer.i18n.ILanguagePack;
import com.httydbar.exptransfer.i18n.impl.packs.AmericanEnglish;

/**
 * A class that are used to store the currently used language of the system.
 *
 * @author wxx9248
 */
public class LanguageProvider
{
    // Pure static, not instantiable.
    private LanguageProvider() {}
    
    private static final ILanguagePack CURRENT_LANGUAGE = AmericanEnglish.getInstance();
    
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
