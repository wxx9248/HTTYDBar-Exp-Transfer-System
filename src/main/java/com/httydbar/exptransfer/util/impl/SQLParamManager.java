package com.httydbar.exptransfer.util.impl;

import com.httydbar.exptransfer.i18n.impl.LanguageFieldHandle;
import com.httydbar.exptransfer.i18n.impl.LanguageProvider;
import com.httydbar.exptransfer.util.exception.UnsupportedSQLTypeException;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that manages SQL parameters.
 *
 * @author wxx9248
 */
public class SQLParamManager
{
    private static final int INITIAL_CAPACITY = 10;
    
    private static final Map<Class<?>, Integer> TYPE_MAP = new HashMap<Class<?>, Integer>()
    {
        {
            put(Integer.class, Types.INTEGER);
            put(Long.class, Types.BIGINT);
            put(String.class, Types.VARCHAR);
            put(Date.class, Types.DATE);
            put(Timestamp.class, Types.TIMESTAMP);
            put(Double.class, Types.DOUBLE);
            put(Time.class, Types.TIME);
        }
    };
    
    private final List<SQLParam> paramList = new ArrayList<>(INITIAL_CAPACITY);
    
    
    /**
     * Add a non-null parameter to the SQL parameter list, with its SQL type automatically detected.
     *
     * @param param An object with a supported Java class type.
     */
    public void addParam(@NotNull Object param)
    {
        addParam(param, getSQLType(param.getClass()));
    }
    
    /**
     * Add a non-null parameter to the SQL parameter list, with a specified SQL type.
     *
     * @param param        An object.
     * @param paramSQLType A supported SQL type.
     */
    public void addParam(@NotNull Object param, int paramSQLType)
    {
        if (checkSQLType(paramSQLType))
        {
            addParamPrimitive(param, paramSQLType);
        }
        else
            throw new UnsupportedSQLTypeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_SQL_PARAM_MANAGER_UNSUPPORTED_SQL_DATA_TYPE));
    }
    
    /**
     * Add a null parameter to the SQL parameter list, with a specified SQL type.
     *
     * @param paramSQLType A supported SQL type.
     */
    public void addNullParam(int paramSQLType)
    {
        if (checkSQLType(paramSQLType))
        {
            addParamPrimitive(null, paramSQLType);
        }
        else
            throw new UnsupportedSQLTypeException(LanguageProvider.getCurrentLanguage().getField(
                    LanguageFieldHandle.E_UTIL_SQL_PARAM_MANAGER_UNSUPPORTED_SQL_DATA_TYPE));
    }
    
    /**
     * Add a null parameter to the SQL parameter list, with a specified Java class type.
     *
     * @param classType A supported Java class type.
     */
    public void addNullParam(@NotNull Class<?> classType)
    {
        addParamPrimitive(null, getSQLType(classType));
    }
    
    /**
     * Remove an object from the parameter list by its index.
     *
     * @param index The index of the targeted object.
     */
    public void removeParam(int index)
    {
        paramList.remove(index);
    }
    
    /**
     * Clear all parameters in the parameter list.
     */
    public void clearParam()
    {
        paramList.clear();
    }
    
    /**
     * Populate a prepared SQL statement with the parameter list.
     *
     * @param preparedStatement A prepared SQL statement.
     *
     * @throws SQLException When failed to populate the SQL statement.
     */
    public PreparedStatement populatePreparedStatement(PreparedStatement preparedStatement) throws SQLException
    {
        int i = 1;
        for (SQLParam param : paramList)
        {
            preparedStatement.setObject(i++, param.getParamValue(), param.getParamSQLType());
        }
        
        return preparedStatement;
    }
    
    private void addParamPrimitive(Object param, int paramSQLType)
    {
        paramList.add(new SQLParam(param, paramSQLType));
    }
    
    private boolean checkSQLType(int paramSQLType)
    {
        return TYPE_MAP.containsValue(paramSQLType);
    }
    
    private int getSQLType(Class<?> classType)
    {
        return TYPE_MAP.get(classType);
    }
    
    
    /**
     * Class that describes a SQL parameter.
     *
     * @author wxx9248
     */
    private static class SQLParam
    {
        private Object paramValue;
        private int    paramSQLType;
        
        /**
         * Constructor of the DBParam class.
         *
         * @param paramValue   The value of the SQL parameter.
         * @param paramSQLType The SQL type of the SQL parameter.
         */
        public SQLParam(Object paramValue, int paramSQLType)
        {
            this.paramValue   = paramValue;
            this.paramSQLType = paramSQLType;
        }
        
        public Object getParamValue()
        {
            return paramValue;
        }
        
        public void setParamValue(Object paramValue)
        {
            this.paramValue = paramValue;
        }
        
        public int getParamSQLType()
        {
            return paramSQLType;
        }
        
        public void setParamSQLType(int paramSQLType)
        {
            this.paramSQLType = paramSQLType;
        }
    }
}
