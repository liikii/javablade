package company;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Dbp {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private volatile static short pool_flag = 0;

    private GenericObjectPool<PoolableConnection> connectionPool = null;

    public DataSource setUp() {
        // Creates a connection factory object which will be use by
        // the pool to create the connection object. We passes the
        // JDBC url info, username and password.
        ConnectionFactory cf = new DriverManagerConnectionFactory(
                Dbp.URL,
                Dbp.USERNAME,
                Dbp.PASSWORD);

        // Creates a PoolableConnectionFactory that will wraps the
        // connection object created by the ConnectionFactory to add
        // object pooling functionality.
        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, null);
        pcf.setValidationQuery("SELECT 1");

        // Creates an instance of GenericObjectPool that holds our
        // pool of connections object.
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        connectionPool = new GenericObjectPool<>(pcf);
        pcf.setPool(connectionPool);
        return new PoolingDataSource<>(connectionPool);
    }

    private GenericObjectPool getConnectionPool() {
        return connectionPool;
    }

    public static void main(String[] args) throws Exception {
        Dbp demo = new Dbp();
        DataSource dataSource = demo.setUp();
        demo.printStatus();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from jkb_user")) {
            demo.printStatus();

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("user_name"));
            }
        }
        demo.printStatus();
    }

    /**
     * Prints connection pool status.
     */
    private void printStatus() {
        System.out.println("Max   : " + getConnectionPool().getNumActive() + "; " +
                "Active: " + getConnectionPool().getNumActive() + "; " +
                "Idle  : " + getConnectionPool().getNumIdle());
    }
}
