/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Author;

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
public class AuthorPanel extends javax.swing.JPanel {

    /**
     * Creates new form PublisherPanel
     */
    public AuthorPanel() {
        initComponents();
        load();
        religionTF.setText(religionCBX.getSelectedItem().toString());
    }

    void clear() {
        nameTF.setText("");
        religionTF.setText("");
    }

    void load() {
        try {
            ResultSet rs = database.DatabaseFunctionClassAuthor.select();
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

        dispalyPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        insertBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        deleteBTN = new javax.swing.JButton();
        editBTN = new javax.swing.JButton();
        religionCBX = new javax.swing.JComboBox();
        religionTF = new javax.swing.JTextField();

        jLabel1.setText("Name:");

        jLabel2.setText("Religion:");

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
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(editBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBTN)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        religionCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISLAM", "HINDUIST", "BUDHIST", "CRISTIAN", "OTHER" }));
        religionCBX.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                religionCBXItemStateChanged(evt);
            }
        });

        religionTF.setEditable(false);

        javax.swing.GroupLayout dispalyPanelLayout = new javax.swing.GroupLayout(dispalyPanel);
        dispalyPanel.setLayout(dispalyPanelLayout);
        dispalyPanelLayout.setHorizontalGroup(
            dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispalyPanelLayout.createSequentialGroup()
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dispalyPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dispalyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dispalyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(religionCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(insertBTN)
                                    .addComponent(religionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(dispalyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dispalyPanelLayout.setVerticalGroup(
            dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispalyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dispalyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(religionCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(religionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String address = religionTF.getText().trim();
        try {
            database.DatabaseFunctionClassAuthor.insert(name, address);
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
            int author_id = Integer.parseInt(table.getValueAt(row, 0).toString());
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this author info.",
                    "Delete author ID:" + author_id, JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    database.DatabaseFunctionClassAuthor.delete(author_id);
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
            int author_id = Integer.parseInt(table.getValueAt(row, 0).toString());
            String name = table.getValueAt(row, 1).toString();
            String religion = table.getValueAt(row, 2).toString();
            AuthorEditDialog dialog = new AuthorEditDialog(StaticAccess.mainFrame, true, author_id, name, religion);
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

    private void religionCBXItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_religionCBXItemStateChanged
        // TODO add your handling code here:
        religionTF.setText(religionCBX.getSelectedItem().toString());
        if (religionCBX.getSelectedItem().toString().equals("OTHER")) {
            religionTF.setText("");
            religionTF.setEditable(true);
        } else {
            religionTF.setEditable(false);
        }
    }//GEN-LAST:event_religionCBXItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBTN;
    private javax.swing.JPanel dispalyPanel;
    private javax.swing.JButton editBTN;
    private javax.swing.JButton insertBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTF;
    private javax.swing.JComboBox religionCBX;
    private javax.swing.JTextField religionTF;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}