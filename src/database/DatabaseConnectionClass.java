/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author keno
 */
public class DatabaseConnectionClass {
    public static Connection con;

    public static String ip = "localhost";
    public static String port = "3306";
    public static String database = "library";
    public static String user = "root";
    public static String pass = "";
    public DatabaseConnectionClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database, user, pass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error to connect to internate/ wrong database connection. Try again later.",
                    "connection problem!!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } 
        
    }
}
