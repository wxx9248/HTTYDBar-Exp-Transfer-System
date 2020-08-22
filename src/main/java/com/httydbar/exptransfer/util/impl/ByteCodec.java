package com.httydbar.exptransfer.util.impl;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Base64;

/**
 * Provide encoding and decoding operations on byte arrays.
 *
 * @author wxx9248
 * @see com.httydbar.exptransfer.service.UsernamePasswordVerificationService
 */
public class ByteCodec
{
    // Pure static, not instantiable.
    private ByteCodec() {}
    
    /**
     * Hex string encoding and decoding operations.
     *
     * @author wxx9248
     */
    public static class HexString
    {
        // Pure static, not instantiable.
        private HexString() {}
        
        /**
         * Encode a byte array to a hex string.
         *
         * @param bytes A byte array
         *
         * @return Encoded hex string
         */
        public static String toHexString(@NotNull byte[] bytes)
        {
            return toHexString(bytes, 0);
        }
        
        /**
         * Encode a byte array to a hex string, with zero padding
         *
         * @param bytes         A byte array
         * @param minimumLength Minimum length of the encoded hex string, front padded with zeros.
         *
         * @return Encoded hex string
         */
        public static String toHexString(@NotNull byte[] bytes, int minimumLength)
        {
            BigInteger    numericMessageDigest          = new BigInteger(1, bytes);
            StringBuilder hexStringMessageDigestBuilder = new StringBuilder(numericMessageDigest.toString(16));
            
            // Front zero padding
            while (hexStringMessageDigestBuilder.length() < minimumLength)
            {
                hexStringMessageDigestBuilder.insert(0, "0");
            }
            
            return hexStringMessageDigestBuilder.toString();
        }
    }
    
    /**
     * Base64 encoding and decoding operations.
     *
     * @author wxx9248
     */
    public static class Base64String
    {
        // Pure static, not instantiable.
        private Base64String() {}
        
        /**
         * Encode a byte array to a hex string.
         *
         * @param bytes A byte array
         *
         * @return Encoded Base64 string
         */
        public static String toBase64String(@NotNull byte[] bytes)
        {
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(bytes);
        }
        
        /**
         * Decode a Base64 string to a byte array.
         *
         * @param base64String A Base64 string
         *
         * @return Decoded byte array.
         */
        public static byte[] toByteArray(@NotNull String base64String)
        {
            Base64.Decoder decoder = Base64.getDecoder();
            return decoder.decode(base64String);
        }
    }
}
