package com.httydbar.exptransfer.util.impl;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.util.exception.ConfigNotLoadedException;
import com.httydbar.exptransfer.util.exception.ConfigNotParsedException;
import com.httydbar.exptransfer.util.exception.NoSpecifiedPrivateKeyException;
import com.httydbar.exptransfer.util.exception.NoSpecifiedPublicKeyException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

/**
 * Class that manages global config using JSON.
 * <p>
 * Use as the list below indicated:
 * 1. loadJSONConfig
 * 2. parseConfiguration
 * 3. Use getters to access
 *
 * @author wxx9248
 */
public class ConfigManager
{
    private static JsonObject jsonObject     = null;
    private static boolean    isConfigParsed = false;
    
    // Object that stored configuration information, may be needed by other classes.
    private static Database databaseConfiguration;
    private static Account  databaseAccount;
    // Not paired
    private static String   privateRSAKey;
    private static String   publicRSAKey;
    
    // Pure static, not instantiable.
    private ConfigManager() {}
    
    /**
     * Load JSON Config from a Reader class.
     *
     * @param reader A Reader class that character stream comes from.
     *
     * @see Reader
     */
    public static void loadJSONConfig(Reader reader)
    {
        JsonReader jsonReader = Json.createReader(reader);
        jsonObject = jsonReader.readObject();
        jsonReader.close();
    }
    
    /**
     * Load JSON Config from a file.
     *
     * @param filePath A file path that points to the configuration file.
     *
     * @throws FileNotFoundException When the configuration file is not found.
     */
    public static void loadJSONConfigFromFile(String filePath) throws FileNotFoundException
    {
        loadJSONConfig(new FileReader(filePath));
    }
    
    /**
     * Load JSON Config from a String.
     *
     * @param config A JSON String that stores configuration information.
     */
    public static void loadJSONConfigFromString(String config)
    {
        loadJSONConfig(new StringReader(config));
    }
    
    /**
     * Returns the JSON object that are read through loadJSONConfig series function.
     *
     * @return The JSON configuration object that stored in this class.
     */
    public static JsonObject getJSONConfigObject()
    {
        return jsonObject;
    }
    
    /**
     * Extract configuration objects from the JSON object.
     *
     * @throws IOException              When specified files in the configuration file are not found <b>OR</b> cannot read the specified files.
     * @throws ConfigNotLoadedException When global config has not been loaded.
     */
    public static void parseConfiguration()
            throws IOException, ConfigNotLoadedException, NoSpecifiedPrivateKeyException, NoSpecifiedPublicKeyException
    {
        if (jsonObject != null)
        {
            JsonObject databaseJSONObject = jsonObject.getJsonObject("database");
            // Database server info
            databaseConfiguration = new Database(databaseJSONObject.getString("driver").trim(),
                                                 databaseJSONObject.getString("baseURL").trim(),
                                                 databaseJSONObject.getString("name").trim(),
                                                 databaseJSONObject.getString("additionalParameters").trim());
            
            // Database username and password
            databaseAccount = new Account(databaseJSONObject.getString("username").trim(),
                                          databaseJSONObject.getString("password").trim());
            
            // RSA keys
            JsonObject cryptoJSONObject  = jsonObject.getJsonObject("crypto");
            String     privateRSAKeyPath = cryptoJSONObject.getString("privateRSAKeyPath");
            String     publicRSAKeyPath  = cryptoJSONObject.getString("publicRSAKeyPath");
            
            FileReader    fileReader;
            StringBuilder stringBuilder = new StringBuilder();
            int           c;
            
            // Read private RSA key
            try
            {
                fileReader = new FileReader(privateRSAKeyPath);
                stringBuilder.setLength(0);
                while ((c = fileReader.read()) != -1)
                {
                    stringBuilder.append((char) c);
                }
                privateRSAKey = stringBuilder.toString();
            }
            catch (FileNotFoundException e)
            {
                /*
                    Note: this particular NoSpecifiedPrivateKeyException case could be treated as a warning and be printed to
                    the logger, but other cases may not be suppressed.
                 */
                throw new NoSpecifiedPrivateKeyException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PRIVATE_KEY), e);
            }
            
            // Read public RSA key
            try
            {
                fileReader = new FileReader(publicRSAKeyPath);
                stringBuilder.setLength(0);
                while ((c = fileReader.read()) != -1)
                {
                    stringBuilder.append((char) c);
                }
                publicRSAKey = stringBuilder.toString();
            }
            catch (FileNotFoundException e)
            {
                /*
                    Note: this particular NoSpecifiedPublicKeyException case could be treated as a warning and be printed to
                    the logger, but other cases may not be suppressed.
                 */
                throw new NoSpecifiedPublicKeyException(LanguageProvider.getCurrentLanguage().getField(
                        LanguageFieldHandle.E_UTIL_RSA_CIPHER_NO_PUBLIC_KEY), e);
            }
            
            // Parse OK
            isConfigParsed = true;
        }
        else
        {
            throw new ConfigNotLoadedException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_LOADED));
        }
    }
    
    /**
     * Getter of databaseConfiguration
     *
     * @return Database configuration
     *
     * @throws ConfigNotLoadedException When global config has not been loaded.
     * @throws ConfigNotParsedException When global config has not been parsed.
     * @see Database
     */
    public static Database getDatabaseConfiguration() throws ConfigNotLoadedException, ConfigNotParsedException
    {
        checkPrerequisites();
        return databaseConfiguration;
    }
    
    /**
     * Getter of databaseAccount
     *
     * @return Database account
     *
     * @throws ConfigNotLoadedException When global config has not been loaded.
     * @throws ConfigNotParsedException When global config has not been parsed.
     * @see Account
     */
    public static Account getDatabaseAccount() throws ConfigNotLoadedException, ConfigNotParsedException
    {
        checkPrerequisites();
        return databaseAccount;
    }
    
    /**
     * Getter of privateRSAKey
     *
     * @return Private RSA key
     *
     * @throws ConfigNotLoadedException When global config has not been loaded.
     * @throws ConfigNotParsedException When global config has not been parsed.
     */
    public static String getPrivateRSAKey() throws ConfigNotLoadedException, ConfigNotParsedException
    {
        checkPrerequisites();
        return privateRSAKey;
    }
    
    /**
     * Getter of publicRSAKey
     *
     * @return Public RSA key
     *
     * @throws ConfigNotLoadedException When global config has not been loaded.
     * @throws ConfigNotParsedException When global config has not been parsed.
     */
    public static String getPublicRSAKey() throws ConfigNotLoadedException, ConfigNotParsedException
    {
        checkPrerequisites();
        return publicRSAKey;
    }
    
    private static void checkPrerequisites() throws ConfigNotLoadedException, ConfigNotParsedException
    {
        if (jsonObject == null)
            throw new ConfigNotLoadedException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_LOADED));
        if (!isConfigParsed)
            throw new ConfigNotParsedException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_CONFIG_MANAGER_CONFIG_NOT_PARSED));
    }
}
