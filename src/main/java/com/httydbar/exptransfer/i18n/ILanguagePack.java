package com.httydbar.exptransfer.i18n;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;

import java.util.Map;

/**
 * An interface that describes a language pack of this system.
 *
 * @author wxx9248
 */
public interface ILanguagePack
{
    Map<LanguageFieldHandle, String> getMap();
    
    String getField(LanguageFieldHandle handle);
}
