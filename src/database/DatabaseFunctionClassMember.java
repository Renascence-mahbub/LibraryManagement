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
public class DatabaseFunctionClassMember extends DatabaseConnectionClass {
    //demo query

    public static ResultSet select() throws SQLException {
        String sql = "SELECT * FROM `Member` ORDER BY member_id";
        return con.prepareStatement(sql).executeQuery();
    }

    public static void insert(String name, String address, String member_type,
            String member_date, String expire_date) throws SQLException {
        String sql = "INSERT INTO `Member` "
                + "(name, address, member_type, member_date, expire_date) "
                + "VALUES ('" + name + "' , '"
                + address + "' , '"
                + member_type + "' , '"
                + member_date + "' , '"
                + expire_date + "')";
        con.prepareStatement(sql).execute();
    }

    public static void delete(int member_id) throws SQLException {
        String sql = "DELETE FROM `Member` WHERE member_id='" + member_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static void update(String name, String address, String member_type,
            String member_date, String expire_date, int member_id) throws SQLException {
        String sql = "UPDATE `Member` SET name='" + name + "' , "
                + "address='" + address + "' , "
                + "member_type='" + member_type + "' , "
                + "member_date='" + member_date + "' , "
                + "expire_date='" + expire_date + "' WHERE member_id='" + member_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static int getMemberId(String name) throws SQLException {
        String sql = "SELECT member_id FROM `Member` WHERE name='" + name + "'";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
}
