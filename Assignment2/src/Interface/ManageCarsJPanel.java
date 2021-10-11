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
import static java.awt.image.ImageObserver.WIDTH;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lavina
 */
public class ManageCarsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCarsJPanel
     */
    private JPanel userProcessContainer;
    private UberCarsDirectory uberCarsDirectory;
    private ArrayList <UberCars> tempCarsDirectory;  
    public int count;
    
    ManageCarsJPanel(JPanel userProcessContainer, UberCarsDirectory uberCarsDirectory) {
         initComponents();
         this.userProcessContainer = userProcessContainer;
         this.uberCarsDirectory = uberCarsDirectory;
         populateTable();
         populateFilters();
         
    }
     private void populateFilters(){
        
        boxCity.removeAllItems();
        boxManu1.removeAllItems();
        boxManuYear.removeAllItems();
        boxModel.removeAllItems();
        boxCity.addItem("Null");
        boxManu1.addItem("Null");
        boxManuYear.addItem("Null");
        boxModel.addItem("Null");
        boxMaxSeats.setSelectedIndex(0);
        boxMinSeats.setSelectedIndex(0);
        
        String temparr[] = new String[count];
        for (int i = 0; i<count ;i++){
            temparr[i] = "";
        }
       
        int i =0;
        for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
            temparr[i] = uberCars.getManufacturer();
            i++;
        }
        for (i = 0; i < count; i++){
            for (int j = i+1 ; j< temparr.length; j ++){
            if(!"".equals(temparr[j]) && temparr[i].equals(temparr[j])){
                temparr[j] = "";
            }
            }
            if(!"".equals(temparr[i])){
                boxManu1.addItem(temparr[i]);
            }
        }
        
        i =0;
        for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
            temparr[i] = uberCars.getModelName();
            i++;
        }
        for (i = 0; i < count; i++){
            for (int j = i+1 ; j< temparr.length; j ++){
            if(!"".equals(temparr[j]) && temparr[i].equals(temparr[j])){
                temparr[j] = "";
            }
            }
            if(!"".equals(temparr[i])){
                boxModel.addItem(temparr[i]);
            }
        }
        
        i =0;
        for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
            temparr[i] = String.valueOf(uberCars.getManufacturingYear());
            i++;
        }
        for (i = 0; i < count; i++){
            for (int j = i+1 ; j< temparr.length; j ++){
            if(!"".equals(temparr[j]) && temparr[i].equals(temparr[j])){
                temparr[j] = "";
            }
            }
            if(!"".equals(temparr[i])){
                boxManuYear.addItem(temparr[i]);
            }
        }
        
        i =0;
        for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
            temparr[i] = uberCars.getCity();
            i++;
        }
        for (i = 0; i < count; i++){
            for (int j = i+1 ; j< temparr.length; j ++){
            if(!"".equals(temparr[j]) && temparr[i].equals(temparr[j])){
                temparr[j] = "";
            }
            }
            if(!"".equals(temparr[i])){
                boxCity.addItem(temparr[i]);
            }
        }
        
        for ( i = 0; i < count; i++){
            temparr[i] = "";
        }
        
        
    /*    for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
            for (int i = 0; i<count; i++){
                if(temparr[i].equals(String.valueOf(uberCars.getSeats()))){
                    break;
                }
                else{
                    boxMinSeats.addItem(String.valueOf(uberCars.getSeats()));
                    boxMaxSeats.addItem(String.valueOf(uberCars.getSeats()));
                    temparr[i] = String.valueOf(uberCars.getSeats());
                    break;
                }
            }
        }
       */ 
        
     }
    
     public void populateTable() {
         DefaultTableModel dtm = (DefaultTableModel) tblCars.getModel();
         dtm.setRowCount(0);
         count = 0;
         Object row [] = new Object[7];
         for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
             row[0] = uberCars;
             row[1] = uberCars.getModelNumber();
             row[2] = uberCars.getSerialNumber();
             row[3] = uberCars.getManufacturer();
             if(uberCars.isAvailability()){
                 row[4] = "Yes";
             }
             else{
                 row[4] = "No";
             }
             row[5] = uberCars.getSeats();
             row[6] = uberCars.getCity();
             dtm.addRow(row);
             count++;
         }
         LocalDateTime dt = LocalDateTime.parse("0000-01-01T00:00:00.000");
         int counttemp = 0;
         for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory()){
             if(counttemp == 0){
                 dt = uberCars.getUpdatedOn();
                 counttemp++;
             }
             else{
                 if(dt.isBefore(uberCars.getUpdatedOn())){
                     dt = uberCars.getUpdatedOn();
                 }
             }
         }
         DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
         String formattedDt = dt.format(myFormatObj);
         txtUpdateOn.setText(formattedDt);
    }
     public void populateTable1() {
         DefaultTableModel dtm = (DefaultTableModel) tblCars.getModel();
         dtm.setRowCount(0);
         count = 0;
         Object row [] = new Object[7];
         for (UberCars uberCars: uberCarsDirectory.getUberCarsDirectory(tempCarsDirectory)){
             row[0] = uberCars;
             row[1] = uberCars.getModelNumber();
                row[2] = uberCars.getSerialNumber();
             row[3] = uberCars.getManufacturer();
             if(uberCars.isAvailability()){
                 row[4] = "Yes";
             }
             else{
                 row[4] = "No";
             }
             row[5] = uberCars.getSeats();
             row[6] = uberCars.getCity();
             dtm.addRow(row);
             count++;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCars = new javax.swing.JTable();
        btnManufacturer = new javax.swing.JButton();
        btnFirstCar = new javax.swing.JButton();
        btnAvailableCars = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        boxManu1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        boxModel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        boxMinSeats = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        boxMaxSeats = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boxCity = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        boxManuYear = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSerialNumber = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExpiredCerti = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtUpdateOn = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtModelNumber = new javax.swing.JTextField();
        btnSearch1 = new javax.swing.JButton();

        tblCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Model Name", "Model Number", "Serial Number", "Manufacturer", "Available", "Seats", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCars);

        btnManufacturer.setText("List of all Manufacturers");
        btnManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManufacturerActionPerformed(evt);
            }
        });

        btnFirstCar.setText("Get the first available Car");
        btnFirstCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstCarActionPerformed(evt);
            }
        });

        btnAvailableCars.setText("Current Availability of all Cars");
        btnAvailableCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailableCarsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Please select the filters you want to apply:");

        boxManu1.setMaximumRowCount(20);
        boxManu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));
        boxManu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxManu1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Manufacturer: ");

        boxModel.setMaximumRowCount(20);
        boxModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));

        jLabel3.setText("Model:");

        boxMinSeats.setMaximumRowCount(20);
        boxMinSeats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "1", "2", "3", "4", "5", "6", "7" }));
        boxMinSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMinSeatsActionPerformed(evt);
            }
        });

        jLabel4.setText("Min Seats:");

        boxMaxSeats.setMaximumRowCount(20);
        boxMaxSeats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "1", "2", "3", "4", "5", "6", "7" }));
        boxMaxSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMaxSeatsActionPerformed(evt);
            }
        });

        jLabel5.setText("Max Seats:");

        jLabel6.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jLabel7.setText("City:");

        boxCity.setMaximumRowCount(20);
        boxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));

        jLabel8.setText("Manufacturing Year:");

        boxManuYear.setMaximumRowCount(20);
        boxManuYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Manual Search:");

        jLabel10.setText("By Serial Number:");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExpiredCerti.setText("Cars with Expired Maintenance Certificate");
        btnExpiredCerti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpiredCertiActionPerformed(evt);
            }
        });

        jLabel11.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jLabel12.setText("Last Update On:");

        txtUpdateOn.setEnabled(false);
        txtUpdateOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateOnActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel13.setText("By Model Number:");

        txtModelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelNumberActionPerformed(evt);
            }
        });

        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExpiredCerti)
                        .addGap(25, 25, 25)))
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUpdateOn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(boxModel, 0, 64, Short.MAX_VALUE)
                                .addComponent(boxManu1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boxMinSeats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(204, 204, 204)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(boxManuYear, 0, 65, Short.MAX_VALUE)
                                        .addComponent(boxCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(boxMaxSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnFirstCar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAvailableCars, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirstCar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvailableCars, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxManu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(boxCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(boxManuYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxMinSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(boxMaxSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExpiredCerti, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdateOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxManu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxManu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxManu1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        Component[] comps = userProcessContainer.getComponents();
         for (Component comp : comps){
            if (comp instanceof ManageCarsJPanel){
            System.out.println(comp);
            ManageCarsJPanel manageP = (ManageCarsJPanel) comp;
            manageP.populateTable ();
            }
        } 
        cardlayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCars.getSelectedRow();

        if (selectedRow >= 0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete this Cars details", TOOL_TIP_TEXT_KEY, WIDTH);
            if(dialogResult == JOptionPane.YES_OPTION){
                UberCars uberCars = (UberCars) tblCars.getValueAt(selectedRow, 0);
                uberCarsDirectory.deleteCars(uberCars);
                populateTable();
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"Please select a record from the table", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCars.getSelectedRow();

        if (selectedRow >= 0){
            UberCars uberCars = (UberCars) tblCars.getValueAt(selectedRow, 0);
            ViewCarsJPanel viewCarsJPanel = new ViewCarsJPanel(userProcessContainer, uberCars, uberCarsDirectory);
            userProcessContainer.add ("ViewCarsJPanel", viewCarsJPanel);
            CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
            cardlayout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null,"Please select a record from the table", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnFirstCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstCarActionPerformed
        // TODO add your handling code here
        UberCars uberCarSelected = new UberCars();
        
        for (UberCars uberCar: uberCarsDirectory.getUberCarsDirectory()){
             if(uberCar.isAvailability()){
                 uberCarSelected = (UberCars) uberCar;
                 break;
             }
        }
        ViewFirstCarsJPanel viewFirstCarsJPanel = new ViewFirstCarsJPanel(userProcessContainer, uberCarSelected);
        userProcessContainer.add ("ViewFirstCarsJPanel", viewFirstCarsJPanel);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.next(userProcessContainer);
    }//GEN-LAST:event_btnFirstCarActionPerformed

    private void btnAvailableCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailableCarsActionPerformed
        // TODO add your handling code here:
        CurrentCarsJPanel currentCarsJPanel = new CurrentCarsJPanel(userProcessContainer, uberCarsDirectory);
        userProcessContainer.add("CurrentCarsJPanel",currentCarsJPanel);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.next(userProcessContainer);
    }//GEN-LAST:event_btnAvailableCarsActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String manu1 = "";
        if(((String)boxManu1.getSelectedItem()).equals("Null")){
        }
        else{
             manu1 = (String)boxManu1.getSelectedItem();
        }
        
        String city  = "";
        if(((String)boxCity.getSelectedItem()).equals("Null")){
        }
        else{
            city = (String)boxCity.getSelectedItem();
        };
        
        String manuYear = "";
        if(((String)boxManuYear.getSelectedItem()).equals("Null")){
        }
        else{
            manuYear = (String)boxManuYear.getSelectedItem();
        }
        String modelName = "";
        if(((String)boxModel.getSelectedItem()).equals("Null")){
        }
        else{
            modelName = (String)boxModel.getSelectedItem();
        }
        
        String minSeats = "";
        if(((String)boxMinSeats.getSelectedItem()).equals("Null")){
        }
        else{
            minSeats = (String)boxMinSeats.getSelectedItem();
        }
        String maxSeats = "";
        if(((String)boxMaxSeats.getSelectedItem()).equals("Null")){
        }
        else{
            maxSeats = (String)boxMaxSeats.getSelectedItem();
        }
        tempCarsDirectory = uberCarsDirectory.searchCars(manu1, manuYear, minSeats, maxSeats, modelName, city);
        populateTable1();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        UberCars result = uberCarsDirectory.searchbySerial(txtSerialNumber.getText());
        if (result == null){
            JOptionPane.showMessageDialog(this, "Serial number entered does not exist in  our records", "Information Message", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            ViewCarsJPanel viewCarsJPanel = new ViewCarsJPanel(userProcessContainer, result, uberCarsDirectory);
            userProcessContainer.add ("ViewCarsJPanel", viewCarsJPanel);
            CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
            cardlayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExpiredCertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpiredCertiActionPerformed
        CarsExpiredJPanel carsExpiredJPanel = new CarsExpiredJPanel(userProcessContainer, uberCarsDirectory);
        userProcessContainer.add("CarsExpiredJPanel",carsExpiredJPanel);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.next(userProcessContainer);
    }//GEN-LAST:event_btnExpiredCertiActionPerformed

    private void btnManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManufacturerActionPerformed
        ListJPanel listJPanel = new ListJPanel(userProcessContainer, uberCarsDirectory, count);
        userProcessContainer.add("CarsExpiredJPanel",listJPanel);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnManufacturerActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       
        int selectedRow = tblCars.getSelectedRow();
        if (selectedRow >= 0){
            UberCars uberCars = (UberCars) tblCars.getValueAt(selectedRow, 0);
            UpdateCarsJPanel updateCarsJPanel = new UpdateCarsJPanel(userProcessContainer, uberCars, uberCarsDirectory);
            userProcessContainer.add("UpdateCarsJPanel", updateCarsJPanel);
            CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
            cardlayout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null,"Please select a record from the table", "Warning", JOptionPane.WARNING_MESSAGE);
        }  
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtUpdateOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateOnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateOnActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateTable();
        populateFilters();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
        
        UberCars result = uberCarsDirectory.searchByModel(txtModelNumber.getText());
        if (result == null){
            JOptionPane.showMessageDialog(this, "Model number entered does not exist in our records", "Information Message", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            ViewCarsJPanel viewCarsJPanel = new ViewCarsJPanel(userProcessContainer, result, uberCarsDirectory);
            userProcessContainer.add ("ViewCarsJPanel", viewCarsJPanel);
            CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
            cardlayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void txtModelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelNumberActionPerformed

    private void boxMaxSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMaxSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMaxSeatsActionPerformed

    private void boxMinSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMinSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMinSeatsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCity;
    private javax.swing.JComboBox<String> boxManu1;
    private javax.swing.JComboBox<String> boxManuYear;
    private javax.swing.JComboBox<String> boxMaxSeats;
    private javax.swing.JComboBox<String> boxMinSeats;
    private javax.swing.JComboBox<String> boxModel;
    private javax.swing.JButton btnAvailableCars;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExpiredCerti;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnFirstCar;
    private javax.swing.JButton btnManufacturer;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCars;
    private javax.swing.JTextField txtModelNumber;
    private javax.swing.JTextField txtSerialNumber;
    private javax.swing.JTextField txtUpdateOn;
    // End of variables declaration//GEN-END:variables

}
