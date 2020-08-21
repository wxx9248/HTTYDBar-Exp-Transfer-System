package com.httydbar.exptransfer.util;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * Class that manages global config using JSON.
 * <p>
 * Use as the list below indicated:
 * 1. loadJSONConfig
 * 2. parseConfiguration
 * 3. Use getters to access
 * Otherwise, there will be a NullPointerException waiting for you.
 *
 * @author wxx9248
 */
public class ConfigManager
{
    private static JsonObject jsonObject;
    
    // Object that stored configuration information, may be needed by other classes.
    private static Database databaseConfiguration;
    private static Account  databaseAccount;
    
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
     */
    public static void parseConfiguration()
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
    }
    
    /**
     * Getter of databaseConfiguration
     *
     * @return Database configuration
     *
     * @see Database
     */
    public static Database getDatabaseConfiguration()
    {
        return databaseConfiguration;
    }
    
    /**
     * Getter of databaseAccount
     *
     * @return Database account
     *
     * @see Account
     */
    public static Account getDatabaseAccount()
    {
        return databaseAccount;
    }
}
