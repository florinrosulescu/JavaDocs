package ro.teamnet.zth.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Florin on 30.04.2015.
 */
public class DBManager {
    private DBManager() {
        throw new UnsupportedOperationException();
    }
    public static String CONNECTION_STRING= "jdbc:mysql://" + DBProperties.IP + "/" + DBProperties.SCHEMA;
    private static void registerDriver(){
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        registerDriver();
        Connection con= null;
        try {
            con = DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

}
