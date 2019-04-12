package pl.golabm.repository;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class AbstractDAO {

    private static final String DB_URL = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private String url;
    private String user;
    private String password;

    public void init() {

        try
        {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("configuration.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty(DB_URL);
            user = properties.getProperty(DB_USER);
            password = properties.getProperty(DB_PASSWORD);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Statement getStatement() throws ClassNotFoundException, SQLException {

        init();

        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection.createStatement();
    }
}
