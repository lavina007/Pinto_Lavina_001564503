/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.UberCars;
import Business.UberCarsDirectory;
import java.awt.CardLayout;
import static java.awt.image.ImageObserver.WIDTH;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lavina
 */
public class ListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCarsJPanel
     */
    private JPanel userProcessContainer;
    private UberCarsDirectory uberCarsDirectory;
    private int count;
    private String temparr[];
    private UberCarsDirectory tempCarsDirectory;
    ListJPanel(JPanel userProcessContainer, UberCarsDirectory uberCarsDirectory, int count) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.uberCarsDirectory = uberCarsDirectory;
        this.count = count;
        this.tempCarsDirectory = new UberCarsDirectory();
        populateTable();      
    }
    
     public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblManufacturer.getModel();
        dtm.setRowCount(0);
        Object row [] = new Object[2];
        int count1[] = new int[count];
        for (int i = 0;i<count1.length;i++){
            count1[i] = 0;
        }
        int tempcount = 0;
        String temparr[] = new String[count];
        for (int i = 0; i<count ;i++){
            temparr[i] = "";
        }
        
        for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
            for (int i = 0; i<count; i++){
                if(temparr[i].equals(uberCars.getManufacturer())){
                    break;
                }
                else{
                   row[0] = uberCars.getManufacturer();
                   temparr[i] = uberCars.getManufacturer();
                   dtm.addRow(row); 
                   tempcount++;
                   break;
                }
            }
        }
         
         txtManufacturers.setText(String.valueOf(tempcount));
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblManufacturer = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtManufacturers = new javax.swing.JTextField();

        tblManufacturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Manufacturer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblManufacturer);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Manufacturers:");

        txtManufacturers.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(txtManufacturers, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtManufacturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManufacturer;
    private javax.swing.JTextField txtManufacturers;
    // End of variables declaration//GEN-END:variables

}
