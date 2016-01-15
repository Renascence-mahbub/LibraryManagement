/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.DatabaseConnectionClass.con;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author keno
 */
public class DatabaseFunctionClassPublish extends DatabaseConnectionClass {
    //demo query

    public static ResultSet getPublishName() throws SQLException {
        String sql = "SELECT name FROM publisher ORDER BY pub_id";
        return con.prepareStatement(sql).executeQuery();
    }
    
    public static ResultSet select() throws SQLException {
        String sql = "SELECT * FROM publisher ORDER BY pub_id";
        return con.prepareStatement(sql).executeQuery();
    }

    public static void insert(String name, String address) throws SQLException {
        String sql = "INSERT INTO `publisher` "
                + "(name, address) "
                + "VALUES ('" + name + "' , '" + address + "')";
        con.prepareStatement(sql).execute();
    }

    public static void delete(int pub_id) throws SQLException {
        String sql = "DELETE FROM `publisher` WHERE pub_id='" + pub_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static void update(String name, String address, int pub_id) throws SQLException {
        String sql = "UPDATE `publisher` SET name='" + name + "' , address='" + address + "' WHERE pub_id='" + pub_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static int getPublishId(String name) throws SQLException {
        String sql = "SELECT pub_id FROM publisher WHERE name='" + name + "'";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
}
