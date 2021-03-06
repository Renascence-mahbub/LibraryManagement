/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

import Publisher.PublishEditDialog;
import Default.StaticAccess;
import Default.UsableDefaultLoadTable;
import Default.UsableSetDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author keno
 */
public class MemberPanel extends javax.swing.JPanel {

    /**
     * Creates new form PublisherPanel
     */
    public MemberPanel() {
        initComponents();
        setDate();
        load();
        typeTF.setText(typeCBX.getSelectedItem().toString());
    }

    void clear() {
        nameTF.setText("");
        addressTA.setText("");
        typeCBX.setSelectedIndex(0);
        setDate();
    }

    void load() {
        try {
            ResultSet rs = database.DatabaseFunctionClassMember.select();
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
        borrowBTN.setEnabled(flag);
    }

    void setDate() {
        new UsableSetDate(memberDayCBX, memberMonthCBX, memberYearCBX);
        new UsableSetDate(expireDayCBX, expireMonthCBX, expireYearCBX, "2030-01-01");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dispalyPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        addressTA = new javax.swing.JTextArea();
        insertBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        deleteBTN = new javax.swing.JButton();
        editBTN = new javax.swing.JButton();
        borrowBTN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        typeCBX = new javax.swing.JComboBox();
        typeTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        memberDayCBX = new javax.swing.JComboBox();
        memberMonthCBX = new javax.swing.JComboBox();
        memberYearCBX = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        expireDayCBX = new javax.swing.JComboBox();
        expireMonthCBX = new javax.swing.JComboBox();
        expireYearCBX = new javax.swing.JComboBox();

        jLabel1.setText("Name:");

        jLabel2.setText("Address:");

        addressTA.setColumns(20);
        addressTA.setLineWrap(true);
        addressTA.setRows(5);
        addressTA.setWrapStyleWord(true);
        jScrollPane3.setViewportView(addressTA);

        insertBTN.setBackground(new java.awt.Color(153, 0, 0));
        insertBTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        insertBTN.setForeground(new java.awt.Color(204, 204, 204));
        insertBTN.setText("INSERT INFO");
        insertBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBTNActionPerformed(evt);
            }
        });

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

        editBTN.setText("EDIT");
        editBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTNActionPerformed(evt);
            }
        });

        borrowBTN.setText("BORROW");
        borrowBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(editBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowBTN)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jLabel3.setText("Member Type:");

        typeCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NORMAL", "SILVER", "PLATINUM", "GOLD", "DIAMOND", "VIP", "OTHER" }));
        typeCBX.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeCBXItemStateChanged(evt);
            }
        });

        typeTF.setEditable(false);

        jLabel4.setText("Member_date:");

        memberDayCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        memberMonthCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        memberYearCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1970" }));

        jLabel5.setText("Expire_date:");

        expireDayCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        expireMonthCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        expireYearCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1970" }));

        javax.swing.GroupLayout dispalyPanelLayout = new javax.swing.GroupLayout(dispalyPanel);
        dispalyPanel.setLayout(dispalyPanelLayout);
        dispalyPanelLayout.setHorizontalGroup(
            dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispalyPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(dispalyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(insertBTN)
                            .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dispalyPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(dispalyPanelLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(typeCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(typeTF)))
                    .addGroup(dispalyPanelLayout.createSequentialGroup()
                        .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dispalyPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(memberDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memberMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memberYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dispalyPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(expireDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expireMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expireYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dispalyPanelLayout.setVerticalGroup(
            dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispalyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(typeCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(memberDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(expireDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expireMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expireYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dispalyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dispalyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void insertBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBTNActionPerformed
        // TODO add your handling code here:
        String name = nameTF.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sorry name can't be empty", "Name Empty!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String address = addressTA.getText().trim();

        String member_type = typeTF.getText().trim();
        String member_date = StaticAccess.getDate(memberDayCBX, memberMonthCBX, memberYearCBX);
        String expire_date = StaticAccess.getDate(expireDayCBX, expireMonthCBX, expireYearCBX);

        try {
            database.DatabaseFunctionClassMember.insert(name, address, member_type, member_date, expire_date);
            JOptionPane.showMessageDialog(this, "Successfully inserted", "Inserted!!", JOptionPane.INFORMATION_MESSAGE);
            clear();
            load();
        } catch (SQLException ex) {
            StaticAccess.showMassageDialog(this, "Sorry insert can't possible", ex);
        }
    }//GEN-LAST:event_insertBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            int member_id = Integer.parseInt(table.getValueAt(row, 0).toString());
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this member info.",
                    "Delete Member ID:" + member_id, JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    database.DatabaseFunctionClassMember.delete(member_id);
                    load();
                } catch (SQLException ex) {
                    StaticAccess.showMassageDialog(this, "Can't delete from Database", ex);
                }
            }
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void editBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTNActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            int member_id = Integer.parseInt(table.getValueAt(row, 0).toString());
            String name = table.getValueAt(row, 1).toString();
            String address = table.getValueAt(row, 2).toString();
            String member_type = table.getValueAt(row, 3).toString();
            String member_date = table.getValueAt(row, 4).toString();
            String expire_date = table.getValueAt(row, 5).toString();
            MemberEditDialog dialog = new MemberEditDialog(StaticAccess.mainFrame, true, member_id, name, address, member_type, member_date, expire_date);
            dialog.setVisible(true);
            if (dialog.success) {
                load();
            }
        }
    }//GEN-LAST:event_editBTNActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            setEnable(true);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void typeCBXItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeCBXItemStateChanged
        // TODO add your handling code here:
        typeTF.setText(typeCBX.getSelectedItem().toString());
        if (typeCBX.getSelectedItem().toString().equals("OTHER")) {
            typeTF.setText("");
            typeTF.setEditable(true);
        } else {
            typeTF.setEditable(false);
        }
    }//GEN-LAST:event_typeCBXItemStateChanged

    private void borrowBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBTNActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row != -1) {
            int member_id = Integer.parseInt(table.getValueAt(row, 0).toString());
            String name = table.getValueAt(row, 1).toString();
            new Borrow.BorrowDialog(StaticAccess.mainFrame, true, member_id, name).setVisible(true);
        }
    }//GEN-LAST:event_borrowBTNActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTA;
    private javax.swing.JButton borrowBTN;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JPanel dispalyPanel;
    private javax.swing.JButton editBTN;
    private javax.swing.JComboBox expireDayCBX;
    private javax.swing.JComboBox expireMonthCBX;
    private javax.swing.JComboBox expireYearCBX;
    private javax.swing.JButton insertBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox memberDayCBX;
    private javax.swing.JComboBox memberMonthCBX;
    private javax.swing.JComboBox memberYearCBX;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTable table;
    private javax.swing.JComboBox typeCBX;
    private javax.swing.JTextField typeTF;
    // End of variables declaration//GEN-END:variables
}
