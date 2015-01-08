package tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import net.objectof.connector.ConnectorException;
import net.objectof.connector.SQLiteConnector;
import net.objectof.model.Package;


public class TestingRepo {

    public static Package testPackage() throws URISyntaxException, IOException, ConnectorException {
        return forSchema(TEST_SCHEMA);
    }

    public static String TEST_SCHEMA = "/packages/test.xml";

    public static Package forSchema(String relativeFilename) throws URISyntaxException, IOException, ConnectorException {
        URL schemaURL = TestingRepo.class.getResource(relativeFilename);
        File schemaFile = new File(schemaURL.toURI());
        return forSchema(schemaFile);
    }

    public static Package forSchema(File schemaFile) throws IOException, ConnectorException {
        File dbFile = File.createTempFile("testdb", "");
        dbFile.delete();
        SQLiteConnector conn = new SQLiteConnector();
        conn.getParameter("Filename").setValue(dbFile.toString());
        conn.getParameter("Version").setValue("1");
        conn.getParameter("Repository").setValue("testrepo");
        dbFile.deleteOnExit();
        return conn.createPackage(new FileInputStream(schemaFile));
    }
}