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
public class DatabaseFunctionClassAuthor extends DatabaseConnectionClass {
    //demo query

    public static ResultSet getAuthorName() throws SQLException {
        String sql = "SELECT name FROM `Author` ORDER BY author_id";
        return con.prepareStatement(sql).executeQuery();
    }
    
    public static ResultSet select() throws SQLException {
        String sql = "SELECT * FROM `Author` ORDER BY author_id";
        return con.prepareStatement(sql).executeQuery();
    }

    public static void insert(String name, String religion) throws SQLException {
        String sql = "INSERT INTO `Author` "
                + "(name, religion) "
                + "VALUES ('" + name + "' , '" + religion + "')";
        con.prepareStatement(sql).execute();
    }

    public static void delete(int author_id) throws SQLException {
        String sql = "DELETE FROM `Author` WHERE author_id='" + author_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static void update(String name, String religion, int author_id) throws SQLException {
        String sql = "UPDATE `Author` SET name='" + name + "' , religion='" + religion + "' WHERE author_id='" + author_id + "'";
        con.prepareStatement(sql).execute();
    }
    
    public static int getAuthorId(String name) throws SQLException {
        String sql = "SELECT author_id FROM `Author` WHERE name='" + name + "'";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
}
