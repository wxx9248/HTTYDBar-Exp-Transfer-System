package com.httydbar.exptransfer.util.impl;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.util.IDigest;
import com.httydbar.exptransfer.util.exception.IllegalArgumentException;
import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Provide MD5 digestion algorithm
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.service.UsernamePasswordVerificationService
 */
public class MD5Digest implements IDigest
{
    private final MessageDigest messageDigest;
    
    private MD5Digest() throws NoSuchAlgorithmException
    {
        messageDigest = MessageDigest.getInstance("MD5");
    }
    
    /**
     * Get an instance of MD5Digest class.
     *
     * @return A MD5Digest object
     */
    public static MD5Digest getInstance()
    {
        try
        {
            return new MD5Digest();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_MD5_DIGEST_ALGORITHM_NOT_FOUND), e);
        }
    }
    
    /**
     * Generate a digest of a byte array.
     *
     * @param bytes A byte array that contains the message to be digested.
     *
     * @return Generated digest information.
     */
    @Override
    public byte[] digest(@NotNull byte[] bytes)
    {
        return messageDigest.digest(bytes);
    }
}
