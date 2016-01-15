/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

import Default.StaticAccess;
import Default.UsableSetDate;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author keno
 */
public class MemberEditDialog extends javax.swing.JDialog {

    /**
     * Creates new form PublishEditDialog
     */
    int member_id;
    boolean success=false;
    public MemberEditDialog(java.awt.Frame parent, boolean modal, int member_id, String name, String address, String member_type,
            String member_date, String expire_date) {
        super(parent, modal);
        initComponents();
        this.member_id=member_id;
        this.setTitle("Update Member: "+name);
        this.setLocation(this.getToolkit().getScreenSize().width/2- this.getWidth()/2, 
                this.getToolkit().getScreenSize().height/2- this.getHeight()/2);
        nameTF.setText(name);
        addressTA.setText(address);
        StaticAccess.setSelectedItem(typeCBX, member_type);
        
        String member_dateSplit[]=member_date.split(" ");
        new UsableSetDate(memberDayCBX, memberMonthCBX, memberYearCBX, member_dateSplit[0]);
        
        String expire_dateSplit[]=expire_date.split(" ");
        new UsableSetDate(expireDayCBX, expireMonthCBX, expireYearCBX, expire_dateSplit[0]);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        addressTA = new javax.swing.JTextArea();
        typeCBX = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        typeTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        memberDayCBX = new javax.swing.JComboBox();
        memberMonthCBX = new javax.swing.JComboBox();
        memberYearCBX = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        expireDayCBX = new javax.swing.JComboBox();
        expireMonthCBX = new javax.swing.JComboBox();
        expireYearCBX = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        insertBTN.setBackground(new java.awt.Color(153, 0, 0));
        insertBTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        insertBTN.setForeground(new java.awt.Color(204, 204, 204));
        insertBTN.setText("UPDATE INFO");
        insertBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBTNActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Address:");

        addressTA.setColumns(20);
        addressTA.setLineWrap(true);
        addressTA.setRows(5);
        addressTA.setWrapStyleWord(true);
        jScrollPane3.setViewportView(addressTA);

        typeCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NORMAL", "SILVER", "PLATINUM", "GOLD", "DIAMOND", "VIP", "OTHER" }));
        typeCBX.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeCBXItemStateChanged(evt);
            }
        });

        jLabel3.setText("Member Type:");

        typeTF.setEditable(false);

        jLabel4.setText("Member_date:");

        memberDayCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        memberMonthCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        memberYearCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1970" }));

        jLabel5.setText("Expire_date:");

        expireDayCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        expireMonthCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        expireYearCBX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1970" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(insertBTN)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeTF)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(memberDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(memberMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(memberYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(expireDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(expireMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(expireYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addComponent(insertBTN)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(typeCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(memberDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(memberMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(memberYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(expireDayCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(expireMonthCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(expireYearCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        pack();
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
            database.DatabaseFunctionClassMember.update(name, address, member_type, member_date, expire_date, member_id);
            JOptionPane.showMessageDialog(this, "Successfully updated", "Updated!!", JOptionPane.INFORMATION_MESSAGE);
            success=true;
            this.dispose();
        } catch (SQLException ex) {
            StaticAccess.showMassageDialog(this, "Sorry update can't possible", ex);
        }
    }//GEN-LAST:event_insertBTNActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTA;
    private javax.swing.JComboBox expireDayCBX;
    private javax.swing.JComboBox expireMonthCBX;
    private javax.swing.JComboBox expireYearCBX;
    private javax.swing.JButton insertBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox memberDayCBX;
    private javax.swing.JComboBox memberMonthCBX;
    private javax.swing.JComboBox memberYearCBX;
    private javax.swing.JTextField nameTF;
    private javax.swing.JComboBox typeCBX;
    private javax.swing.JTextField typeTF;
    // End of variables declaration//GEN-END:variables
}
