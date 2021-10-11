/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.UberCars;
import Business.UberCarsDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.LocalDateTime;
import java.time.Year;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lavina
 */
public class ViewCarsJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form ViewCarsJPanel
     */
    private JPanel userProcessContainer;
    private UberCars uberCars;
    private UberCarsDirectory uberCarsDirectory;

    ViewCarsJPanel1(JPanel userProcessContainer, UberCars uberCars, UberCarsDirectory uberCarsDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.uberCars = uberCars;
        this.uberCarsDirectory = uberCarsDirectory;
        populateCarDetails();
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }
    
    private void populateCarDetails(){
        txtCity.setText(String.valueOf(uberCars.getCity()));
        txtManufacturer.setText(String.valueOf(uberCars.getManufacturer()));
        txtManufacturingYear.setText(String.valueOf(uberCars.getManufacturingYear()));
        txtModelName.setText(String.valueOf(uberCars.getModelName()));
        txtModelNumber.setText(String.valueOf(uberCars.getModelNumber()));
        txtNumOfSeats.setText(String.valueOf(uberCars.getSeats()));
        txtSerialNumber.setText(String.valueOf(uberCars.getSerialNumber()));
        
        if (uberCars.isValidility()){
            chkValid.setSelected(true);
        }
        else{
            chkNotValid.setSelected(true);
        }
        if (uberCars.isAvailability()){
            chkAvailable.setSelected(true);
        }
        else{
            chkNotAvailable.setSelected(true);
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

        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chkNotValid = new javax.swing.JCheckBox();
        txtSerialNumber = new javax.swing.JTextField();
        chkValid = new javax.swing.JCheckBox();
        txtModelNumber = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtCity = new javax.swing.JTextField();
        txtNumOfSeats = new javax.swing.JTextField();
        txtManufacturer = new javax.swing.JTextField();
        txtManufacturingYear = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chkNotAvailable = new javax.swing.JCheckBox();
        txtModelName = new javax.swing.JTextField();
        chkAvailable = new javax.swing.JCheckBox();
        btnUpdate = new javax.swing.JButton();

        jLabel8.setText("Manufacturing Year        :");

        jLabel12.setText("Availability                     :");

        jLabel10.setText("Maintenance Certificate  :");

        chkNotValid.setText("Not Valid");
        chkNotValid.setEnabled(false);

        txtSerialNumber.setEnabled(false);
        txtSerialNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerialNumberActionPerformed(evt);
            }
        });

        chkValid.setText("Valid");
        chkValid.setEnabled(false);
        chkValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkValidActionPerformed(evt);
            }
        });

        txtModelNumber.setEnabled(false);
        txtModelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelNumberActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtCity.setEnabled(false);
        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        txtNumOfSeats.setEnabled(false);
        txtNumOfSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumOfSeatsActionPerformed(evt);
            }
        });

        txtManufacturer.setEnabled(false);
        txtManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufacturerActionPerformed(evt);
            }
        });

        txtManufacturingYear.setEnabled(false);
        txtManufacturingYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufacturingYearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Uber Car Entry");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Model Name                  : ");

        jLabel3.setText("Model Number               : ");

        jLabel4.setText("Serial Number               : ");

        jLabel5.setText("Number of Seats            : ");

        jLabel6.setText("City                               :  ");

        jLabel7.setText("Manufacturer                 : ");

        chkNotAvailable.setText("No");
        chkNotAvailable.setEnabled(false);

        txtModelName.setEnabled(false);
        txtModelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelNameActionPerformed(evt);
            }
        });

        chkAvailable.setText("Yes");
        chkAvailable.setEnabled(false);
        chkAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAvailableActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModelName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManufacturingYear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkValid)
                                    .addComponent(chkAvailable))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkNotAvailable)
                                    .addComponent(chkNotValid))))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtManufacturingYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkNotValid)
                        .addComponent(chkValid))
                    .addComponent(jLabel10))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkNotAvailable)
                    .addComponent(chkAvailable)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerialNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerialNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerialNumberActionPerformed

    private void chkValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkValidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkValidActionPerformed

    private void txtModelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelNumberActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String modelName = txtModelName.getText();
        if (modelName.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Model Name");
            throw new RuntimeException("Please enter the Model Name");
        }
        String modelNumber = txtModelNumber.getText();
        if (modelNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Model Number");
            throw new RuntimeException("Please enter the Model Number");
        }
        String serialNumber = txtSerialNumber.getText();
        if (serialNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Serial Number");
            throw new RuntimeException("Please enter the Serial Number");
        }
        else if(uberCarsDirectory.searchbySerial(serialNumber) != null){
            JOptionPane.showMessageDialog(null, "Serial number already in use, Please enter unique serial number");
            throw new RuntimeException("Serial number already in use, Please enter unique serial number"); 
        }
        String manufacturer = txtManufacturer.getText();
        if (manufacturer.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Manufacturer Name");
            throw new RuntimeException("Please enter the Manufacturer");
        }
        String city = txtCity.getText();
        if (city.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the City");
            throw new RuntimeException("Please enter the City");
        }
        Year manufacturingYear = null;
        try{
            manufacturingYear = Year.parse(txtManufacturingYear.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Please type year in 4 digit format");
        }
        int numofSeats = 0;
        try{
            numofSeats = Integer.parseInt(txtNumOfSeats.getText());
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Please type in a number of seats");
        }

        boolean avail = false ;
        if (chkAvailable.isSelected() && chkNotAvailable.isSelected()){
            JOptionPane.showMessageDialog(null, "Please select only one of the Availability options");
            throw new RuntimeException("Please select only one of the Availability options");
        }
        else if (chkAvailable.isSelected()){
            avail = true;
        }
        else if (chkNotAvailable.isSelected()){
            avail = false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select one of the Availability options");
            throw new RuntimeException("Please select one of the Availability options");
        }

        boolean valid = false;
        if (chkValid.isSelected() && chkNotValid.isSelected()){
            JOptionPane.showMessageDialog(null, "Please select only one of the Validility options");
            throw new RuntimeException("Please select only one of the Validility options");
        }
        else if (chkValid.isSelected()){
            valid = true;
        }
        else if (chkNotValid.isSelected()){
            valid = false;
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select one of the Validility options");
            throw new RuntimeException("Please select one of the Validility options");

        }
        LocalDateTime dt = LocalDateTime.now();
        
        uberCars.setCity(city);
        uberCars.setManufacturer(manufacturer);
        uberCars.setSeats(numofSeats);
        uberCars.setSerialNumber(serialNumber);
        uberCars.setManufacturingYear(manufacturingYear);
        uberCars.setModelName(modelName);
        uberCars.setModelNumber(modelNumber);
        uberCars.setValidility(valid);
        uberCars.setAvailability(avail);
        uberCars.setUpdatedOn(dt);

        JOptionPane.showMessageDialog(null, "Car entered successfully");
        
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        txtCity.setEnabled(false);
        txtManufacturer.setEnabled(false);
        txtManufacturingYear.setEnabled(false);
        txtModelName.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtNumOfSeats.setEnabled(false);
        txtSerialNumber.setEnabled(false);
        chkNotValid.setEnabled(false);
        chkValid.setEnabled(false);
        chkAvailable.setEnabled(false);
        chkNotAvailable.setEnabled(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void txtNumOfSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumOfSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumOfSeatsActionPerformed

    private void txtManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufacturerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufacturerActionPerformed

    private void txtManufacturingYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufacturingYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufacturingYearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        Component[] comps = userProcessContainer.getComponents();

        for (Component comp : comps){
            if (comp instanceof CarsExpiredJPanel){
            System.out.println(comp);
            CarsExpiredJPanel manageP = (CarsExpiredJPanel) comp;
            manageP.populateTable ();
            }
        }
        cardlayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtModelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelNameActionPerformed

    private void chkAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAvailableActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        txtCity.setEnabled(true);
        txtManufacturer.setEnabled(true);
        txtManufacturingYear.setEnabled(true);
        txtModelName.setEnabled(true);
        txtModelNumber.setEnabled(true);
        txtNumOfSeats.setEnabled(true);
        txtSerialNumber.setEnabled(true);
        chkNotValid.setEnabled(true);
        chkValid.setEnabled(true);
        chkAvailable.setEnabled(true);
        chkNotAvailable.setEnabled(true);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chkAvailable;
    private javax.swing.JCheckBox chkNotAvailable;
    private javax.swing.JCheckBox chkNotValid;
    private javax.swing.JCheckBox chkValid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtManufacturingYear;
    private javax.swing.JTextField txtModelName;
    private javax.swing.JTextField txtModelNumber;
    private javax.swing.JTextField txtNumOfSeats;
    private javax.swing.JTextField txtSerialNumber;
    // End of variables declaration//GEN-END:variables
}
