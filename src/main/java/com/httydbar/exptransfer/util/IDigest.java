package com.httydbar.exptransfer.util;

import org.jetbrains.annotations.NotNull;

/**
 * Describes a message digestion interface.
 *
 * @author wxx9248
 */
public interface IDigest
{
    /**
     * Main interface of message digestion
     *
     * @param bytes A byte array that contains the message to be digested.
     * @return Digested message
     */
    byte[] digest(@NotNull byte[] bytes);
}
