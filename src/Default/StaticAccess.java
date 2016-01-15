/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ashraf
 */
public class StaticAccess {

    public static JFrame mainFrame;
    public static JTabbedPane mainTabPane;
    public static JSplitPane mainSplitPane;
    public static Vector treeItems = new Vector();
    public static String user_id = "";

    //window, JFrame, JDialog
    public static void closeWindow(Window window) {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        try {
            if (database.DatabaseConnectionClass.con.isClosed() == false) {
                database.DatabaseConnectionClass.con.close();
            }
        } catch (SQLException ex) {
        }
    }

    public static void set_background(Container container, Color color) {
        for (int i = 0; i < container.getComponentCount(); i++) {
            container.getComponent(i).setBackground(color);
        }
    }

    public static void set_focusable(Container container, boolean flag) {
        for (int i = 0; i < container.getComponentCount(); i++) {
            container.getComponent(i).setFocusable(flag);
        }
    }

    //JOptionPane
    public static void showMassageDialog(Component comp, String reason, Exception ex) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        JOptionPane.showMessageDialog(comp, "Reason of Error: " + reason + "\nOccurence At: " + element.getClassName() + "/" + element.getMethodName() + ":" + element.getLineNumber()
                + "\nGenerate MSG: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    //JcomboxRelated
    public static Object makeObj(final String item) {
        return new Object() {
            public String toString() {
                return item;
            }
        };
    }

    public static String getItem(JComboBox comboBox) {
        String item;
        if (comboBox.isEditable()) {
            item = comboBox.getEditor().getItem().toString().trim().toUpperCase();
        } else {
            try {
                item = comboBox.getSelectedItem().toString();
            } catch (NullPointerException ne) {
                item = null;
            }
        }
        if (item == null) {
            item = "";
        }
        return item;
    }

    public static void clearComboBox(JComboBox comboBox) {
        if (comboBox.isEditable()) {
            JTextField comboBoxTF = (JTextField) comboBox.getEditor().getEditorComponent();
            comboBoxTF.setText("");
        } else {
            comboBox.removeAllItems();
        }
    }

    public static void setSelectedItem(JComboBox comboBox, String value) {
        if (comboBox.isEditable()) {
            JTextField comboBoxTF = (JTextField) comboBox.getEditor().getEditorComponent();
            comboBoxTF.setText(value);
        } else {
            Object item;
            for (int i = 0; i < comboBox.getItemCount(); i++) {
                item = comboBox.getItemAt(i);
                if (item.toString().equals(value)) {
                    comboBox.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    public static int getItemLocation(JComboBox comboBox, String value) {
        Object item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = comboBox.getItemAt(i);
            if (item.toString().equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static void removeItem(JComboBox comboBox, String value) {
        int location = getItemLocation(comboBox, value);
        if (location != -1) {
            comboBox.removeItemAt(location);
        }
    }

    //JPanel
    public static void enableComponent(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponent((Container) component, enable);
            }
        }
    }

    public static BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    //JTable
    public static double getTotalFromTBL(int column, JTable table) {
        double total = 0;
        try {
            for (int row = 0; row < table.getRowCount(); row++) {
                total = total + Double.parseDouble(table.getValueAt(row, column).toString());
            }
        } catch (NullPointerException ex) {
            return total;
        }
        return total;
    }

    public static Vector getListItemFromColumn(int column, JTable table) {
        Vector v = new Vector();
        for (int row = 0; row < table.getRowCount(); row++) {
            v.add(table.getValueAt(row, column).toString());
        }
        return v;
    }

    public static void clearTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    //parsing 
    public static double makePerfectDouble(String value) {
        return doubleFormatPlain(Double.parseDouble(value));
    }

    public static double makePerfectDouble(double value) {
        return doubleFormatPlain(value);
    }

    public static String doubleFormatString(double value) {
        return new DecimalFormat("##.##").format(value);
    }

    public static double doubleFormatPlain(double value) {
        String value2 = new DecimalFormat("##.##").format(value);
        return Double.parseDouble(value2);
    }

    //date
    public static String getCurrentJavaDateToSQLdate(Calendar cal) {
        return String.format("%d-%02d-%02d", cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 1), cal.get(Calendar.DAY_OF_MONTH));
    }

    public static String getASQLdateFromGivenJavaDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        return getCurrentJavaDateToSQLdate(cal);
    }

    public static String getDate(JComboBox dayCBX, JComboBox monthCBX, JComboBox yearCBX) {
        return StaticAccess.getASQLdateFromGivenJavaDate(Integer.parseInt(dayCBX.getSelectedItem().toString()),
                Integer.parseInt(StaticAccess.getMonth(monthCBX.getSelectedItem().toString())) - 1,
                Integer.parseInt(yearCBX.getSelectedItem().toString()));
    }

    public static String getMonth(String mon) {
        String m = "";
        if (mon.contains("Jan")) {
            m = "1";
        } else if (mon.contains("Feb")) {
            m = "2";
        } else if (mon.contains("Mar")) {
            m = "3";
        } else if (mon.contains("Apr")) {
            m = "4";
        } else if (mon.contains("May")) {
            m = "5";
        } else if (mon.contains("Jun")) {
            m = "6";
        } else if (mon.contains("Jul")) {
            m = "7";
        } else if (mon.contains("Aug")) {
            m = "8";
        } else if (mon.contains("Sep")) {
            m = "9";
        } else if (mon.contains("Oct")) {
            m = "10";
        } else if (mon.contains("Nov")) {
            m = "11";
        } else if (mon.contains("Dec")) {
            m = "12";
        }
        return m;
    }
}
