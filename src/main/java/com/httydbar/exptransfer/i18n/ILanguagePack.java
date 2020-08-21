package com.httydbar.exptransfer.i18n;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;

import java.util.Map;

public interface ILanguagePack
{
    Map<LanguageFieldHandle, String> getMap();
    
    String getField(LanguageFieldHandle field);
}
