package net.objectof.connector.sql;


import java.util.Map;

import javax.sql.DataSource;

import net.objectof.connector.ConnectorException;
import net.objectof.connector.Parameter.Hint;
import net.objectof.repo.impl.sql.ISql;


public class IJDBCConnector extends AbstractSQLConnector {

    public static final String KEY_DRIVER = "Driver";
    public static final String KEY_URL = "URL";
    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PASSWORD = "Password";

    public IJDBCConnector(Map<String, String> values) {
        this();
        setParameters(values);
    }

    public IJDBCConnector() {
        super();
        addParameter(KEY_DRIVER);
        addParameter(KEY_URL);
        addParameter(KEY_USERNAME);
        addParameter(KEY_PASSWORD, Hint.PASSWORD);
    }

    @Override
    public String getType() {
        return "Generic JDBC";
    }

    @Override
    protected DataSource getDataSource() throws ConnectorException {
        return ISql.createPool(value(KEY_URL), value(KEY_USERNAME), value(KEY_PASSWORD), value(KEY_DRIVER));
    }

    protected boolean isDatabaseCreatable() {
        return false;
    }
}
