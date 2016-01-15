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
public class DatabaseFunctionClassBooks extends DatabaseConnectionClass {
    //demo query

    
    public static ResultSet getBooksTitle() throws SQLException {
        String sql = "SELECT title FROM `Books` ORDER BY book_id";
        return con.prepareStatement(sql).executeQuery();
    }
    
    public static ResultSet select() throws SQLException {
        String sql = "SELECT book_id, title, price, available, publisher.name AS publisher_name, Author.name AS author_name FROM `Books`, `publisher`, `Author`"
                + " WHERE Books.pub_id=publisher.pub_id AND Books.author_id=Author.author_id ORDER BY book_id";
        return con.prepareStatement(sql).executeQuery();
    }

    public static void insert(String title, double price, int available, int pub_id, int author_id) throws SQLException {
        String sql = "INSERT INTO `Books` "
                + "(title, price, available, pub_id, author_id) "
                + "VALUES ('" + title + "' , "
                + "'" + price + "', "
                + "'" + available + "', "
                + "'" + pub_id + "', "
                + "'" + author_id + "')";
        con.prepareStatement(sql).execute();
    }

    public static void delete(int book_id) throws SQLException {
        String sql = "DELETE FROM `Books` WHERE book_id='" + book_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static void update(String title, double price, int available, int pub_id, int author_id, int book_id) throws SQLException {
        String sql = "UPDATE `Books` SET title='" +title + "' , "
                + "price='" + price + "' , "
                + "available='" + available + "' , "
                + "pub_id='" + pub_id + "' , "
                + "author_id='" + author_id + "' WHERE book_id='" + book_id + "'";
        con.prepareStatement(sql).execute();
    }

    public static int getBookId(String title) throws SQLException {
        String sql = "SELECT book_id FROM `Books` WHERE title='" + title + "'";
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
}
