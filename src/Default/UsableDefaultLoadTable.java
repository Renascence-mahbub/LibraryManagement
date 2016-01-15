/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author MADANI
 */
public final class UsableDefaultLoadTable {

    public UsableDefaultLoadTable(final TableModel tb, final JTable table) {
        StaticAccess.clearTable(table);
        DefaultTableModel dtm = (DefaultTableModel) tb;
        Vector cNames = new Vector();
        final Vector bool=new Vector();
        for (int i = 0; i < dtm.getColumnCount(); i++) {
            cNames.add(dtm.getColumnName(i));
            boolean edit=false;
            bool.add(edit);
        }
        dtm = new DefaultTableModel(dtm.getDataVector(), cNames) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return (boolean) bool.get(columnIndex);
            }

        };
        table.setModel(dtm);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        update(table);
        getAutoResizeTable(table);
        
        /* Action action = new AbstractAction() {
         public void actionPerformed(ActionEvent e) {
         TableCellListener tcl = (TableCellListener) e.getSource();
         System.out.println("Row   : " + tcl.getRow());
         System.out.println("Column: " + tcl.getColumn());
         System.out.println("Old   : " + tcl.getOldValue());
         System.out.println("New   : " + tcl.getNewValue());
         }
         };

         TableCellListener tcl = new TableCellListener(table, action); */
    }

    void getAutoResizeTable(final JTable table) {

        table.getColumnModel().addColumnModelListener(new TableColumnModelListener() {
            @Override
            public void columnSelectionChanged(ListSelectionEvent lse) {
            }

            @Override
            public void columnAdded(TableColumnModelEvent tcme) {
            }

            @Override
            public void columnRemoved(TableColumnModelEvent tcme) {
            }

            @Override
            public void columnMoved(TableColumnModelEvent tcme) {
            }

            @Override
            public void columnMarginChanged(ChangeEvent ce) {
                TableColumn resizingColumn = table.getTableHeader().getResizingColumn();
                if (resizingColumn != null) {
                    resizingColumn.setPreferredWidth(resizingColumn.getWidth());
                }
                if (hasExcessWidth(table)) {
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                } else {
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                }

            }

            protected boolean hasExcessWidth(JTable table) {
                return table.getPreferredSize().width < table.getParent().getWidth();
            }

        });

    }

    private void update(JTable table) {
        adjustJTableRowSizes(table);
        for (int i = 0; i < table.getColumnCount(); i++) {
            adjustColumnSizes(table, i, 2);
        }
    }

    private void adjustJTableRowSizes(JTable jTable) {
        for (int row = 0; row < jTable.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = jTable.getCellRenderer(row, column);
                Object valueAt = jTable.getValueAt(row, column);
                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(jTable, valueAt, false, false, row, column);
                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
                maxHeight = Math.max(heightPreferable, maxHeight);
            }
            jTable.setRowHeight(row, maxHeight);
        }

    }

    public void adjustColumnSizes(JTable table, int column, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(column);
        int width;

        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;

        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, column);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, column), false, false, r, column);
            int currentWidth = comp.getPreferredSize().width;
            width = Math.max(width, currentWidth);
        }

        width += 2 * margin;

        col.setPreferredWidth(width);
        col.setWidth(width);
    }

    class TableCellListener implements PropertyChangeListener, Runnable {

        private JTable table;
        private Action action;

        private int row;
        private int column;
        private Object oldValue;
        private Object newValue;

        public TableCellListener(JTable table, Action action) {
            this.table = table;
            this.action = action;
            this.table.addPropertyChangeListener(this);
        }

        private TableCellListener(JTable table, int row, int column, Object oldValue, Object newValue) {
            this.table = table;
            this.row = row;
            this.column = column;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        public int getColumn() {
            return column;
        }

        public Object getNewValue() {
            return newValue;
        }

        public Object getOldValue() {
            return oldValue;
        }

        public int getRow() {
            return row;
        }

        public JTable getTable() {
            return table;
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            //  A cell has started/stopped editing

            if ("tableCellEditor".equals(e.getPropertyName())) {
                if (table.isEditing()) {
                    processEditingStarted();
                } else {
                    processEditingStopped();
                }
            }
        }

        private void processEditingStarted() {
            SwingUtilities.invokeLater(this);
        }

        @Override
        public void run() {
            row = table.convertRowIndexToModel(table.getEditingRow());
            column = table.convertColumnIndexToModel(table.getEditingColumn());
            oldValue = table.getModel().getValueAt(row, column);
            newValue = null;
        }

        private void processEditingStopped() {
            newValue = table.getModel().getValueAt(row, column);

            if (!newValue.equals(oldValue)) {
                TableCellListener tcl = new TableCellListener(
                        getTable(), getRow(), getColumn(), getOldValue(), getNewValue());

                ActionEvent event = new ActionEvent(
                        tcl,
                        ActionEvent.ACTION_PERFORMED,
                        "");
                action.actionPerformed(event);
            }
        }
    }
}
