package com.httydbar.exptransfer.util;

import com.httydbar.exptransfer.util.exception.NoSpecifiedKeyException;
import org.jetbrains.annotations.NotNull;

/**
 * Describes a message encryption and decryption interface.
 *
 * @author wxx9248
 */
public interface ICipher
{
    /**
     * Main interface of message encryption
     *
     * @param bytes A byte array that contains the message to be encrypted.
     * @return Encrypted message
     * @throws NoSpecifiedKeyException When using encryption with no key specified.
     */
    byte[] encrypt(@NotNull byte[] bytes) throws NoSpecifiedKeyException;
    
    /**
     * Main interface of message decryption
     *
     * @param bytes A byte array that contains the message to be decrypted.
     * @return Decrypted message
     * @throws NoSpecifiedKeyException When using decrypted with no key specified.
     */
    byte[] decrypt(@NotNull byte[] bytes) throws NoSpecifiedKeyException;
}
