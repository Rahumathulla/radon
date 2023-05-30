/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
//import com.essar.pojos.Purchase;
//import com.essar.pojos.PurchaseDetails;
import com.essar.pojos.PurchaseReturn;
//import com.essar.pojos.PurchaseView;
import com.essar.pojos.WorkLog;
import com.essar.pojos.WorkLogDetails;
import com.essar.pojos.WorkLogReturn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahumathulla
 */
public class WorkLogDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<WorkLog> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<WorkLog>  workLogList= null;
        try {
            sql = "SELECT * from work_log order by create_ts";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            WorkLog workLog = null;
            workLogList = new ArrayList<WorkLog>();            
            while(rs.next()){
                workLog = new WorkLog();
                workLog.setWorkLogId(rs.getLong(1));
                workLog.setReferenceNumber(rs.getLong(2));
                workLog.setWorkDate(rs.getDate(3));
                workLog.setCreateTS(rs.getDate(4)); 
                workLog.setUpdateTS(rs.getDate(5));
                workLog.setTotalAmount(rs.getDouble(6));
                workLog.setStatus(rs.getString(7));
                //Adding to List
                workLogList.add(workLog);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLogList;
    }
    
   /* public List<WorkLog> retrieveWorkLogList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<WorkLog>  workLogList= null;
        try {
            sql = "SELECT w.work_log_id"
                    + ", w.reference_number"
                    + ", w.work_date"
                    + ", w.create_ts"
                    + ", w.update_ts"
                    + ", w.payable_amount"
                    + ", p.purchase_date"
                    + ", p.status  "
                    + " from work_log w order by w.work_date";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            WorkLog workLog = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            workLogList = new ArrayList<WorkLog>();            
            while(rs.next()){
                workLog = new WorkLog();
                workLog.setWorkLogId(rs.getLong(1));
                workLog.setReferenceNumber(rs.getLong(2));
                workLog.setWorkDate(rs.getDate(3));
                workLog.setCreateTS(rs.getDate(4));
                workLog.setUpdateTS(rs.getDate(5));

                //Adding to List
                workLogList.add(workLog);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(WorkLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLogList;
    }*/
    public long generateReferenceNumber() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long refNumber = 10001;
        try {
            sql = "SELECT max(reference_number) from work_log order by create_ts";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
               refNumber = rs.getLong(1) + 1;
               if(refNumber<1000)
                   refNumber = 20001;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return refNumber;
    }
    public List<WorkLog> retrieveWorkLogByQuery(String sql) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<WorkLog>  workLogList= null;
        try {
            

            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            WorkLog workLog = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            workLogList = new ArrayList<WorkLog>();            
            while(rs.next()){
                workLog = new WorkLog();
                workLog.setWorkLogId(rs.getLong(1));
                workLog.setReferenceNumber(rs.getLong(2));
                workLog.setWorkDate(rs.getDate(3));
                workLog.setCreateTS(rs.getDate(4));
                workLog.setUpdateTS(rs.getDate(5));
                workLog.setTotalAmount(rs.getDouble(6));
                workLog.setStatus(rs.getString(7));

                //Adding to List
                workLogList.add(workLog);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(WorkLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLogList;
    }
    
    public long generateBillNumber() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long billNumber = 10001;
        try {
            sql = "SELECT max(bill_number) from work_log order by create_ts";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
               billNumber = rs.getLong(1) + 1;                                  
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return billNumber;
    }
    
    public long getOngoingWorkLogId(long referenceNumber) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long workLogId=0;
        try {
            sql = "SELECT work_log_id from work_log where reference_number ="+referenceNumber;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
               workLogId = rs.getLong(1);
               System.out.println("-----work_log_id  = "+workLogId);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return workLogId;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public WorkLog retrieveById(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        WorkLog workLog= null;
        try {
            sql = "SELECT * from work_log where work_log_id=" + id;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
           while(rs.next()){
                workLog = new WorkLog();
                workLog.setWorkLogId(rs.getLong(1));
                workLog.setReferenceNumber(rs.getLong(2));
                workLog.setWorkDate(rs.getDate(3));
                workLog.setCreateTS(rs.getDate(4));
                workLog.setUpdateTS(rs.getDate(5));                     
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(WorkLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLog;
    }
     
     public WorkLog retrieveByRefNumber(String billNumber) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        WorkLog workLog= null;
        WorkLogDetails workLogDetails = null;
        List<WorkLogDetails> workLogDetailsList = new ArrayList<>();
        try {
            sql = "SELECT * from work_log where reference_number='" + billNumber+"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                workLog = new WorkLog();
                                workLog.setWorkLogId(rs.getLong(1));
                workLog.setReferenceNumber(rs.getLong(2));
                workLog.setWorkDate(rs.getDate(3));
                workLog.setCreateTS(rs.getDate(4));
                workLog.setUpdateTS(rs.getDate(5));
                workLog.setTotalAmount(rs.getDouble(6));
                //sales.setCreateTS(rs.getDate(13)); 
                //sales.setUpdateTS(rs.getDate(14));
             String detailSql = "SELECT * from work_log_details where work_log_id ="+workLog.getWorkLogId();  
             Statement detailStatement = con.createStatement();
             ResultSet rsDetails = detailStatement.executeQuery(detailSql);
             while(rsDetails.next()){
                 workLogDetails = new WorkLogDetails();
                 workLogDetails.setWorkLogDetailsId(rsDetails.getLong(1));
                 workLogDetails.setWorkLogId(rsDetails.getLong(2));
                 workLogDetails.setStaffId(rsDetails.getLong(3));
                 workLogDetails.setStaffName(rsDetails.getString(4));
                 workLogDetails.setStaffType(rsDetails.getString(5));
                 workLogDetails.setPhoneNumber(rsDetails.getString(6));
                 workLogDetails.setRatePerHour(rsDetails.getDouble(7));
                 workLogDetails.setHoursWorked(rsDetails.getDouble(8));
                 workLogDetails.setNetAmount(rsDetails.getDouble(9));

                 workLogDetailsList.add(workLogDetails);
             }
             workLog.setWorkLogDetails(workLogDetailsList);
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLog;
    }
     
     public List<WorkLogDetails> retrieveStaffWorkLogsByQuery(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<WorkLogDetails> workLogDetailsList = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);

             Statement detailStatement = con.createStatement();
             ResultSet rsDetails = detailStatement.executeQuery(query);
             WorkLogDetails workLogDetails = null;
             while(rsDetails.next()){
                 workLogDetails = new WorkLogDetails();
                 workLogDetails.setWorkLogDetailsId(rsDetails.getLong(1));
                 workLogDetails.setWorkLogId(rsDetails.getLong(2));
                 workLogDetails.setStaffId(rsDetails.getLong(3));
                 workLogDetails.setStaffName(rsDetails.getString(4));
                 workLogDetails.setStaffType(rsDetails.getString(5));
                 workLogDetails.setPhoneNumber(rsDetails.getString(6));
                 workLogDetails.setRatePerHour(rsDetails.getDouble(7));
                 workLogDetails.setHoursWorked(rsDetails.getDouble(8));
                 workLogDetails.setNetAmount(rsDetails.getDouble(9));
                 //Please make the field adjustment in getDate(12) according to the select query passed
                 workLogDetails.setUpdateTS(rsDetails.getDate(12));
                 workLogDetailsList.add(workLogDetails);
             }             
                
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLogDetailsList;
    }
     
     public WorkLog retrieveByWorkLogId(long workLogId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        WorkLog workLog= null;
        WorkLogDetails workLogDetails = null;
        List<WorkLogDetails> workLogDetailsList = new ArrayList<>();
        try {
            sql = "SELECT * from work_log where work_log_id=" + workLogId;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                workLog = new WorkLog();
                workLog.setWorkLogId(rs.getLong(1));
                workLog.setReferenceNumber(rs.getLong(2));
                workLog.setWorkDate(rs.getDate(3));
                workLog.setCreateTS(rs.getTimestamp(4));
                workLog.setUpdateTS(rs.getTimestamp(5));
                workLog.setTotalAmount(rs.getDouble("total_amount"));
                workLog.setStatus(rs.getString("status"));
       
                //sales.setCreateTS(rs.getDate(13)); 
                //sales.setUpdateTS(rs.getDate(14));
             String detailSql = "SELECT * from work_log_details where work_log_id ="+workLog.getWorkLogId();  
             Statement detailStatement = con.createStatement();
             ResultSet rsDetails = detailStatement.executeQuery(detailSql);
             while(rsDetails.next()){
                 workLogDetails = new WorkLogDetails();
                 workLogDetails.setWorkLogDetailsId(rsDetails.getLong(1));
                 workLogDetails.setWorkLogId(rsDetails.getLong(2));
                 workLogDetails.setStaffId(rsDetails.getLong(3));
                 workLogDetails.setStaffName(rsDetails.getString(4));
                 workLogDetails.setStaffType(rsDetails.getString(5));
                 workLogDetails.setPhoneNumber(rsDetails.getString(6));
                 workLogDetails.setRatePerHour(rsDetails.getDouble(7));
                 workLogDetails.setHoursWorked(rsDetails.getDouble(8));
                 workLogDetails.setNetAmount(rsDetails.getDouble(9));
                 workLogDetails.setCreateTS(rsDetails.getTimestamp(10));
                 workLogDetails.setUpdateTS(rsDetails.getTimestamp(11));
                 workLogDetailsList.add(workLogDetails);
             }
             workLog.setWorkLogDetails(workLogDetailsList);
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workLog;
    }
     
     public List<Long> getMaxAndMinIds() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Long> borderIds = new ArrayList<>();
        try {
            sql = "SELECT min(purchase_id),max(purchase_id) from purchase";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
               borderIds.add(rs.getLong(1));
               borderIds.add(rs.getLong(2));    
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return borderIds;
    }
    
    public void insertIntoDB(WorkLog workLog) {
        try {            
            String sql = "INSERT INTO work_log (reference_number, work_date, create_ts, update_ts, total_amount, status)"
                    + " values (?,?,NOW(),NOW(),?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("---"+workLog.getWorkDate().getTime());
            java.sql.Date workDate = new java.sql.Date( workLog.getWorkDate().getTime());
            java.sql.Date createTS = new java.sql.Date( workLog.getCreateTS().getTime() );
            java.sql.Date updateTS = new java.sql.Date( workLog.getUpdateTS().getTime() );
            //java.sql.Date updateTS = new java.sql.Date( sales.getSalesDate().getTime() );
            ps.setLong(1, workLog.getReferenceNumber());
            ps.setDate(2, workDate);
            ps.setDouble(3, workLog.getTotalAmount());
            ps.setString(4, workLog.getStatus());
            //ps.setDate(3, createTS);
            //ps.setDate(17, updateTS);
            ps.executeUpdate();
                        
            WorkLogDetails workLogDetails = new WorkLogDetails();
            List<WorkLogDetails> workLogDetailsList = workLog.getWorkLogDetails();
            PreparedStatement detailStatement = null;
            String detailSql = "INSERT INTO work_log_details (work_log_id, staff_id, staff_name"
                    + ", staff_type, phone_number, rate_per_hour, hours_worked, net_amount"
                    + ", create_ts) "
                    + " values (?,?,?,?,?,?,?,?,NOW())";
            for (int i=0; i<workLogDetailsList.size(); i++){
                detailStatement = con.prepareStatement(detailSql);
                workLogDetails = workLogDetailsList.get(i);
                detailStatement = con.prepareStatement(detailSql);
                //Getting the sales id with Bill Number
                WorkLogDAO workLogDAO =  new WorkLogDAO();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //java.sql.Date purchaseDate = new java.sql.Date( purchase.getPurchaseDate().getTime() );
                System.out.println("------Ref No ::"+workLog.getReferenceNumber());
                detailStatement.setLong(1, workLogDAO.getOngoingWorkLogId(workLog.getReferenceNumber()));
                detailStatement.setLong(2, workLogDetails.getStaffId());
                detailStatement.setString(3, workLogDetails.getStaffName());
                detailStatement.setString(4, workLogDetails.getStaffType());
                detailStatement.setString(5, workLogDetails.getPhoneNumber());
                detailStatement.setDouble(6, workLogDetails.getRatePerHour());
                detailStatement.setDouble(7, workLogDetails.getHoursWorked());
                detailStatement.setDouble(8, workLogDetails.getNetAmount());
                System.out.println(" Query :: "+detailStatement);
                detailStatement.executeUpdate();                
                
            }
            //updateStockAfterPurchase(workLog,workLogDetailsList);
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateWorkLog(WorkLog workLog, List<WorkLogReturn> returnList) {
       try {
            
            String sql = "UPDATE work_log SET  reference_number =?"
                    + ", work_date =?, update_ts=NOW(), total_amount =?, status =?"
                    + " WHERE work_log_id = ?"
                    ;
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("---"+workLog.getReferenceNumber());
            //java.sql.Date salesDate = new java.sql.Date( sales.getSalesDate().getTime() );
            //java.sql.Date createTS = new java.sql.Date( sales.getCreateTS().getTime() );
            //java.sql.Date updateTS = new java.sql.Date( sales.getUpdateTS().getTime() );
            //java.sql.Date updateTS = new java.sql.Date( sales.getSalesDate().getTime() );
            java.sql.Date workDate = new java.sql.Date( workLog.getWorkDate().getTime() );
            ps.setDouble(1, workLog.getReferenceNumber());
            ps.setDate(2, workDate);
            ps.setDouble(3, workLog.getTotalAmount());
            ps.setString(4, workLog.getStatus());
            ps.setLong(5, workLog.getWorkLogId());
            System.out.println("----Updating Purchase = "+workLog.getReferenceNumber());
            System.out.println("----Updating Query = "+ps.toString());
            System.out.println("----WorkLog Details Size  = "+workLog.getWorkLogDetails().size());
            //ps.setDouble(15, sales.getCess());
            //ps.setDate(16, createTS);
            //ps.setString(17, sales.getCustomerName());
            //ps.setDate(17, updateTS);
            ps.executeUpdate();
            
            //More Line Item on top of existing Bill Logic
            WorkLogDetails workLogDetails = new WorkLogDetails();
            List<WorkLogDetails> workLogDetailsList = workLog.getWorkLogDetails();
            PreparedStatement detailStatement = null;
            String detailSql = "INSERT INTO work_log_details (work_log_id, staff_id, staff_name"
                    + ", staff_type, phone_number, rate_per_hour, hours_worked, net_amount"
                    + ", create_ts) "
                    + " values (?,?,?,?,?,?,?,?,NOW())";
            for (int i=0; i<workLogDetailsList.size(); i++){
                detailStatement = con.prepareStatement(detailSql);
                workLogDetails = workLogDetailsList.get(i);
                detailStatement = con.prepareStatement(detailSql);
                //Getting the sales id with Bill Number
                WorkLogDAO workLogDAO =  new WorkLogDAO();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //java.sql.Date purchaseDate = new java.sql.Date( purchase.getPurchaseDate().getTime() );
                System.out.println("------Ref No ::"+workLog.getReferenceNumber());
                detailStatement.setLong(1, workLogDAO.getOngoingWorkLogId(workLog.getReferenceNumber()));
                detailStatement.setLong(2, workLogDetails.getStaffId());
                detailStatement.setString(3, workLogDetails.getStaffName());
                detailStatement.setString(4, workLogDetails.getStaffType());
                detailStatement.setString(5, workLogDetails.getPhoneNumber());
                detailStatement.setDouble(6, workLogDetails.getRatePerHour());
                detailStatement.setDouble(7, workLogDetails.getHoursWorked());
                detailStatement.setDouble(8, workLogDetails.getNetAmount());
                System.out.println(" Query :: "+detailStatement);
                detailStatement.executeUpdate();                
                
            }
            WorkLogReturn workLogReturn = new WorkLogReturn();
            //List<SalesDetails> salesDetailsList = sales.getSalesDetails();
            PreparedStatement deleteStatement = null;
            String deleteSql = "DELETE FROM work_log_details where work_log_details_id =?  ";                 
            for (int i=0; i<returnList.size(); i++){
                deleteStatement = con.prepareStatement(deleteSql);
                workLogReturn = returnList.get(i);
                deleteStatement = con.prepareStatement(deleteSql);
                deleteStatement.setLong(1, workLogReturn.getWorkLogDetailsId());
                
                deleteStatement.executeUpdate();                
                
            }
            /*System.out.println("Above Stock Update after PReturn");
            updateStockAfterPurchaseReturn(purchase, returnList);
            
            if(purchase.getBillAmount()<=0){
                PreparedStatement stDelete = null;               
                String deleteBill = "DELETE FROM purchase where bill_number =?  ";
                stDelete = con.prepareStatement(deleteBill);
                stDelete.setString(1, purchase.getBillNumber());
                stDelete.executeUpdate();
                System.out.println("####"+stDelete.toString());
            }*/
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStockAfterPurchase(WorkLog purchase,List<WorkLogDetails> purchaseDetailsList) {
        /*try {
            ConnectionManager cm = new ConnectionManager();
            Connection co = cm.getConnection();
            //String stSql = "UPDATE stock SET quantity = quantity+?, update_ts = NOW() WHERE item_id = ? ";
            //Dummy value -100000 to go to else part always
            String stSql = "UPDATE stock SET quantity = CASE "
			+" WHEN quantity < -100000 THEN ?" 
			+" ELSE quantity+?"
			+" END "
                        +" WHERE item_id = ? ";

            PreparedStatement ps = co.prepareStatement(stSql);        
            for(int i=0;i<purchaseDetailsList.size();i++){                
                //ps.setDouble(1, purchaseDetailsList.get(i).getQuantity());
                //ps.setDouble(2, purchaseDetailsList.get(i).getQuantity());
                //ps.setLong(3, purchaseDetailsList.get(i).getItemId());
                System.out.println("Purchase SQL || "+ps.toString());
                ps.executeUpdate();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String auditSql = "INSERT INTO activity_log (description,created_by) values (?,?)";
            PreparedStatement psAudit = co.prepareStatement(auditSql);
            for(int i=0;i<purchaseDetailsList.size();i++){                
                //psAudit.setString(1, "Purchased "+purchaseDetailsList.get(i).getQuantity()+" unit of " + purchaseDetailsList.get(i).getItemName()+" on " +sdf.format(purchase.getPurchaseDate()) +" Invoice Number-"+purchase.getBillNumber());
                psAudit.setString(2, "Purchase");
                psAudit.executeUpdate();
            }
            co.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void updateStockAfterPurchaseReturn(WorkLog purchase,List<PurchaseReturn> returnList) {
        /*try {
            ConnectionManager cm = new ConnectionManager();
            Connection co = cm.getConnection();
            String stSql = "UPDATE stock SET quantity = quantity-?, update_ts =NOW() WHERE item_id = ? ";
            PreparedStatement psUpdate = co.prepareStatement(stSql); 
            
            for(int i=0;i<returnList.size();i++){                
                psUpdate.setDouble(1, returnList.get(i).getQuantity());
                psUpdate.setLong(2, returnList.get(i).getItemId());
                psUpdate.executeUpdate();
                System.out.println("Return SQL || "+psUpdate.toString());
            }
            String auditSql = "INSERT INTO activity_log (description, created_by) values (?,?)";
            PreparedStatement psAudit = co.prepareStatement(auditSql);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for(int i=0;i<returnList.size();i++){                
                psAudit.setString(1, "Purchase Returned "+returnList.get(i).getQuantity()+" unit of " + returnList.get(i).getItemName()+" with Bill Number-"+purchase.getReferenceNumber()+" and Purchase Date-"+sdf.format(purchase.getWorkDate()));
                psAudit.setString(2, "Purchase Return");
                psAudit.executeUpdate();
            }
            
            co.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public void deleteRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
