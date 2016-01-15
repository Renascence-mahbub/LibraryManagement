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
public class DatabaseFunctionClassBorrow extends DatabaseConnectionClass {
    //demo query

    public static ResultSet select() throws SQLException {
        String sql = "SELECT title, name AS borrowed_member, issue_date, return_date, status "
                + "FROM `Borrowed_by`, `Member`, `Books` WHERE "
                + "Borrowed_by.book_id=Books.book_id AND "
                + "Borrowed_by.member_id=Member.member_id ORDER BY issue_date DESC";
        return con.prepareStatement(sql).executeQuery();
    }

    public static void insert(String issue_date, String return_date, int book_id, int member_id) throws SQLException {
        String sql = "INSERT INTO `Borrowed_by` "
                + "(issue_date, return_date, book_id, member_id) "
                + "VALUES ('" + issue_date + "' , '"
                + return_date + "' , '"
                + book_id + "' , '"
                + member_id + "')";
        con.prepareStatement(sql).execute();
    }

    public static void delete(int book_id, int member_id) throws SQLException {
        String sql = "DELETE FROM `Borrowed_by` WHERE book_id='" + book_id + "' AND member_id='" + member_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static void update(String status, int book_id, int member_id) throws SQLException {
        String sql = "UPDATE `Borrowed_by` SET status='" + status + "' WHERE book_id='" + book_id + "' AND member_id='" + member_id + "'";
        con.prepareStatement(sql).execute();
    }
}
