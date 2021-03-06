/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInteface.Person;

import business.Person;
import business.PersonDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lavina
 */
public class ManagePersonsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePersonsJPanel
     */
    private PersonDirectory personDirectory;
    private JPanel workAreaContainer;
    public ManagePersonsJPanel(JPanel userProcessContainer,PersonDirectory personDirectory) {
        initComponents();
        this.personDirectory= personDirectory;
        this.workAreaContainer= userProcessContainer;
    }
    
    private void populatePersonsTable(ArrayList<Person> personsList) {
        DefaultTableModel model = (DefaultTableModel) viewPersonsJTable.getModel();
        model.setRowCount(0);
        if(personsList.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No Person's found. Please add person Details"
                    + " Person's", "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (Person person : personsList) {
            Object[] row = new Object[6];
            row[0] = person;
            row[1]= person.getAge();
            row[2]= person.getHouseNo();
            row[3]= person.getCommunity();
            row[4]= person.getCity();
            if(person.getPatient()!=null)
            {
                row[5] = person.getPatient().getPatientID();
            }
            else
            {
                row[5] = "Patient Not Created";
            }
            model.addRow(row);
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

        searchPersonJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewPersonsJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        editPersonJButton = new javax.swing.JButton();
        viewPersonJButton = new javax.swing.JButton();
        deletePersonJButton = new javax.swing.JButton();
        searchBoxJTextField = new javax.swing.JTextField();
        CREATE = new javax.swing.JButton();

        searchPersonJButton.setBackground(new java.awt.Color(102, 102, 102));
        searchPersonJButton.setText("SEARCH");
        searchPersonJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPersonJButtonActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(102, 102, 102));
        backJButton.setText("<<BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setBackground(new java.awt.Color(102, 102, 102));
        refreshJButton.setText("REFRESH");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        viewPersonsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person Name", "Age", "House No", "Community", "City", "Patient ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewPersonsJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Person Information");

        editPersonJButton.setBackground(new java.awt.Color(102, 102, 102));
        editPersonJButton.setText("EDIT");
        editPersonJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPersonJButtonActionPerformed(evt);
            }
        });

        viewPersonJButton.setBackground(new java.awt.Color(102, 102, 102));
        viewPersonJButton.setText("VIEW");
        viewPersonJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPersonJButtonActionPerformed(evt);
            }
        });

        deletePersonJButton.setBackground(new java.awt.Color(102, 102, 102));
        deletePersonJButton.setText("DELETE");
        deletePersonJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePersonJButtonActionPerformed(evt);
            }
        });

        searchBoxJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxJTextFieldActionPerformed(evt);
            }
        });

        CREATE.setBackground(new java.awt.Color(102, 102, 102));
        CREATE.setText("CREATE");
        CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchPersonJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(CREATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchBoxJTextField)
                            .addComponent(viewPersonJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(editPersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(deletePersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletePersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchPersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBoxJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchPersonJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPersonJButtonActionPerformed
        // TODO add your handling code here:
        String key= searchBoxJTextField.getText();
        if(key.length()==0)
        {
            JOptionPane.showMessageDialog(this, "Please enter a value.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<Person> searchPersons;
        searchPersons=personDirectory.searchPerson(key);
        populatePersonsTable(searchPersons);
    }//GEN-LAST:event_searchPersonJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        workAreaContainer.remove(this);
        CardLayout card = (CardLayout) workAreaContainer.getLayout();
        card.previous(workAreaContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        searchBoxJTextField.setText("");
        populatePersonsTable(personDirectory.getPersonHistory());
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void editPersonJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPersonJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow= viewPersonsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person=(Person) viewPersonsJTable.getValueAt(selectedRow, 0);
        /*pass workAreaContainer and Patient*/
        ViewUpdatePersonDetailsJPanel vupersondJPanel= 
                new ViewUpdatePersonDetailsJPanel(workAreaContainer, person,Boolean.TRUE);
        workAreaContainer.add("vupersondJPanel", vupersondJPanel);
        CardLayout card =(CardLayout) workAreaContainer.getLayout();
        card.next(workAreaContainer);
    }//GEN-LAST:event_editPersonJButtonActionPerformed

    private void viewPersonJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPersonJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow= viewPersonsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Person person = (Person) viewPersonsJTable.getValueAt(selectedRow, 0);
        /*pass workAreaContainer and Patient*/
        ViewUpdatePersonDetailsJPanel vupersondJPanel= 
                new ViewUpdatePersonDetailsJPanel(workAreaContainer, person,Boolean.FALSE);
        workAreaContainer.add("vupersondJPanel", vupersondJPanel);
        CardLayout card =(CardLayout) workAreaContainer.getLayout();
        card.next(workAreaContainer);
    }//GEN-LAST:event_viewPersonJButtonActionPerformed

    private void deletePersonJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePersonJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow= viewPersonsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person=(Person) viewPersonsJTable.getValueAt(selectedRow, 0);
        int flag= JOptionPane.showConfirmDialog(this, "Are you sure want to remove this record?",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(flag==0)
        {
            personDirectory.deletePerson(person);
            populatePersonsTable(personDirectory.getPersonHistory());
        }
    }//GEN-LAST:event_deletePersonJButtonActionPerformed

    private void CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATEActionPerformed

        CreatePersonJPanel cpJPanel= 
                new CreatePersonJPanel(workAreaContainer, personDirectory);
        workAreaContainer.add("cpJPanel", cpJPanel);
        CardLayout layout=(CardLayout) workAreaContainer.getLayout();
        layout.next(workAreaContainer);
    }//GEN-LAST:event_CREATEActionPerformed

    private void searchBoxJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxJTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CREATE;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deletePersonJButton;
    private javax.swing.JButton editPersonJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTextField searchBoxJTextField;
    private javax.swing.JButton searchPersonJButton;
    private javax.swing.JButton viewPersonJButton;
    private javax.swing.JTable viewPersonsJTable;
    // End of variables declaration//GEN-END:variables
}
