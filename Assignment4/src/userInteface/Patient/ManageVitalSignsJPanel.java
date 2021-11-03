/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package userInteface.Patient;

import business.MyStringVerifier;
import business.Patient;
import business.Person;
import business.PersonDirectory;
import business.VitalSign;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Lavina
 */
public class ManageVitalSignsJPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form VitalSignManagerJJPanel
     */
    private PersonDirectory personDirectory;
    private JPanel workAreaContainer;
    public int count;
    
    public ManageVitalSignsJPanel(JPanel userProcessContainer, PersonDirectory personDirectory) {
        initComponents();
        this.workAreaContainer = userProcessContainer;
        this.personDirectory= personDirectory;
        InputVerifier stringVerifier = new MyStringVerifier();
        searchBoxJTextField.setInputVerifier(stringVerifier);
        ArrayList<Person> personList = personDirectory.getPersonHistory();
        populatePatientTable(personList);
        populateVitalSigns(null);
        populateFilter();
        //populateCommunity(personList);
    }
    
    private void populateCommunity(ArrayList<Person> personList){
        DefaultTableModel model = (DefaultTableModel) tblComm.getModel();
        model.setRowCount(0);
        if(personList.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No Persons found. Please add Persons",
                    "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int num = Community.getItemCount();
        String temparr[] = new String[num];
        
        Object[] row = new Object[2];
        for(int i=0;i<num;i++){
        String temp = Community.getItemAt(i);
        int counttemp = 0;
        
        for (Person person : personList) {
            if(person.getCommunity().equals(temp)  && person.getPatient().getPatientID()!=null){
                
            ArrayList<VitalSign> vitalSignList = person.getPatient().getVitalSignHistory().getHistory();
            String status = "";
            if(!(vitalSignList.isEmpty())){
            for (VitalSign vitalSign : vitalSignList) {
		status = bloodPressureStatus(person.getAge(), vitalSign.getBloodPressure());
            }               
                if(status.equalsIgnoreCase("Abnormal"))
                counttemp++;
            }
        }    
        }
            row[0] = temp;
            row[1]= counttemp;
            model.addRow(row);
        }
              
        }

    private void populateFilter(){
        Community.removeAllItems();
        //Community.addItem("Null");
        
        String temparr[] = new String[count];
        for (int i = 0; i<count ;i++){
            temparr[i] = "";
        }
        
        int i = 0;
        for (Person person: personDirectory.getPersonHistory()){
            temparr[i] = person.getCommunity();
            i++;
        }
        for (i = 0; i < count; i++){
            for (int j = i+1 ; j< temparr.length; j ++){
            if(!"".equals(temparr[j]) && temparr[i].equals(temparr[j])){
                temparr[j] = "";
            }
            }
            if(!"".equals(temparr[i])){
                Community.addItem(temparr[i]);
            }
        }
    }
    
    private void populatePatientTable(ArrayList<Person> personList) {
        count = 0;
        DefaultTableModel model = (DefaultTableModel)viewPatientsJTable.getModel();
        model.setRowCount(0);
        if(personList.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No Persons found. Please add Persons",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (Person person : personList) {
            Object[] row = new Object[3];
            row[0] = person;
            row[1]= person.getAge();
            if(person.getPatient()!=null)
            {
                row[2] = person.getPatient().getPatientID();
            }
            else
            {
                row[2] = "Patient Not Created";
            }
            count++;
            model.addRow(row);
        }
    }
    
    private void populateVitalSigns(Person person) {
        
        DefaultTableModel model = (DefaultTableModel) viewVitalSignsJTable.getModel();
        model.setRowCount(0);
        if (person != null) {
            int patientAge = person.getAge();
            ArrayList<VitalSign> vitalSignList = person.getPatient().getVitalSignHistory().getHistory();
            
            if (vitalSignList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No vital signs found. Please"
                        + " add vital signs", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            for (VitalSign vitalSign : vitalSignList) {
                Object[] row = new Object[7];
                row[0] = person.getPatient().getPatientID();
                row[1] = person.getAge();
                row[2] = respitatoryStatus(patientAge, vitalSign.getRespiratoryRate());
                row[3] = heartRateStatus(patientAge, vitalSign.getHeartRate());
                row[4] = bloodPressureStatus(patientAge, vitalSign.getBloodPressure());
                row[5] = weightStatus(patientAge, vitalSign.getWeight());
                row[6] = vitalSign;
                model.addRow(row);
            }
        }
    }
    
    private String bloodPressureStatus(int age, int bloodPressure){
        String status = "Normal";
        
        if (age >= 1 && age <= 3) {
            if ((bloodPressure < 80 || bloodPressure > 110))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 4 && age <= 5) {
            if ((bloodPressure < 80 || bloodPressure > 110))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 6 && age <= 12) {
            if ((bloodPressure < 80 || bloodPressure > 120))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 13) {
            if ((bloodPressure < 110 || bloodPressure > 120))
            {
                status = "Abnormal";
            }
        }
        return status;
    }

    private String weightStatus(int age, int weight){
        String status = "Normal";
        
        if (age >= 1 && age <= 3) {
            if ((weight < 22 || weight > 31))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 4 && age <= 5) {
            if ((weight < 31 || weight > 40))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 6 && age <= 12) {
            if ((weight < 41 || weight > 92))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 13) {
            if ((weight < 110))
            {
                status = "Abnormal";
            }
        }
        return status;
    }
    
    private String respitatoryStatus(int age, int rate){
        String status = "Normal";
        
        if (age >= 1 && age <= 3) {
            if ((rate < 20 || rate > 30))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 4 && age <= 5) {
            if ((rate < 20 || rate > 30))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 6 && age <= 12) {
            if ((rate < 20 || rate > 30))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 13) {
            if ((rate < 12 || rate > 20))
            {
                status = "Abnormal";
            }
        }
        return status;
    }
    
    private String heartRateStatus(int age, int rate){
        String status = "Normal";
        
        if (age >= 1 && age <= 3) {
            if ((rate < 80 || rate > 130))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 4 && age <= 5) {
            if ((rate < 80 || rate > 120))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 6 && age <= 12) {
            if ((rate < 70 || rate > 110))
            {
                status = "Abnormal";
            }
        }
        
        if (age >= 13) {
            if ((rate < 55 || rate > 105))
            {
                status = "Abnormal";
            }
        }
        return status;
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayDetailsJButton = new javax.swing.JButton();
        addVitalSignsJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewPatientsJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewVitalSignsJTable = new javax.swing.JTable();
        refreshVitalSignsJButton = new javax.swing.JButton();
        searchBoxJTextField = new javax.swing.JTextField();
        searchPatientJButton = new javax.swing.JButton();
        refreshPatientsJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Community = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblComm = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));

        displayDetailsJButton.setBackground(new java.awt.Color(102, 102, 102));
        displayDetailsJButton.setText("DISPLAY");
        displayDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayDetailsJButtonActionPerformed(evt);
            }
        });

        addVitalSignsJButton.setBackground(new java.awt.Color(102, 102, 102));
        addVitalSignsJButton.setText("ADD VITAL");
        addVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVitalSignsJButtonActionPerformed(evt);
            }
        });

        viewPatientsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient Name", "Age", "Patient ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewPatientsJTable);

        backJButton.setBackground(new java.awt.Color(102, 102, 102));
        backJButton.setText("<< BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        viewVitalSignsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pateint ID", "Patient Age", "Respiratory Track", "Heart Rate", "Blood Pressure", "Weight "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(viewVitalSignsJTable);
        if (viewVitalSignsJTable.getColumnModel().getColumnCount() > 0) {
            viewVitalSignsJTable.getColumnModel().getColumn(0).setResizable(false);
            viewVitalSignsJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        refreshVitalSignsJButton.setBackground(new java.awt.Color(102, 102, 102));
        refreshVitalSignsJButton.setText("ABNORMAL PERSON IN COMMUNITY");
        refreshVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshVitalSignsJButtonActionPerformed(evt);
            }
        });

        searchPatientJButton.setBackground(new java.awt.Color(102, 102, 102));
        searchPatientJButton.setText("SEARCH");
        searchPatientJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatientJButtonActionPerformed(evt);
            }
        });

        refreshPatientsJButton.setBackground(new java.awt.Color(102, 102, 102));
        refreshPatientsJButton.setText("REFRESH");
        refreshPatientsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshPatientsJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        Community.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Community.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommunityActionPerformed(evt);
            }
        });

        tblComm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Community", "No of Abnormal Persons"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblComm);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Communities");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(backJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(searchPatientJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addVitalSignsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchBoxJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(refreshPatientsJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayDetailsJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshVitalSignsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(Community, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addVitalSignsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(displayDetailsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchPatientJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBoxJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshPatientsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Community, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(refreshVitalSignsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        workAreaContainer.remove(this);
        CardLayout layout = (CardLayout) workAreaContainer.getLayout();
        layout.previous(workAreaContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = viewPatientsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person = (Person) viewPatientsJTable.getValueAt(selectedRow, 0);
        Patient patient= person.getPatient();
        if(patient!=null)
        {
            CreateVitalSignJPanel cvsJPanel = new CreateVitalSignJPanel(workAreaContainer, patient);
            workAreaContainer.add("cvsJPanel", cvsJPanel);
            CardLayout layout = (CardLayout) workAreaContainer.getLayout();
            layout.next(workAreaContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create"
                    + " Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addVitalSignsJButtonActionPerformed

    private void displayDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayDetailsJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = viewPatientsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person = (Person) viewPatientsJTable.getValueAt(selectedRow, 0);
        Patient patient= person.getPatient();
        if(patient!=null)
        {
            populateVitalSigns(person);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create "
                    + "Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_displayDetailsJButtonActionPerformed

    private void refreshVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
        refreshVialSigns(this.personDirectory);
    }//GEN-LAST:event_refreshVitalSignsJButtonActionPerformed

    private void searchPatientJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatientJButtonActionPerformed
        // TODO add your handling code here:
        String key = searchBoxJTextField.getText().trim();
        if(key.length()==0)
        {
            JOptionPane.showMessageDialog(this, "Please enter key.","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*Storing searched patients in an array to display in table.*/
        ArrayList<Person> searchPatients = personDirectory.searchPatient(key);
        populatePatientTable(searchPatients);
    }//GEN-LAST:event_searchPatientJButtonActionPerformed

    private void refreshPatientsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshPatientsJButtonActionPerformed
        // TODO add your handling code here:
        searchBoxJTextField.setText("");
        populatePatientTable(personDirectory.getPersonHistory());
    }//GEN-LAST:event_refreshPatientsJButtonActionPerformed

    private void CommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommunityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CommunityActionPerformed
    
    private void refreshVialSigns(PersonDirectory personDirectory ) {
        
        populateCommunity(personDirectory.getPersonHistory());
        /*
        int selectedRow = viewPatientsJTable.getSelectedRow();
        if (selectedRow < 0) {
            populateVitalSigns(null);
        } else {
            Person person = (Person) viewPatientsJTable.getValueAt(selectedRow, 0);
            Patient patient= person.getPatient();
            if(patient!=null)
            {
                populateVitalSigns(person);
            }
            else
            {
                populateVitalSigns(null);
            }
        }*/
    }
    
    private void createChart()
    {
        DefaultCategoryDataset vitalSignDataset=new DefaultCategoryDataset();
        int selectedRow = viewPatientsJTable.getSelectedRow();
        Person person = (Person) viewPatientsJTable.getValueAt(selectedRow, 0);
        Patient patient= person.getPatient();
        if(patient==null)
        {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create "
                    + "Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<VitalSign> vitalSignList = patient.getVitalSignHistory().getHistory();
        /*At least 2 vital sign records needed to show chart */
        if (vitalSignList.isEmpty() || vitalSignList.size() == 1) {
            JOptionPane.showMessageDialog(this, "No vital signs or only one vital "
                    + "sign found. At least 2 vital sign records needed to show chart!", 
                    "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (VitalSign vitalSign : vitalSignList) {
            vitalSignDataset.addValue(vitalSign.getRespiratoryRate(),"RR", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getHeartRate(),"HR", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getBloodPressure(),"BP", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getWeight(),"WT", vitalSign.getTimestamp());
        }
        
        JFreeChart vitalSignChart= ChartFactory.createBarChart3D("Vital Sign Chart", 
                "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
        vitalSignChart.setBackgroundPaint(Color.white);
        CategoryPlot vitalSignChartPlot = vitalSignChart.getCategoryPlot();
        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);
        
        CategoryAxis vitalSignDomainAxis = vitalSignChartPlot.getDomainAxis();
        vitalSignDomainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis vitalSignRangeAxis = (NumberAxis) vitalSignChartPlot.getRangeAxis();
        vitalSignRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartFrame chartFrame = new ChartFrame("Chart", vitalSignChart);
        chartFrame.setVisible(true);
        chartFrame.setSize(500, 500);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Community;
    private javax.swing.JButton addVitalSignsJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton displayDetailsJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refreshPatientsJButton;
    private javax.swing.JButton refreshVitalSignsJButton;
    private javax.swing.JTextField searchBoxJTextField;
    private javax.swing.JButton searchPatientJButton;
    private javax.swing.JTable tblComm;
    private javax.swing.JTable viewPatientsJTable;
    private javax.swing.JTable viewVitalSignsJTable;
    // End of variables declaration//GEN-END:variables
}
