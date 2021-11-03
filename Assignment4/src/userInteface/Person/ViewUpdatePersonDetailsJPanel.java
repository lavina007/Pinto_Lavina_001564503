/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInteface.Person;

import business.MyNumericVerifier;
import business.MyStringVerifier;
import business.Person;
import java.awt.CardLayout;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lavina
 */
public class ViewUpdatePersonDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientDetailsJPanel
     */
    private Person person;
    private JPanel userProcessContainer;
    private Boolean isEdit = Boolean.FALSE;

    public ViewUpdatePersonDetailsJPanel(JPanel userProcessContainer, Person person, Boolean isEdit) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.person = person;
        this.isEdit = isEdit;
        addVerifiers();
        populatePatientDetails();
        modifyTextFields(this.isEdit);
    }

    private void addVerifiers() {
        InputVerifier integerVerifier = new MyNumericVerifier();
        personAgeJTextField.setInputVerifier(integerVerifier);
        InputVerifier stringVerifier = new MyStringVerifier();
        personNameJTextField.setInputVerifier(stringVerifier);
        CommunityjTextField2.setInputVerifier(stringVerifier);
        HouseNojTextField1.setInputVerifier(stringVerifier);
        CityJTextField.setInputVerifier(stringVerifier);
    }

    private void populatePatientDetails() {
        personNameJTextField.setText(person.getPersonName());
        personAgeJTextField.setText(String.valueOf(person.getAge()));
        CommunityjTextField2.setText(person.getCommunity());
        HouseNojTextField1.setText(person.getHouseNo());
        CityJTextField.setText(person.getCity());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgeJLabel = new javax.swing.JLabel();
        personNameJTextField = new javax.swing.JTextField();
        personAgeJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        patientNameJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        HouseNojTextField1 = new javax.swing.JTextField();
        CommunityjTextField2 = new javax.swing.JTextField();
        CityJTextField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));

        AgeJLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AgeJLabel.setText("Age");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient Information");

        patientNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        patientNameJLabel.setText("Patient Name");

        backJButton.setBackground(new java.awt.Color(102, 102, 102));
        backJButton.setText("<<BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        editJButton.setBackground(new java.awt.Color(102, 102, 102));
        editJButton.setText("EDIT");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        saveJButton.setBackground(new java.awt.Color(102, 102, 102));
        saveJButton.setText("SAVE");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("House No");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Community");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("City");

        HouseNojTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HouseNojTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AgeJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(patientNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(189, 189, 189)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(personAgeJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(personNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(HouseNojTextField1)
                            .addComponent(CommunityjTextField2)
                            .addComponent(CityJTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientNameJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personAgeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgeJLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(HouseNojTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(CommunityjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(427, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        // TODO add your handling code here:
        modifyTextFields(true);
    }//GEN-LAST:event_editJButtonActionPerformed

    private void modifyTextFields(Boolean isEdit) {
        if (isEdit) {
            personNameJTextField.setEnabled(true);
            personAgeJTextField.setEnabled(true);
            CommunityjTextField2.setEnabled(true);
            HouseNojTextField1.setEnabled(true);
            CityJTextField.setEnabled(true);
        } else {
            personNameJTextField.setEnabled(false);
            personAgeJTextField.setEnabled(false);
            CommunityjTextField2.setEnabled(false);
            HouseNojTextField1.setEnabled(false);
            CityJTextField.setEnabled(false);
        }
    }

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        // TODO add your handling code here:

        if (checkBlankInput()) {
            person.setAge(Integer.parseInt(personAgeJTextField.getText()));
            person.setPersonName(personNameJTextField.getText());
            person.setCommunity(CommunityjTextField2.getText());
            person.setHouseNo(HouseNojTextField1.getText());
            person.setCity(CityJTextField.getText());
            JOptionPane.showMessageDialog(this, "Person updated!!",
                    "Update", JOptionPane.INFORMATION_MESSAGE);
            modifyTextFields(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter correct values", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveJButtonActionPerformed
    private Boolean checkBlankInput() {
        if (personAgeJTextField.getText().length() == 0
                || personNameJTextField.getText().length() == 0
                || CommunityjTextField2.getText().length() == 0
                || HouseNojTextField1.getText().length() == 0
                || CityJTextField.getText().length() == 0
                ) {
            return false;
        } else {
            return true;
        }
    }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void HouseNojTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HouseNojTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HouseNojTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgeJLabel;
    private javax.swing.JTextField CityJTextField;
    private javax.swing.JTextField CommunityjTextField2;
    private javax.swing.JTextField HouseNojTextField1;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton editJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel patientNameJLabel;
    private javax.swing.JTextField personAgeJTextField;
    private javax.swing.JTextField personNameJTextField;
    private javax.swing.JButton saveJButton;
    // End of variables declaration//GEN-END:variables
}
