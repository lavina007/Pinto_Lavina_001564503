/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Order;
import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class TrackOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private EcoSystem business;
    /**
     * Creates new form TrackOrderJPanel
     */
    public TrackOrderJPanel(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business=business;
       populateCurrentOrdersTable();
       populateOrderHistoryTable();
    }
    
    public void populateCurrentOrdersTable(){
        DefaultTableModel dtm = (DefaultTableModel) CurrentOrdersTable.getModel();
        dtm.setRowCount(0);
        for(Order o:business.getOrderDirectory().getOrderList())
        {
         if(o.getCustomerUserName()!=null&&o.getCustomerUserName().equals(userAccount.getUsername()) && !(o.getStatus().equals("order received")))
         {
            Object row[] = new Object[5];
            row[0] = o;
            row[1] = o.getCustomerName();
             row[2] = o.getCustomerNotes();
            row[3] = o.getStatus();
            row[4] = o.getRestaurantName();
            dtm.addRow(row);
        }
    
        }
    }
    
     public void populateOrderHistoryTable(){
        DefaultTableModel dtm = (DefaultTableModel) orderHistoryTable.getModel();
        dtm.setRowCount(0);
        for(Order o:business.getOrderDirectory().getOrderList())
        {
         if(o.getCustomerUserName()!=null&&o.getCustomerUserName().equals(userAccount.getUsername()) && o.getStatus().equals("order received"))
         {
            Object row[] = new Object[5];
            row[0] = o;
            row[1] = o.getCustomerName();
             row[2] = o.getCustomerNotes();
            row[3] = o.getStatus();
            row[4] = o.getRestaurantName();
            dtm.addRow(row);
        }
    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CurrentOrdersTable = new javax.swing.JTable();
        enterpriseLabel1 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        ConfirmOrderBtn = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderHistoryTable = new javax.swing.JTable();
        feedbackBtn = new javax.swing.JButton();
        feedbackTxt = new javax.swing.JTextField();

        btnBack.setBackground(new java.awt.Color(255, 153, 0));
        btnBack.setText("<- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        CurrentOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Customer Name", "Message from customer", "Status", "Restaurant Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CurrentOrdersTable);

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel1.setText("Current Orders:");

        cancelBtn.setBackground(new java.awt.Color(255, 153, 0));
        cancelBtn.setText("Cancel Order");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        ConfirmOrderBtn.setBackground(new java.awt.Color(255, 153, 0));
        ConfirmOrderBtn.setText("Confirm if received");
        ConfirmOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmOrderBtnActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Order History:");

        orderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Customer Name", "Message from customer", "Status", "Restaurant Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderHistoryTable);

        feedbackBtn.setBackground(new java.awt.Color(255, 153, 0));
        feedbackBtn.setText("Provide feedback");
        feedbackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(enterpriseLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(310, 310, 310)
                            .addComponent(cancelBtn)
                            .addGap(95, 95, 95)
                            .addComponent(ConfirmOrderBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(enterpriseLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(190, 190, 190)
                            .addComponent(feedbackBtn)
                            .addGap(45, 45, 45)
                            .addComponent(feedbackTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnBack)
                    .addGap(27, 27, 27)
                    .addComponent(enterpriseLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cancelBtn)
                        .addComponent(ConfirmOrderBtn))
                    .addGap(27, 27, 27)
                    .addComponent(enterpriseLabel)
                    .addGap(8, 8, 8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(feedbackBtn)
                        .addComponent(feedbackTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = CurrentOrdersTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Order o = (Order)CurrentOrdersTable.getValueAt(selectedRow,0 );
            business.getOrderDirectory().deleteOrder(o);
            JOptionPane.showMessageDialog(null, "Order deleted successfully");
            populateCurrentOrdersTable();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void ConfirmOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmOrderBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = CurrentOrdersTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        Order o = (Order)CurrentOrdersTable.getValueAt(selectedRow,0 );
        if (!o.getStatus().equals("delivered")) {
            JOptionPane.showMessageDialog(null, "This order is not yet delivered by us..!");
            return;
        }
        o.setStatus("order received");

        populateCurrentOrdersTable();
        populateOrderHistoryTable();

    }//GEN-LAST:event_ConfirmOrderBtnActionPerformed

    private void feedbackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderHistoryTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Order o = (Order)orderHistoryTable.getValueAt(selectedRow,0 );
            /* if(o.getFeedback().equals("")||o.getFeedback()==null){
                JOptionPane.showMessageDialog(null, "Feedback already provided for this order.!");
                return;
            }*/
            if(feedbackTxt.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Feedback cannot be empty");
                return;
            }
            o.setFeedback(feedbackTxt.getText());
            JOptionPane.showMessageDialog(null, "Thank you for your feedback.!");
        }
    }//GEN-LAST:event_feedbackBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmOrderBtn;
    private javax.swing.JTable CurrentOrdersTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JButton feedbackBtn;
    private javax.swing.JTextField feedbackTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderHistoryTable;
    // End of variables declaration//GEN-END:variables
}
