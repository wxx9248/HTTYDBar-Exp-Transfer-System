package com.httydbar.exptransfer.i18n.impl;

import com.httydbar.exptransfer.i18n.ILanguagePack;
import com.httydbar.exptransfer.i18n.impl.packs.AmericanEnglish;

public class LanguageProvider
{
    private static final ILanguagePack CURRENT_LANGUAGE = AmericanEnglish.getInstance();
    
    public static ILanguagePack getCurrentLanguage()
    {
        return CURRENT_LANGUAGE;
    }
}
