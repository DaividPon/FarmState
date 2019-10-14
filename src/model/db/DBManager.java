package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBへのアクセスを管理するクラス
 * @author daividkdm
 *
 */
public class DBManager {

    private static final String url = "jdbc:postgresql://localhost:5432/dev_db";
    private static final String user = "devusr";
    private static final String password = "kaihatu";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
