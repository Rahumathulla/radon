/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.GstDAO;
import com.essar.dao.ClassMasterDAO;
import com.essar.pojos.GST;
import com.essar.utils.TableMouseListener;
import com.essar.pojos.ClassMaster;
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
public class GSTForm extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ClassMaster
     */
    long gstId=0;
    DefaultTableModel gstModel = null;
    public GSTForm() {
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
        mnuCategory = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mitDelete = new javax.swing.JMenuItem();
        mitEdit = new javax.swing.JMenuItem();
        pnlGstSettings = new javax.swing.JPanel();
        lblProductCategoryName = new javax.swing.JLabel();
        lblProductCategoryCode1 = new javax.swing.JLabel();
        txtGST = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        panGst = new javax.swing.JScrollPane();
        tblGst = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblProductCategoryCode2 = new javax.swing.JLabel();
        txtSGST = new javax.swing.JTextField();
        lblProductCategoryCode3 = new javax.swing.JLabel();
        txtCGST = new javax.swing.JTextField();

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
        setTitle("GST Configuration");
        setName("frmProductCategory"); // NOI18N

        lblProductCategoryName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProductCategoryName.setText("Description");

        lblProductCategoryCode1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProductCategoryCode1.setText("GST %");

        txtGST.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGST.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGSTFocusLost(evt);
            }
        });
        txtGST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGSTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGSTKeyReleased(evt);
            }
        });

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

        tblGst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GST %", "SGST %", "CGST %", "Description", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panGst.setViewportView(tblGst);

        txtDescription.setColumns(16);
        txtDescription.setRows(3);
        txtDescription.setTabSize(2);
        jScrollPane3.setViewportView(txtDescription);

        lblProductCategoryCode2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProductCategoryCode2.setText("SGST %");

        txtSGST.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSGST.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSGSTFocusLost(evt);
            }
        });
        txtSGST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSGSTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSGSTKeyTyped(evt);
            }
        });

        lblProductCategoryCode3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProductCategoryCode3.setText("CGST %");

        txtCGST.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCGST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCGSTKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlGstSettingsLayout = new javax.swing.GroupLayout(pnlGstSettings);
        pnlGstSettings.setLayout(pnlGstSettingsLayout);
        pnlGstSettingsLayout.setHorizontalGroup(
            pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGstSettingsLayout.createSequentialGroup()
                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panGst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlGstSettingsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlGstSettingsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGstSettingsLayout.createSequentialGroup()
                                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlGstSettingsLayout.createSequentialGroup()
                                        .addComponent(lblProductCategoryCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSGST, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlGstSettingsLayout.createSequentialGroup()
                                        .addComponent(lblProductCategoryCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCGST, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlGstSettingsLayout.createSequentialGroup()
                                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblProductCategoryCode1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProductCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGST, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGstSettingsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(122, 122, 122))
        );
        pnlGstSettingsLayout.setVerticalGroup(
            pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGstSettingsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductCategoryCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductCategoryCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSGST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductCategoryCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCGST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panGst, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(pnlGstSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGstSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            txtGST.requestFocus();
        }else{
            //Implement Save Logic
            if(validateForm()){                               
                if(gstId>0)
                    updateGSTForm();
                else
                    saveGSTForm();
                initializeForm();
                
                // Bug Fix for row doubling during table record deletion
                //this.dispose();
                //GSTForm gSTForm = new GSTForm();
                //gSTForm.setVisible(true);
            }            
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtGSTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGSTKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()== evt.VK_ENTER || evt.getKeyCode()== evt.VK_TAB){
            txtDescription.requestFocus();
        } else{
            calculateGstSplitLogic();
        }
            
            
    }//GEN-LAST:event_txtGSTKeyReleased

    private void txtSGSTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSGSTFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSGSTFocusLost

    private void txtGSTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGSTFocusLost
        // TODO add your handling code here:
        calculateGstSplitLogic();
    }//GEN-LAST:event_txtGSTFocusLost

    private void txtGSTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGSTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGSTKeyPressed

    private void txtSGSTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSGSTKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSGSTKeyTyped

    private void txtCGSTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCGSTKeyTyped
        // TODO add your handling code here:
        if(null != txtCGST.getText() && !"".equals(txtCGST.getText())){
            txtSGST.setText(Double.parseDouble(txtGST.getText()) - Double.parseDouble(txtCGST.getText()) +"");
        }
    }//GEN-LAST:event_txtCGSTKeyTyped

    private void txtSGSTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSGSTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSGSTKeyPressed

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
            java.util.logging.Logger.getLogger(GSTForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GSTForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GSTForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GSTForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GSTForm().setVisible(true);
            }
        });
    }
    
    /*tblGst.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            if (me.getClickCount() == 2) {     // to detect doble click events
               JTable target = (JTable)me.getSource();
               int row = target.getSelectedRow(); // select a row
               int column = target.getSelectedColumn(); // select a column
              JOptionPane.showMessageDialog(null, table.getValueAt(row, column)); // get the value of a row and column.
            }
         }
      });*/
    
    public void calculateGstSplitLogic(){
        try{
            if(Double.parseDouble(txtGST.getText()) > 100){
                  JOptionPane.showMessageDialog(null, "Value - "+txtGST.getText() +" cannot be greater than 100.");
                  txtGST.requestFocus();

              }else{
                  txtSGST.setText((Double.parseDouble(txtGST.getText()))/2 +"");
                  txtCGST.setText((Double.parseDouble(txtGST.getText()))/2 +"");
                  //txtDescription.requestFocus();
              }
        }
        catch(NumberFormatException nfe){
            System.out.println("Invalid Number ("+nfe.getMessage()+") .");
        }
    }
    public void initializeForm(){
        DefaultTableModel model = (DefaultTableModel) tblGst.getModel();
        model.setRowCount(0);
        
        btnSave.setText("Add");
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png")));
        btnSave.requestFocus();
        txtGST.setText("");
        txtCGST.setText("");
        txtSGST.setText("");
        txtDescription.setText("");
     

        enableFormElements(false);
        GstDAO gstDAO = new GstDAO();
        renderDataIntoTable(gstDAO.retrieveAll());
        mnuCategory = new JPopupMenu();
        mitDelete = new JMenuItem("Delete");
        mitDelete.addActionListener(this);
        
        mitEdit = new JMenuItem("Edit");
        mitEdit.addActionListener(this);
        
        mnuCategory.add(mitDelete);
        mnuCategory.add(mitEdit);
         // sets the popup menu for the table
        tblGst.setComponentPopupMenu(mnuCategory);      
        tblGst.addMouseListener(new TableMouseListener(tblGst));
        
        TableColumn idColumn1 = tblGst.getColumnModel().getColumn(tblGst.getColumnCount()-1);
        idColumn1.setPreferredWidth(0);
        idColumn1.setMinWidth(0);
        idColumn1.setMaxWidth(0);
        gstId = 0;
    }
    
    public void enableFormElements(boolean flag){
        txtGST.setEnabled(flag);
        txtCGST.setEnabled(flag);
        txtSGST.setEnabled(flag);
        txtDescription.setEnabled(flag);
    }
    public boolean validateForm(){
        //btnSave.setText("Add");
        //btnSave.requestFocus();
        if(null == txtGST.getText()){
            JOptionPane.showMessageDialog(null, "GST Percentage value - "+txtGST.getText() +" is not valid.");
            return false;
        }
        
        if(null == txtSGST.getText()){
            JOptionPane.showMessageDialog(null, "SGST Percentage value - "+txtSGST.getText() +" is not valid.");
            return false;
        }
        
        if(null == txtCGST.getText()){
            JOptionPane.showMessageDialog(null, "CGST Percentage value - "+txtCGST.getText() +" is not valid.");
            return false;
        }
        
        if(Double.parseDouble(txtSGST.getText()) + Double.parseDouble(txtCGST.getText()) != Double.parseDouble(txtGST.getText())){
            JOptionPane.showMessageDialog(null, "Sum of SGST and CGST should be equal to "+Double.parseDouble(txtCGST.getText()) + ".");
            return false;
        }
       /* if(null == txtDescription.getText() || !(txtProductCategoryName.getText().matches("\\w+"))){
            JOptionPane.showMessageDialog(null, "The product category name "+txtProductCategoryName.getText() +" is not valid.");
            return false;
        }*/
        //txtProductCategoryName.setText("");
        return true;
    }
    
    public void saveGSTForm(){ 
        GST gst = new GST();
        gst.setGstValue(Double.parseDouble(txtGST.getText()));
        gst.setSgst(Double.parseDouble(txtSGST.getText()));
        gst.setCgst(Double.parseDouble(txtCGST.getText()));
        gst.setDescription(txtDescription.getText());       
        GstDAO gstDAO = new GstDAO();
        gstDAO.insertIntoDB(gst);        
    }
    
    public void updateGSTForm(){

        GST gst = new GST();
        gst.setGstId(gstId);
        gst.setGstValue(Double.parseDouble(txtGST.getText()));
        gst.setSgst(Double.parseDouble(txtSGST.getText()));
        gst.setCgst(Double.parseDouble(txtCGST.getText()));
        gst.setDescription(txtDescription.getText());       
        GstDAO gstDAO = new GstDAO();
        gstDAO.updateRecord(gst);
        
    }
    
    public void renderDataIntoTable(List<GST> gstList){
        
        gstModel = (DefaultTableModel) tblGst.getModel();
        //System.out.println("-----"+productCategoryList.size());
        for(int i=0;i<gstList.size();i++){
            gstModel.addRow(new Object[]{gstList.get(i).getGstValue(),gstList.get(i).getSgst(), gstList.get(i).getCgst(), gstList.get(i).getDescription(), gstList.get(i).getGstId() });
        //model.
        }
        tblGst.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    syncDataFromViewToTable();
                }
            }
        });
        
    }
    
    public void syncDataFromViewToTable(){
                GST gst = new GST();
                gstId = Integer.parseInt(tblGst.getModel().getValueAt(tblGst.getSelectedRow(),tblGst.getColumnCount()-1).toString());
                GstDAO gstDAO = new GstDAO();
                gst = gstDAO.retrieveById(gstId);
                txtGST.setText(gst.getGstValue()+"");
                txtSGST.setText(gst.getSgst()+"");
                txtCGST.setText(gst.getCgst()+"");
                txtDescription.setText(gst.getDescription());
                enableFormElements(true);
                btnSave.setText("Update");
                btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png")));
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblProductCategoryCode1;
    private javax.swing.JLabel lblProductCategoryCode2;
    private javax.swing.JLabel lblProductCategoryCode3;
    private javax.swing.JLabel lblProductCategoryName;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitEdit;
    private javax.swing.JPopupMenu mnuCategory;
    private javax.swing.JScrollPane panGst;
    private javax.swing.JPanel pnlGstSettings;
    private javax.swing.JTable tblGst;
    private javax.swing.JTextField txtCGST;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtGST;
    private javax.swing.JTextField txtSGST;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == mitDelete) {
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                long id = Long.parseLong(tblGst.getModel().getValueAt(tblGst.getSelectedRow(),tblGst.getColumnCount()-1).toString());
                GstDAO gstDAO = new GstDAO();
                gstDAO.deleteRecordById(id);
                GenericUtils.removeRowFromJTable(tblGst, gstModel);
                
                //tblGst.getModel().removeRow(tblGst.getSelectedRow());
                //tblGst.remove(3);
                //tblGst.revalidate();
                //tblGst.repaint();
                // Bug Fix for row doubling during table record deletion
                /*this.dispose();
                GSTForm gSTForm = new GSTForm();
                gSTForm.setVisible(true);*/
                
                //initializeForm();
                
                
            }
            
            if (menu == mitEdit) {
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                syncDataFromViewToTable();
                //initializeForm();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }
     
     
}
