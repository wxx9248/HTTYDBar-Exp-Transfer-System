package com.httydbar.exptransfer.util;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * Class that manages global config
 * <p>
 * Usage:
 * 1. loadJSONConfig
 * 2. parseConfiguration
 */
public class ConfigManager
{
    private static JsonObject jsonObject;
    
    private static Database databaseConfiguration;
    private static Account  databaseAccount;
    
    private ConfigManager() {}
    
    public static void loadJSONConfig(Reader reader)
    {
        JsonReader jsonReader = Json.createReader(reader);
        jsonObject = jsonReader.readObject();
        jsonReader.close();
    }
    
    public static void loadJSONConfigFromFile(String filePath) throws FileNotFoundException
    {
        loadJSONConfig(new FileReader(filePath));
    }
    
    public static void loadJSONConfigFromString(String config)
    {
        loadJSONConfig(new StringReader(config));
    }
    
    public static JsonObject getJSONConfigObject()
    {
        return jsonObject;
    }
    
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
    
    public static Database getDatabaseConfiguration()
    {
        return databaseConfiguration;
    }
    
    public static Account getDatabaseAccount()
    {
        return databaseAccount;
    }
}
