/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import Default.StaticAccess;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author keno
 */
public class LibraryManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        setLookAndFeel();
        new database.DatabaseConnectionClass();
        StaticAccess.mainFrame=new HomePage();
        StaticAccess.mainFrame.setVisible(true);
    }
    
    static void setLookAndFeel(){
         try {
            Properties props = new Properties();
            props.put("logoString", "");
            props.put("windowDecoration", "off");
            props.put("menuOpaque", "off");
            /*
            http://www.jtattoo.net/ThemeProps.html
             */
            com.jtattoo.plaf.smart.SmartLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException un) {
            try {

                javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
                for (UIManager.LookAndFeelInfo installedLookAndFeel : installedLookAndFeels) {
                    if ("Windows".equals(installedLookAndFeel.getName())) {
                        javax.swing.UIManager.setLookAndFeel(installedLookAndFeel.getClassName());
                        break;
                    }
                }

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException x) {
                try {
                    javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
                    if (installedLookAndFeels.length >= 1) {
                        javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[0].getClassName());
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException y) {

                }
            }
        } 
    }
}
