/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.SubjectDAO;
import com.essar.utils.TableMouseListener;
import com.essar.pojos.Subject;
import com.essar.utils.GenericUtils;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author rahumathulla
 */
public class SubjectForm extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ProductCategory
     */
    int subjectId=0;
    DefaultTableModel subjectModel = null;
    public SubjectForm() {
        initComponents();
        initializeForm();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tienda.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        mnuSubject = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mitDelete = new javax.swing.JMenuItem();
        mitEdit = new javax.swing.JMenuItem();
        pnlSubject = new javax.swing.JPanel();
        lblSubject = new javax.swing.JLabel();
        txtSubjectName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        spnSubjectDetails = new javax.swing.JScrollPane();
        tblSubject = new javax.swing.JTable();
        lblCount = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        lblComments = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        mitDelete.setText("jMenuItem1");

        mitEdit.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Subject Details");
        setIconImage(getIconImage());
        setName("frmProductCategory"); // NOI18N

        lblSubject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSubject.setText("Subject Name");

        txtSubjectName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        btnSave.setMnemonic('S');
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tblSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Name", "Comments", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spnSubjectDetails.setViewportView(tblSubject);

        lblCount.setForeground(new java.awt.Color(102, 102, 255));
        lblCount.setText("Count:");

        txtComments.setColumns(10);
        txtComments.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtComments.setRows(3);
        txtComments.setTabSize(3);
        jScrollPane4.setViewportView(txtComments);

        lblComments.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblComments.setText("Comments");

        javax.swing.GroupLayout pnlSubjectLayout = new javax.swing.GroupLayout(pnlSubject);
        pnlSubject.setLayout(pnlSubjectLayout);
        pnlSubjectLayout.setHorizontalGroup(
            pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubjectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubjectLayout.createSequentialGroup()
                        .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlSubjectLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))
                            .addGroup(pnlSubjectLayout.createSequentialGroup()
                                .addComponent(lblComments, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlSubjectLayout.createSequentialGroup()
                        .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSubjectLayout.createSequentialGroup()
                                .addComponent(lblSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spnSubjectDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        pnlSubjectLayout.setVerticalGroup(
            pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubjectLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubject))
                .addGap(18, 18, 18)
                .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComments))
                .addGap(18, 18, 18)
                .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnSubjectDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(btnSave.getText().equalsIgnoreCase("add")){
            btnSave.setText("Save");
            btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png")));
            enableFormElements(true);
        }else{
            //Implement Save Logic
            if(validateForm()){
                if(subjectId>0)
                    updateSubjectForm();
                else
                    saveSubjectForm();
                initializeForm();               
                
            }           
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectForm().setVisible(true);
            }
        });
    }
    
    public void initializeForm(){
        subjectId=0;
        DefaultTableModel model = (DefaultTableModel) tblSubject.getModel();
        model.setRowCount(0);
        
        btnSave.setText("Add");
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png")));
        btnSave.requestFocus();
        txtSubjectName.setText("");
        txtComments.setText("");
        
        enableFormElements(false);
        SubjectDAO subjectDAO = new SubjectDAO();
        renderDataIntoTable(subjectDAO.retrieveAll());
        mnuSubject = new JPopupMenu();
        
        mitEdit = new JMenuItem("Edit");
        mitEdit.addActionListener(this);
        
        mitDelete = new JMenuItem("Delete");
        mitDelete.addActionListener(this);
        
        mnuSubject.add(mitEdit);
        mnuSubject.add(mitDelete);
       
         // sets the popup menu for the table
        tblSubject.setComponentPopupMenu(mnuSubject);      
        tblSubject.addMouseListener(new TableMouseListener(tblSubject));
        
        TableColumn idColumn1 = tblSubject.getColumnModel().getColumn(tblSubject.getColumnCount()-1);
        idColumn1.setPreferredWidth(0);
        idColumn1.setMinWidth(0);
        idColumn1.setMaxWidth(0);
        
        TableColumn addressColumn = tblSubject.getColumnModel().getColumn(tblSubject.getColumnCount()-2);
        addressColumn.setPreferredWidth(100);
        addressColumn.setMinWidth(100);
        addressColumn.setMaxWidth(100);
        
        TableColumn subjectNameColumn = tblSubject.getColumnModel().getColumn(1);
        subjectNameColumn.setPreferredWidth(100);
        subjectNameColumn.setMinWidth(100);
        subjectNameColumn.setMaxWidth(100);
   
    }
    
    public void enableFormElements(boolean flag){
        txtSubjectName.setEnabled(flag);
        txtComments.setEnabled(flag);
    }
    public boolean validateForm(){
        //btnSave.setText("Add");
        //btnSave.requestFocus();

        if(null == txtSubjectName.getText()){
            JOptionPane.showMessageDialog(null, "Subject name "+txtSubjectName.getText() +" is not valid.");
            return false;
        }
        //txtProductCategoryName.setText("");
        return true;
    }
    
    public void saveSubjectForm(){
 
        Subject subject = new Subject();
        subject.setSubjectName(txtSubjectName.getText());
        subject.setComments(txtComments.getText());
        SubjectDAO subjectDAO = new SubjectDAO();
        subjectDAO.insertIntoDB(subject);
        
    }
    
    public void updateSubjectForm(){
 
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        subject.setSubjectName(txtSubjectName.getText());
        subject.setComments(txtComments.getText());
        SubjectDAO subjectDAO = new SubjectDAO();
        subjectDAO.updateRecord(subject);
        
    }
    public void syncDataFromViewToTable(){
        Subject subject = null;
        System.out.println("--------INSIDE Edit-"+tblSubject.getModel().getValueAt(tblSubject.getSelectedRow(),0));
        subjectId = Integer.parseInt(tblSubject.getModel().getValueAt(tblSubject.getSelectedRow(),tblSubject.getColumnCount()-1).toString());
        SubjectDAO subjectDAO = new SubjectDAO();
        subject = subjectDAO.retrieveById(subjectId);
        System.out.println("--"+subject.getSubjectName());
        txtSubjectName.setText(subject.getSubjectName());
        txtComments.setText(subject.getComments());
        enableFormElements(true);
        btnSave.setText("Update");
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png")));
    }
    public void renderDataIntoTable(List<Subject> subjectList){
        
        subjectModel = (DefaultTableModel) tblSubject.getModel();
        System.out.println("-----Count:"+subjectList.size());
        lblCount.setText("Count : "+subjectList.size());
        for(int i=0;i<subjectList.size();i++){
        subjectModel.addRow(new Object[]{subjectList.get(i).getSubjectName(), subjectList.get(i).getComments(), subjectList.get(i).getSubjectId()});
        //model.
    }
        
        tblSubject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    syncDataFromViewToTable();
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitEdit;
    private javax.swing.JPopupMenu mnuSubject;
    private javax.swing.JPanel pnlSubject;
    private javax.swing.JScrollPane spnSubjectDetails;
    private javax.swing.JTable tblSubject;
    private javax.swing.JTextArea txtComments;
    private javax.swing.JTextField txtSubjectName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == mitDelete) {
                //int rowIndex = tblSubject.getSelectedRow();
                System.out.println("--------INSIDE DELETE-"+tblSubject.getModel().getValueAt(tblSubject.getSelectedRow(),0));
                long subjectId = Long.parseLong(tblSubject.getModel().getValueAt(tblSubject.getSelectedRow(),tblSubject.getColumnCount()-1).toString());
                SubjectDAO subjectDAO = new SubjectDAO();
                subjectDAO.deleteRecordById(subjectId);
                // Bug Fix for row doubling during table record deletion
                GenericUtils.removeRowFromJTable(tblSubject, subjectModel);
            } 
            
            if (menu == mitEdit) {
                //int rowIndex = tblSubject.getSelectedRow();
                syncDataFromViewToTable();                
            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}

