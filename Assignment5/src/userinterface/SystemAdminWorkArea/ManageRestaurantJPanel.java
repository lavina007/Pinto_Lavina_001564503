/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lavina
 */
public class ManageRestaurantJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem ecosystem;
    Enterprise enterprise; 
    Organization organization;
    /**
     * Creates new form ManageRestaurantJPanel
     */
    public ManageRestaurantJPanel(JPanel userProcessContainer,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        populateTable();
        if(enterprise!=null &&organization!=null ){
        this.enterprise = ecosystem.getEnterpriseDirectory().searchEnterprise(txtSearchRestaurant.getText());
        this.organization=enterprise.getRestaurantDirectory().searchOrganization("RestaurantAdmin") ;
        }
    }

    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblRestaurantsList.getModel();
        dtm.setRowCount(0);
        for(Enterprise enterprise:ecosystem.getEnterpriseDirectory().getEnterpriseList()) {
            Object row[] = new Object[3];
            row[0] = enterprise.getName();
            row[1] = enterprise.getAddress();
            row[2] = enterprise;
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

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRestaurantsList = new javax.swing.JTable();
        btnNewRestaurant = new javax.swing.JButton();
        btnUpdateRestaurant = new javax.swing.JButton();
        DeleteRestaurant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearchRestaurant = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSearchRestaurant = new javax.swing.JTable();
        btnManageFlights = new javax.swing.JButton();
        DeleteManagersBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setBackground(new java.awt.Color(51, 0, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Restaurant Information");

        refreshJButton.setBackground(new java.awt.Color(51, 0, 0));
        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        tblRestaurantsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Restaurant Name", "Address", "Enterprise"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRestaurantsList.setGridColor(new java.awt.Color(255, 255, 255));
        tblRestaurantsList.setSelectionBackground(new java.awt.Color(51, 0, 0));
        jScrollPane1.setViewportView(tblRestaurantsList);

        btnNewRestaurant.setBackground(new java.awt.Color(51, 0, 0));
        btnNewRestaurant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNewRestaurant.setForeground(new java.awt.Color(255, 255, 255));
        btnNewRestaurant.setText("New");
        btnNewRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRestaurantActionPerformed(evt);
            }
        });

        btnUpdateRestaurant.setBackground(new java.awt.Color(51, 0, 0));
        btnUpdateRestaurant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateRestaurant.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateRestaurant.setText("Update");
        btnUpdateRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRestaurantActionPerformed(evt);
            }
        });

        DeleteRestaurant.setBackground(new java.awt.Color(51, 0, 0));
        DeleteRestaurant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteRestaurant.setForeground(new java.awt.Color(255, 255, 255));
        DeleteRestaurant.setText("Delete");
        DeleteRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRestaurantActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Restaurant Manager Information");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Restaurant");

        txtSearchRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchRestaurantActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(51, 0, 0));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblSearchRestaurant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Restaurant Name", "Manager Name", "Manager UserName/Email ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchRestaurant.setGridColor(new java.awt.Color(255, 255, 255));
        tblSearchRestaurant.setSelectionBackground(new java.awt.Color(51, 0, 0));
        jScrollPane2.setViewportView(tblSearchRestaurant);

        btnManageFlights.setBackground(new java.awt.Color(51, 0, 0));
        btnManageFlights.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnManageFlights.setForeground(new java.awt.Color(255, 255, 255));
        btnManageFlights.setText("Update");
        btnManageFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageFlightsActionPerformed(evt);
            }
        });

        DeleteManagersBtn.setBackground(new java.awt.Color(51, 0, 0));
        DeleteManagersBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteManagersBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteManagersBtn.setText("Delete");
        DeleteManagersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteManagersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNewRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(btnUpdateRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DeleteRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(404, 404, 404)
                                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(txtSearchRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btnManageFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(DeleteManagersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteManagersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        Component[] comps = this.userProcessContainer.getComponents();
        for(Component comp : comps){
            if(comp instanceof SystemAdminWorkAreaJPanel){
                SystemAdminWorkAreaJPanel systemAdminWorkAreaJPanel= (SystemAdminWorkAreaJPanel) comp;
                systemAdminWorkAreaJPanel.populateTree();
            }
        }
        //layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void DeleteRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRestaurantActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRestaurantsList.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Enterprise e = (Enterprise)tblRestaurantsList.getValueAt(selectedRow, 2);
            ecosystem.getEnterpriseDirectory().deleteEnterprise(e);
            JOptionPane.showMessageDialog(null, "Restaurant deleted successfully");
            populateTable();
        }

    }//GEN-LAST:event_DeleteRestaurantActionPerformed

    private void btnNewRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRestaurantActionPerformed
        // TODO add your handling code here:
        CreateRestaurantJPanel panel = new CreateRestaurantJPanel(userProcessContainer,ecosystem);
        userProcessContainer.add("CreateNewRestaurantJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNewRestaurantActionPerformed

    private void btnUpdateRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRestaurantActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRestaurantsList.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            //UserAccount ua = (UserAccount)tblRestaurantsList.getValueAt(selectedRow, 2);
            UpdateRestaurantJPanel panel = new UpdateRestaurantJPanel(userProcessContainer, ecosystem);
            userProcessContainer.add("UpdateRestaurantJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }

    }//GEN-LAST:event_btnUpdateRestaurantActionPerformed

    private void txtSearchRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchRestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchRestaurantActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Enterprise result = ecosystem.getEnterpriseDirectory().searchEnterprise(txtSearchRestaurant.getText());
        Organization organization1=result.getRestaurantDirectory().searchOrganization("RestaurantAdmin") ;
        if (result == null) {
            JOptionPane.showMessageDialog(null, "Restaurant does not exist","Information",JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel dtm = (DefaultTableModel) tblSearchRestaurant.getModel();
            dtm.setRowCount(0);
        }
        else{
            DefaultTableModel dtm = (DefaultTableModel) tblSearchRestaurant.getModel();
            dtm.setRowCount(0);
            for(UserAccount userAccount:organization1.getUserAccountDirectory().getUserAccountList())
            {
                Object row[] = new Object[3];
                row[0] = result.getName();
                row[1] = userAccount.getEmployee().getName();
                row[2] = userAccount;
                dtm.addRow(row);
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void DeleteManagersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteManagersBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblSearchRestaurant.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            UserAccount ua = (UserAccount)tblSearchRestaurant.getValueAt(selectedRow, 2);
            Enterprise result = ecosystem.getEnterpriseDirectory().searchEnterprise((String)tblSearchRestaurant.getValueAt(selectedRow, 0));
            Organization organization = result.getRestaurantDirectory().searchOrganization("RestaurantAdmin") ;
            organization.getUserAccountDirectory().deleteUserAccount(ua);
            organization.getEmployeeDirectory().deleteEmployee(ua.getEmployee());
            JOptionPane.showMessageDialog(null, "Manager Account deleted successfully");
            
        }
    }//GEN-LAST:event_DeleteManagersBtnActionPerformed

    private void btnManageFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageFlightsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblSearchRestaurant.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            UserAccount ua = (UserAccount)tblSearchRestaurant.getValueAt(selectedRow, 2);
            UpdateUserJPanel panel = new UpdateUserJPanel(userProcessContainer,ua,"RestaurantAdmin");
            userProcessContainer.add("UpdateManagerJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnManageFlightsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteManagersBtn;
    private javax.swing.JButton DeleteRestaurant;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnManageFlights;
    private javax.swing.JButton btnNewRestaurant;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateRestaurant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable tblRestaurantsList;
    private javax.swing.JTable tblSearchRestaurant;
    private javax.swing.JTextField txtSearchRestaurant;
    // End of variables declaration//GEN-END:variables
}
