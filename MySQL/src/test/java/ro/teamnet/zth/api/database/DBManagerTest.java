package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Florin on 30.04.2015.
 */

public class  DBManagerTest {
    @Test
    public void TestGetConection(){
        Connection con1= DBManager.getConnection();
        assertNotNull(con1);
    }
}
