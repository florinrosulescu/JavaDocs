package ro.teamnet.zth.api.database;

/**
 * Created by Florin on 30.04.2015.
 */
public interface DBProperties {
    String IP = "127.0.0.1";
    String PORT = "3306";
    String SCHEMA = "ZTH_03";
    String USER = "root";
    String PASS = "";
    String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    boolean IS_ORACLE = false;
    boolean IS_MYSQL = true;


}
