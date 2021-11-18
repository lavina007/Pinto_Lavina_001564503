/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Items;
import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lavina
 */
public class ManageMenuJPanel extends javax.swing.JPanel {
    
   JPanel userProcessContainer;
   EcoSystem business;
   Enterprise enterprise;
   Organization organization;
   UserAccount account;
    /**
     * Creates new form ManageMenuJPanel
     */
    public ManageMenuJPanel(JPanel userProcessContainer,EcoSystem business,Enterprise enterprise,Organization organization,UserAccount account) {
        initComponents();
        this.organization=organization;
        this.enterprise=enterprise;
        this.account=account;
        this.business=business;
        this.userProcessContainer=userProcessContainer;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) ItemsListTable.getModel();
        dtm.setRowCount(0);
        
        for(Items item:enterprise.getItemsList()) {
            Object row[] = new Object[2];
            row[0] = item;
            row[1] = item.getPrice();
            dtm.addRow(row);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsListTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        updatePriceTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ItemPriceTextField = new javax.swing.JTextField();
        ItemNameTextField = new javax.swing.JTextField();

        btnBack.setBackground(new java.awt.Color(255, 153, 0));
        btnBack.setText("<- Back");
        btnBack.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnBackFocusLost(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Restaurant Menu");

        ItemsListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ItemsListTable);

        deleteButton.setBackground(new java.awt.Color(255, 153, 0));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        UpdateBtn.setBackground(new java.awt.Color(255, 153, 0));
        UpdateBtn.setText("Update Price");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        updatePriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePriceTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Item Name : ");

        jLabel3.setText("Item Price : ");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setText("Add Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ItemPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemPriceTextFieldActionPerformed(evt);
            }
        });

        ItemNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(deleteButton)
                        .addGap(61, 61, 61)
                        .addComponent(UpdateBtn)
                        .addGap(50, 50, 50)
                        .addComponent(updatePriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(52, 52, 52)
                                .addComponent(ItemPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatePriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ItemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ItemPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnBackFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackFocusLost

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = ItemsListTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Items item = (Items)ItemsListTable.getValueAt(selectedRow, 0);
            enterprise.deleteItem(item);
            JOptionPane.showMessageDialog(null, "Item deleted successfully");
            populateTable();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = ItemsListTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Items item = (Items)ItemsListTable.getValueAt(selectedRow, 0);
            item.setPrice(Integer.parseInt(updatePriceTextField.getText()));
            JOptionPane.showMessageDialog(null, "Item updated successfully");
            populateTable();
            updatePriceTextField.setText("");
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void updatePriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatePriceTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        for(Items item:enterprise.getItemsList()) {
            if(ItemNameTextField.getText().equals(item.getItemName())){

                JOptionPane.showMessageDialog(null, "Item already exists");
                return;
            }
        }
        if(ItemNameTextField.getText().equals("")||ItemNameTextField.getText()==null){
            JOptionPane.showMessageDialog(null, "Item can't be empty");
            return;
        }
        for(Enterprise e: business.getEnterpriseDirectory().getEnterpriseList()){
            if(e.getName().equalsIgnoreCase(enterprise.getName())){
                Items item =enterprise.createMenuItem();
                item.setItemName(ItemNameTextField.getText());
                item.setPrice(Integer.parseInt(ItemPriceTextField.getText()));
                populateTable();
            }
        }
        ItemNameTextField.setText("");
        ItemPriceTextField.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ItemPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemPriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemPriceTextFieldActionPerformed

    private void ItemNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ItemNameTextField;
    private javax.swing.JTextField ItemPriceTextField;
    private javax.swing.JTable ItemsListTable;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField updatePriceTextField;
    // End of variables declaration//GEN-END:variables
}
