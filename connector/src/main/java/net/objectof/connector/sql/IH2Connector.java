package net.objectof.connector.sql;


import java.io.File;
import java.util.Map;

import javax.sql.DataSource;

import net.objectof.connector.ConnectorException;
import net.objectof.connector.Parameter.Hint;
import net.objectof.repo.impl.sql.ISql;


public class IH2Connector extends AbstractSQLConnector {

    public static final String KEY_DIRECTORY = "Directory";

    public IH2Connector(Map<String, String> values) {
        this();
        setParameters(values);
    }

    public IH2Connector() {
        super();
        addParameter(KEY_DIRECTORY, Hint.DIRECTORY);
    }

    @Override
    public String getType() {
        return "H2";
    }

    @Override
    protected DataSource getDataSource() throws ConnectorException {
        String prefixPath = value(KEY_DIRECTORY) + "/" + "Database";
        String serverString = "jdbc:h2:" + prefixPath + ";AUTO_SERVER=TRUE";
        return ISql.createPool(serverString, null, null, "org.h2.Driver");
    }

    @Override
    protected boolean isDatabaseCreatable() {
        File dbfile = new File(value(KEY_DIRECTORY) + "/Database.mv.db");
        return !dbfile.exists();
    }
}
