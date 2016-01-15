/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Borrow;

import Default.StaticAccess;
import Default.UsableDefaultLoadTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author keno
 */
public class BorrowedPanel extends javax.swing.JPanel {

    /**
     * Creates new form BoowedPanel
     */
    public BorrowedPanel() {
        initComponents();
        load();
    }

    void load() {
        try {
            ResultSet rs = database.DatabaseFunctionClassBorrow.select();
            TableModel tb = DbUtils.resultSetToTableModel(rs);
            new UsableDefaultLoadTable(tb, table);
            setEnable(false);
        } catch (SQLException ex) {
            StaticAccess.showMassageDialog(this, "Can't select.", ex);
        }
    }

    void setEnable(boolean flag) {
        editBTN.setEnabled(flag);
        deleteBTN.setEnabled(flag);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        deleteBTN = new javax.swing.JButton();
        editBTN = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        deleteBTN.setText("DELETE");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        editBTN.setText("UPDATE STATUS");
        editBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(editBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBTN)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 200, 0));
        jButton1.setText("RELOAD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            setEnable(true);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            try {
                String title = table.getValueAt(row, 0).toString();
                int book_id = database.DatabaseFunctionClassBooks.getBookId(title);
                String borrowed_member = table.getValueAt(row, 1).toString();
                int member_id = database.DatabaseFunctionClassMember.getMemberId(borrowed_member);
                int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this borrowed info.",
                        "Delete!!", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    database.DatabaseFunctionClassBorrow.delete(book_id, member_id);
                    load();

                }
            } catch (SQLException ex) {
                StaticAccess.showMassageDialog(this, "Can't delete from Database", ex);
            }
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void editBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTNActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            try {
                String title = table.getValueAt(row, 0).toString();
                int book_id = database.DatabaseFunctionClassBooks.getBookId(title);
                String borrowed_member = table.getValueAt(row, 1).toString();
                int member_id = database.DatabaseFunctionClassMember.getMemberId(borrowed_member);
                System.out.println(book_id + "," + member_id);
                int option = JOptionPane.showConfirmDialog(this, "Do you want to confirm this book has return.",
                        "Return!!", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    database.DatabaseFunctionClassBorrow.update("RETURNED", book_id, member_id);
                    load();
                }
            } catch (SQLException ex) {
                StaticAccess.showMassageDialog(this, "can't change status from Database", ex);
            }
        }
    }//GEN-LAST:event_editBTNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBTN;
    private javax.swing.JButton editBTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
