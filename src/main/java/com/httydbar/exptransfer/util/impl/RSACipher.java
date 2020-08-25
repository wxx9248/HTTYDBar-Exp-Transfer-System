package com.httydbar.exptransfer.util.impl;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.util.ICipher;
import com.httydbar.exptransfer.util.exception.IllegalArgumentException;
import com.httydbar.exptransfer.util.exception.NoSpecifiedPrivateKeyException;
import com.httydbar.exptransfer.util.exception.NoSpecifiedPublicKeyException;
import com.httydbar.exptransfer.util.exception.UtilRuntimeException;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Provide RSA encryption algorithm
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.service.UsernamePasswordVerificationService
 */
public class RSACipher implements ICipher
{
    private final String privateKey;
    private final String publicKey;
    
    private final PrivateKey parsedPrivateKey;
    private final PublicKey  parsedPublicKey;
    
    private final Cipher rsaCipher;
    
    private RSACipher(@Nullable String privateKey, @Nullable String publicKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        this.privateKey = privateKey;
        this.publicKey  = publicKey;
        
        // For compatibility of OpenSSL-generated key-pairs
        parsedPrivateKey = parseOpenSSLPrivateKey(privateKey);
        parsedPublicKey  = parseOpenSSLPublicKey(publicKey);
        
        rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }
    
    /**
     * Get an instance of class RSACipher.
     *
     * @param privateKey A raw private key that is to be parsed.
     * @param publicKey  A raw public key that is to be parsed.
     *
     * @return An RSACipher object.
     */
    public static RSACipher getInstance(@Nullable String privateKey, @Nullable String publicKey)
    {
        try
        {
            return new RSACipher(privateKey, publicKey);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_ALGORITHM_NOT_FOUND), e);
        }
        catch (NoSuchPaddingException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_PADDING_NOT_FOUND), e);
        }
    }
    
    /**
     * Encrypt a message using RSA algorithm.
     *
     * @param bytes A byte array that contains the message to be encrypted.
     *
     * @return Encrypted message
     *
     * @throws NoSpecifiedPublicKeyException When encrypt message with no public key specified.
     */
    @Override
    public byte[] encrypt(@NotNull byte[] bytes) throws NoSpecifiedPublicKeyException
    {
        checkParsedPublicKey();
        
        try
        {
            rsaCipher.init(Cipher.ENCRYPT_MODE, parsedPublicKey);
            return rsaCipher.doFinal(bytes);
        }
        catch (InvalidKeyException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_INVALID_PUBLIC_KEY), e);
        }
        catch (IllegalBlockSizeException e)
        {
            throw new UtilRuntimeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_ILLEGAL_BLOCK_SIZE), e);
        }
        catch (BadPaddingException e)
        {
            throw new UtilRuntimeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_BAD_PADDING), e);
        }
    }
    
    
    /**
     * Decrypt a message using RSA algorithm.
     *
     * @param bytes A byte array that contains the message to be decrypted.
     *
     * @return Decrypted message
     *
     * @throws NoSpecifiedPrivateKeyException When encrypt message with no private key specified.
     */
    @Override
    public byte[] decrypt(@NotNull byte[] bytes) throws NoSpecifiedPrivateKeyException
    {
        checkParsedPrivateKey();
        
        try
        {
            rsaCipher.init(Cipher.DECRYPT_MODE, parsedPrivateKey);
            return rsaCipher.doFinal(bytes);
        }
        catch (InvalidKeyException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_INVALID_PUBLIC_KEY), e);
        }
        catch (IllegalBlockSizeException e)
        {
            throw new UtilRuntimeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_ILLEGAL_BLOCK_SIZE), e);
        }
        catch (BadPaddingException e)
        {
            throw new UtilRuntimeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_BAD_PADDING), e);
        }
    }
    
    /**
     * Getter of privateKey
     *
     * @return The raw private key that is to be parsed.
     */
    public String getPrivateKey()
    {
        return privateKey;
    }
    
    /**
     * Getter of publicKey
     *
     * @return The raw public key that is to be parsed.
     */
    public String getPublicKey()
    {
        return publicKey;
    }
    
    /**
     * Getter of parsedPrivateKey
     *
     * @return The parsed private key.
     */
    public PrivateKey getParsedPrivateKey()
    {
        return parsedPrivateKey;
    }
    
    /**
     * Getter of parsedPublicKey
     *
     * @return The parsed public key.
     */
    public PublicKey getParsedPublicKey()
    {
        return parsedPublicKey;
    }
    
    private void checkParsedPrivateKey() throws NoSpecifiedPrivateKeyException
    {
        if (parsedPrivateKey == null)
            throw new NoSpecifiedPrivateKeyException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PRIVATE_KEY));
    }
    
    private void checkParsedPublicKey() throws NoSpecifiedPublicKeyException
    {
        if (parsedPublicKey == null)
            throw new NoSpecifiedPublicKeyException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PUBLIC_KEY));
    }
    
    private PrivateKey parseOpenSSLPrivateKey(@Nullable String privateKey)
    {
        if (privateKey == null)
            return null;
        
        String privateKeyBase64 = privateKey.replace("-----BEGIN RSA PRIVATE KEY-----", "")
                                            .replace("-----END RSA PRIVATE KEY-----", "").replaceAll("\\s", "");
        
        byte[] privateKeyDER = ByteCodec.Base64String.toByteArray(privateKeyBase64);
        
        try
        {
            // Convert PKCS#1 to PKCS#8, which is Java-compatible.
            RSAPrivateKeyStructure asn1PrivateKey = new RSAPrivateKeyStructure(
                    (ASN1Sequence) ASN1Sequence.fromByteArray(privateKeyDER));
            RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(asn1PrivateKey.getModulus(),
                                                                        asn1PrivateKey.getPrivateExponent());
            
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(rsaPrivateKeySpec);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_ALGORITHM_NOT_FOUND), e);
        }
        catch (InvalidKeySpecException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN_PUBLIC_KEY_SPEC), e);
        }
        catch (IOException e)
        {
            throw new UtilRuntimeException(
                    LanguageProvider.getCurrentLanguage().getField(LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN), e);
        }
    }
    
    private PublicKey parseOpenSSLPublicKey(@Nullable String publicKey)
    {
        if (publicKey == null)
            return null;
        
        String publicKeyBase64 = publicKey.replace("-----BEGIN PUBLIC KEY-----", "")
                                          .replace("-----END PUBLIC KEY-----", "")
                                          .replaceAll("\\s", "");
        
        byte[] publicKeyDER = ByteCodec.Base64String.toByteArray(publicKeyBase64);
        
        try
        {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyDER));
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_ALGORITHM_NOT_FOUND), e);
        }
        catch (InvalidKeySpecException e)
        {
            throw new IllegalArgumentException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_RSA_CIPHER_UNKNOWN_PUBLIC_KEY_SPEC), e);
        }
    }
}
