/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.SupplierDAO;
import com.essar.pojos.Supplier;
import com.essar.utils.QueryStrings;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author rahumathulla
 */
public class Vp_PurchaseFind extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Stock
     */
    long stockIdEdit=0;
    boolean supplierSelected = false;
    Supplier supplier =null;
    DecimalFormat df = new DecimalFormat("####.##");
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Vp_PurchaseFind() {
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

        grpBillType = new javax.swing.ButtonGroup();
        pnlStockEntry = new javax.swing.JPanel();
        lblBillNumber = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        txtBillNumber = new javax.swing.JTextField();
        lblDateRange = new javax.swing.JLabel();
        lblPaymentType = new javax.swing.JLabel();
        dtpFromDate = new com.toedter.calendar.JDateChooser();
        dtpToDate = new com.toedter.calendar.JDateChooser();
        cmbSupplierName = new javax.swing.JComboBox();
        cmbPaymentType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Purchase");

        pnlStockEntry.setBorder(javax.swing.BorderFactory.createTitledBorder("Search by Options"));

        lblBillNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBillNumber.setText("Bill Number");

        lblCustomerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCustomerName.setText("Supplier Name");

        txtBillNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBillNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillNumberActionPerformed(evt);
            }
        });
        txtBillNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillNumberKeyPressed(evt);
            }
        });

        lblDateRange.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDateRange.setText("Date Range (From)");

        lblPaymentType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPaymentType.setText("Payment Type");

        dtpFromDate.setDateFormatString("dd/MM/yyyy");

        dtpToDate.setDateFormatString("dd/MM/yyyy");

        cmbSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierNameActionPerformed(evt);
            }
        });

        cmbPaymentType.setMaximumRowCount(4);
        cmbPaymentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Cash", "Credit" }));
        cmbPaymentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentTypeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("To");

        javax.swing.GroupLayout pnlStockEntryLayout = new javax.swing.GroupLayout(pnlStockEntry);
        pnlStockEntry.setLayout(pnlStockEntryLayout);
        pnlStockEntryLayout.setHorizontalGroup(
            pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbSupplierName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                                .addComponent(dtpFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtpToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addComponent(lblBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlStockEntryLayout.setVerticalGroup(
            pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtpFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtpToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.setMnemonic('e');
        btnSearch.setText("Go");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStockEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnlStockEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        System.out.println("Supplier Selection Flag -"+supplierSelected + "Tye :"+cmbPaymentType.getSelectedIndex());
         String fromDate = simpleDateFormat.format(dtpFromDate.getDate());
         String toDate = simpleDateFormat.format(dtpToDate.getDate());
        String selectClause = "SELECT p.purchase_id"
                    + ", sup.supplier_name"
                    + ", p.bill_number"
                    + ", SUM(d.quantity)"
                    + ", p.bill_amount"
                    + ", p.discount"
                    + ", p.payable_amount"
                    + ", p.purchase_date"
                    + ", p.status  "
                    + " from purchase p JOIN supplier sup ON p.supplier_id = sup.supplier_id"
                    + " JOIN purchase_details d ON p.purchase_id = d.purchase_id ";
                    
        if(null!= txtBillNumber.getText() && !("".equals(txtBillNumber.getText()))) { 
            System.out.println("Bill Present Logic");
            QueryStrings.viewPurchaseSql = selectClause + " WHERE p.bill_number ='"+txtBillNumber.getText()+"'";
            
        } if(cmbPaymentType.getSelectedIndex()==0){
                System.out.println("payment not selected Logic");
                if(supplierSelected)
                    QueryStrings.viewPurchaseSql = selectClause + " WHERE 1=1 AND p.supplier_id = "+supplier.getSupplierId(); 
                else
                   QueryStrings.viewPurchaseSql = selectClause + " WHERE 1=1 ";

        } if(cmbPaymentType.getSelectedIndex()!=0){
            System.out.println("Payment Selected Logic");
            if(cmbPaymentType.getSelectedIndex()==1){
                if(supplierSelected)
                    QueryStrings.viewPurchaseSql = selectClause + " WHERE p.status = 'Paid' AND p.supplier_id = "+supplier.getSupplierId(); 
                else
                    QueryStrings.viewPurchaseSql = selectClause + " WHERE p.status = 'Paid'";               
                    
            }
            else if(cmbPaymentType.getSelectedIndex()==2){
                if(supplierSelected)
                    QueryStrings.viewPurchaseSql = selectClause + " WHERE p.status = 'Credit' AND p.supplier_id = "+supplier.getSupplierId(); 
                else
                   QueryStrings.viewPurchaseSql = selectClause + " WHERE p.status = 'Credit'";

            }            
            //else
                //QueryStrings.viewPurchaseSql = selectClause + " ORDER BY purchase_date";
        } if(supplierSelected){
            System.out.println("Supplier Logic");
            QueryStrings.viewPurchaseSql = selectClause + " WHERE p.supplier_id = "+supplier.getSupplierId();
            //QueryStrings.viewPurchaseSql = selectClause + " ORDER BY p.purchase_date";
        }
            
            /*else if(null!= txtItemName.getText() && !("".equals(txtItemName.getText()))){
            QueryStrings.stockQuery = "SELECT * from stock where item_name like '%"+txtItemName.getText()+"%'" ;
        }*/else{
                QueryStrings.viewPurchaseSql = selectClause + " WHERE purchase_date BETWEEN "
                    + "'"+fromDate +" 00:00:00' AND '"+toDate+ " 23:59:59'" ;
        }
        QueryStrings.viewPurchaseSql += " group by purchase_id order by purchase_date ";
        System.out.println("Query :"+QueryStrings.viewPurchaseSql);
        System.out.println("--Date Choosen");

        System.out.println("===> FROM DATE: "+fromDate);
        System.out.println("===> TO DATE: "+toDate);
        //this.dispose();
        ViewWorkLog viewPurchase = new ViewWorkLog();
        //stockAlerts.setBounds(40, 40, 940, 500);
        viewPurchase.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtBillNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillNumberKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB || evt.getKeyCode() == KeyEvent.VK_ENTER){
            //txtItemName.requestFocus();
        }
    }//GEN-LAST:event_txtBillNumberKeyPressed

    private void txtBillNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillNumberActionPerformed

    private void cmbSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierNameActionPerformed
        // TODO add your handling code here:
        
        supplier = (Supplier) cmbSupplierName.getSelectedItem();
        if(supplier.getSupplierName().equalsIgnoreCase("customer") || supplier.getSupplierName().equalsIgnoreCase("new")
                || supplier.getSupplierName().equalsIgnoreCase("name")|| supplier.getSupplierName().equalsIgnoreCase("default")){
            supplierSelected = false;
        }else
            supplierSelected = true;
    }//GEN-LAST:event_cmbSupplierNameActionPerformed

    private void cmbPaymentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaymentTypeActionPerformed

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
            java.util.logging.Logger.getLogger(Vp_PurchaseFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vp_PurchaseFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vp_PurchaseFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vp_PurchaseFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Vp_PurchaseFind().setVisible(true);
            }
        });
    }
    
    public void initializeForm(){
        stockIdEdit =0;
        txtBillNumber.requestFocus();


        SupplierDAO supplierDAO = new SupplierDAO();
        renderSupplierDataIntoDropDown(supplierDAO.retrieveAll());
        dtpToDate.setDate(new Date());
        if(null==dtpFromDate.getDate()){
            //dtpFromDate.setDate(new Date());
            Calendar cal = Calendar.getInstance();
            System.out.println("Today : " + cal.getTime());
            cal.add(Calendar.DATE, -365);
           
            System.out.println("30 days ago: " + cal.getTime());
            dtpFromDate.setDate(cal.getTime());
            // Substract 30 days from the calendar
            //dtpFromDate.setDate(new Date(cal.add(Calendar.DATE, -30)));
        }        if(null==dtpToDate.getDate()){
            dtpToDate.setDate(new Date());
        }
    }
    
    public void enableFormElements(boolean flag){
        txtBillNumber.setEnabled(flag);
       
    }
    public boolean validateForm(){
        //btnSave.setText("Add");
        //btnSave.requestFocus();
        if(null == txtBillNumber.getText() || !(txtBillNumber.getText().matches("\\w+"))){
            JOptionPane.showMessageDialog(null, "Bill Number "+txtBillNumber.getText() +" is not valid.");
            txtBillNumber.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public void renderSupplierDataIntoDropDown(List<Supplier> supplierList){
        Supplier supplier = null;
        if(supplierList!= null){
            //cmbCustomerName.addItem("Select");
            for(int i=0; i<supplierList.size();i++){
                cmbSupplierName.addItem(supplierList.get(i));
            }
            cmbSupplierName.setSelectedIndex(0);
            supplier = (Supplier)cmbSupplierName.getSelectedItem();            
        }
    }
    
   
    @Override
    public void actionPerformed(ActionEvent event) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbPaymentType;
    private javax.swing.JComboBox cmbSupplierName;
    private com.toedter.calendar.JDateChooser dtpFromDate;
    private com.toedter.calendar.JDateChooser dtpToDate;
    private javax.swing.ButtonGroup grpBillType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDateRange;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JPanel pnlStockEntry;
    private javax.swing.JTextField txtBillNumber;
    // End of variables declaration//GEN-END:variables
}
