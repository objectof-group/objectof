package net.objectof.connector.impl;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import net.objectof.connector.AbstractConnector;
import net.objectof.connector.ConnectorException;
import net.objectof.connector.Connector.Initialize;
import net.objectof.connector.parameter.Parameter.Type;
import net.objectof.model.Package;
import net.objectof.model.impl.IBaseMetamodel;
import net.objectof.model.impl.IPackage;
import net.objectof.model.impl.facets.ISourcePackage;
import net.objectof.repo.impl.sql.ISqlDb;
import net.objectof.repo.impl.sqlite.ISQLite;

import org.w3c.dom.Document;


public class ISQLiteConnector extends AbstractConnector {

    private static final String KEY_FILENAME = "Filename";

    public ISQLiteConnector(Map<String, String> values) {
        this();
        setParameters(values);
    }

    public ISQLiteConnector() {
        super();
        addParameter(Type.FILE, KEY_FILENAME);
    }


    @Override
    public Package createPackage(Document schema, Initialize initialize) throws ConnectorException {
        IPackage schemaPackage = new ISourcePackage(IBaseMetamodel.INSTANCE, schema);
        if (initialize == Initialize.WHEN_EMPTY && isDatabaseEmpty()) {
        	initializeDatabase();
        }
        return getISqlDb().createPackage(getPackageName(), ISQLite.class.getName(), schemaPackage);
    }


	@Override
	protected DataSource getDataSource() throws ConnectorException {
    	File file = new File(value(KEY_FILENAME));
        DataSource ds;
		try {
			ds = ISQLite.createPool(file);
		} catch (IOException | SQLException e) {
			throw new ConnectorException(e);
		}
        return ds;
	}
    

    @Override
    public String getType() {
        return "SQLite";
    }


}