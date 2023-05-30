/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.GstDAO;
import com.essar.dao.SalesDAO;
import com.essar.pojos.GST;
import com.essar.pojos.Sales;
import com.essar.utils.TableMouseListener;
import com.essar.pojos.SalesView;
import com.essar.utils.ConnectionManager;
import com.essar.utils.GenericUtils;
import com.essar.utils.QueryStrings;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rahumathulla
 */
public class ViewReports extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ProductCategory
     */
    long salesBillNumber=0;
    DefaultTableModel salesModel = null;
    public ViewReports() {
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
        mnuTable = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mitDelete = new javax.swing.JMenuItem();
        mitView = new javax.swing.JMenuItem();
        btnViewAll = new javax.swing.JButton();
        pnlSalesView = new javax.swing.JPanel();
        btnSalesReport = new javax.swing.JButton();
        btnPurchaseReturnReport = new javax.swing.JButton();
        btnStockReport = new javax.swing.JButton();
        btnSupplierReport = new javax.swing.JButton();
        btnPurchaseReport = new javax.swing.JButton();
        btnStockAlertReport = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();

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

        mitView.setText("jMenuItem1");

        btnViewAll.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnViewAll.setText("View All");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setName("frmProductCategory"); // NOI18N
        getContentPane().setLayout(null);

        javax.swing.GroupLayout pnlSalesViewLayout = new javax.swing.GroupLayout(pnlSalesView);
        pnlSalesView.setLayout(pnlSalesViewLayout);
        pnlSalesViewLayout.setHorizontalGroup(
            pnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSalesViewLayout.setVerticalGroup(
            pnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pnlSalesView);
        pnlSalesView.setBounds(394, 268, 0, 0);

        btnSalesReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalesReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales_bw.png"))); // NOI18N
        btnSalesReport.setMnemonic('S');
        btnSalesReport.setText("Fees pending List");
        btnSalesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalesReport);
        btnSalesReport.setBounds(44, 36, 228, 50);

        btnPurchaseReturnReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPurchaseReturnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer_bw.png"))); // NOI18N
        btnPurchaseReturnReport.setMnemonic('m');
        btnPurchaseReturnReport.setText("Staff List");
        btnPurchaseReturnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseReturnReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnPurchaseReturnReport);
        btnPurchaseReturnReport.setBounds(290, 146, 216, 51);

        btnStockReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStockReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_bw.png"))); // NOI18N
        btnStockReport.setMnemonic('t');
        btnStockReport.setText("Miscellaneous Report");
        btnStockReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnStockReport);
        btnStockReport.setBounds(44, 92, 228, 48);

        btnSupplierReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier_bw.png"))); // NOI18N
        btnSupplierReport.setMnemonic('u');
        btnSupplierReport.setText("Student List");
        btnSupplierReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnSupplierReport);
        btnSupplierReport.setBounds(290, 92, 216, 48);

        btnPurchaseReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPurchaseReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/purchase_bw.png"))); // NOI18N
        btnPurchaseReport.setMnemonic('P');
        btnPurchaseReport.setText("Purchase Report");
        btnPurchaseReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnPurchaseReport);
        btnPurchaseReport.setBounds(290, 38, 216, 48);

        btnStockAlertReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStockAlertReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report_home4.png"))); // NOI18N
        btnStockAlertReport.setMnemonic('A');
        btnStockAlertReport.setText("Student Academic Report");
        btnStockAlertReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockAlertReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnStockAlertReport);
        btnStockAlertReport.setBounds(44, 146, 228, 51);

        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cmdCancel.setMnemonic('C');
        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCancel);
        cmdCancel.setBounds(404, 208, 102, 42);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_cmdCancelActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewSales salesView =  new ViewSales();
        salesView.setSize(800, 520);
        salesView.setVisible(true);
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void btnSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesReportActionPerformed
        // TODO add your handling code here:
        /*this.dispose();
        SalesSummarySelection salesSummarySelection =  new SalesSummarySelection();
        salesSummarySelection.setBounds(60,60,660, 360);
        salesSummarySelection.setVisible(true);*/
        
                        String reportQuery = "SELECT s.student_name AS student_name,  s.contact_number AS contact_number, s.guardian AS guardian, c.class_name AS class_name, s.admission_date AS admn_date,  ((TIMESTAMPDIFF(MONTH,  s.admission_date, CURDATE())+1) * s.fees_percentage) AS f_payable, COALESCE(SUM(f.amount),0) AS f_paid FROM student s\n" +
                        " JOIN class_master c ON s.class_id=c.class_master_id\n" +
                        " LEFT JOIN fees f ON s.student_id = f.student_id  GROUP BY s.student_id;";
        //GenericUtils.printReport("D:\\Leaders\\reports\\fees_payable.jrxml", reportQuery);
        GenericUtils.printReport("C:\\Users\\essaar\\Documents\\NetBeansProjects\\radon\\src\\com\\essar\\reports\\fees_payable.jrxml", reportQuery);

    }//GEN-LAST:event_btnSalesReportActionPerformed

    private void btnPurchaseReturnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseReturnReportActionPerformed
        // TODO add your handling code here:
        
        String reportQuery = "SELECT s.staff_id, s.staff_name AS staff_name,  s.phone AS contact_number, s.staff_type AS staff_type, s.joining_date AS joining_date\n" +
                        ", s.rate_per_hour AS rate_per_hour\n" +
                        ", COALESCE(SUM(w.hours_worked),0) AS hours_worked, COALESCE(SUM(w.net_amount),0) AS net_amount\n" +
                        ", (SELECT COALESCE(SUM(amount),0) FROM payment p WHERE p.staff_id = s.staff_id) AS paid_amnt\n" +
                        " FROM staff s\n" +
                        " LEFT JOIN work_log_details w ON s.staff_id=w.staff_id\n" +
                        " LEFT JOIN payment p ON s.staff_id = p.staff_id  GROUP BY s.staff_id;";
        
        GenericUtils.printReport("C:\\Users\\essaar\\Documents\\NetBeansProjects\\radon\\src\\com\\essar\\reports\\salary_payable.jrxml", reportQuery);
    }//GEN-LAST:event_btnPurchaseReturnReportActionPerformed

    private void btnStockReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockReportActionPerformed
        // TODO add your handling code here:
        /*ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        String reportString="com\\essar\\reports\\stock_report_first_choice.jrxml";
        //String reportString="D:\\reports\\users.jrxml";
        JasperReport jr = null;
        try {
            jr = JasperCompileManager.compileReport(reportString);
        } catch (JRException ex) {
            Logger.getLogger(StudentRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(jr, null,con);
        } catch (JRException ex) {
            Logger.getLogger(StudentRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JasperViewer.viewReport(jp);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt){
                //JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Closed","Why?", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Jasper Window has been closed");
            }
        });
        jv.setVisible(true);*/

    }//GEN-LAST:event_btnStockReportActionPerformed

    private void btnSupplierReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierReportActionPerformed
        // TODO add your handling code here:
                        String reportQuery = "SELECT st.student_name AS student_name, st.gender AS gender, st.date_of_birth AS dob"
                + ", st.admission_date AS adm_date, st.guardian AS guardian, st.contact_number AS cont_number"
                + ", cl.class_name AS class_name, st.extra_curricular AS extra_curr " 
                + " FROM student st JOIN class_master cl ON st.class_id = cl.class_master_id WHERE 1=1 ";
        GenericUtils.printReport("D:\\Leaders\\reports\\student_report.jrxml", reportQuery);
    }//GEN-LAST:event_btnSupplierReportActionPerformed

    private void btnPurchaseReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseReportActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        /*ViewPurchase purchaseView =  new ViewPurchase();
        purchaseView.setBounds(40, 40, 960, 660);
        purchaseView.setVisible(true);*/

        /*PurchaseSummarySelection purchaseSummarySelection =  new PurchaseSummarySelection();
        purchaseSummarySelection.setBounds(60,60,580, 320);
        purchaseSummarySelection.setVisible(true);*/
    }//GEN-LAST:event_btnPurchaseReportActionPerformed

    private void btnStockAlertReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockAlertReportActionPerformed
        // TODO add your handling code here:
        /*this.dispose();
        StockDateSelection stockDateSelection =  new StockDateSelection();
        stockDateSelection.setBounds(60,60,440, 260);
        stockDateSelection.setVisible(true);*/

    }//GEN-LAST:event_btnStockAlertReportActionPerformed

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
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewReports().setVisible(true);
            }
        });
    }
    

    public void initializeForm(){
        /*btnSave.setText("Add");
        btnSave.requestFocus();
        txtGST.setText("");
        txtCGST.setText("");
        txtSGST.setText("");
        txtDescription.setText("");*/
     

        SalesDAO salesDAO = new SalesDAO();
        renderDataIntoTable(salesDAO.retrieveSalesList());
        mnuTable = new JPopupMenu();
        mitDelete = new JMenuItem("Delete");
        mitDelete.addActionListener(this);
        
        mitView = new JMenuItem("View");
        mitView.addActionListener(this);
        
        //mnuTable.add(mitDelete);
        mnuTable.add(mitView);
         // sets the popup menu for the table
        //tblSalesView.setComponentPopupMenu(mnuTable);      
        //tblSalesView.addMouseListener(new TableMouseListener(tblSalesView));
   
    }
    


    
    public void renderDataIntoTable(List<SalesView> salesViewList){
        
        /*salesModel = (DefaultTableModel) tblSalesView.getModel();
        for(int i=0;i<salesViewList.size();i++){
            salesModel.addRow(new Object[]{salesViewList.get(i).getBillNumber(),salesViewList.get(i).getBillAmount(),salesViewList.get(i).getDiscount(), salesViewList.get(i).getPayableAmount(), salesViewList.get(i).getSalesDate(), salesViewList.get(i).getStatus()});
        }   */     
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPurchaseReport;
    private javax.swing.JButton btnPurchaseReturnReport;
    private javax.swing.JButton btnSalesReport;
    private javax.swing.JButton btnStockAlertReport;
    private javax.swing.JButton btnStockReport;
    private javax.swing.JButton btnSupplierReport;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitView;
    private javax.swing.JPopupMenu mnuTable;
    private javax.swing.JPanel pnlSalesView;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == mitDelete) {
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                /*long id = Long.parseLong(tblSalesView.getModel().getValueAt(tblSalesView.getSelectedRow(),4).toString());
                GstDAO gstDAO = new GstDAO();
                gstDAO.deleteRecordById(id);
                GenericUtils.removeRowFromJTable(tblSalesView, salesModel);*/
                
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
            
            if (menu == mitView) {
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                Sales sales = null;
                /*salesBillNumber = Integer.parseInt(tblSalesView.getModel().getValueAt(tblSalesView.getSelectedRow(),0).toString());
                SalesDAO salesDAO = new SalesDAO();
                sales = salesDAO.retrieveByBillNumber(salesBillNumber);*/
                
                SalesWindow salesWindow = new SalesWindow();
                //salesWindow.fetchSalesDataIntoTable(salesDAO.retrieveByBillNumber(salesBillNumber));
                salesWindow.repaint();
                salesWindow.setVisible(true);
                salesWindow.fetchSalesDataIntoTable(sales);
                this.dispose();
                /*txtGST.setText(gst.getGstValue()+"");
                txtSGST.setText(gst.getSgst()+"");
                txtCGST.setText(gst.getCgst()+"");
                txtDescription.setText(gst.getDescription());
                enableFormElements(true);
                btnSave.setText("Save");*/
                //initializeForm();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
