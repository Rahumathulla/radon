/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
import com.essar.pojos.Complaint;
import com.essar.pojos.PurchaseReturn;
import com.essar.pojos.WorkLog;
import com.essar.pojos.WorkLogDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahumathulla
 */
public class ComplaintDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Complaint> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Complaint>  complaintList= null;
        try {
            sql = "SELECT * from complaint order by complaint_id DESC";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Complaint complaint = null;
            complaintList = new ArrayList<Complaint>();            
            while(rs.next()){
                complaint = new Complaint();
                complaint.setComplaintId(rs.getLong(1));
                complaint.setReferenceNumber(rs.getLong(2));
                complaint.setStudentId(rs.getLong(3));
                complaint.setStudentName(rs.getString(4)); 
                complaint.setParentName(rs.getString(5));
                complaint.setClassName(rs.getString(6));
                complaint.setComplaintNotes(rs.getString(7));
                complaint.setLogDate(rs.getDate(8));
                complaint.setResolutionDate(rs.getDate(9));
                complaint.setStatus(rs.getString(10));
                complaint.setCreateTS(rs.getTimestamp(11));
                complaint.setUpdateTS(rs.getTimestamp(12));
                System.out.println("!@#-----"+complaint.getComplaintId());
                //Adding to List
                complaintList.add(complaint);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return complaintList;
    }
    
      
    
    public long generateReferenceNumber() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long refNumber = 10001;
        try {
            sql = "SELECT max(reference_number) from complaint order by create_ts";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
               refNumber = rs.getLong(1) + 1;
               if(refNumber<1000)
                   refNumber = 10001;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return refNumber;
    }
    
    public long getOngoingWorkLogId(long referenceNumber) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long workLogId=0;
        try {
            sql = "SELECT complaint_id from complaint where reference_number ="+referenceNumber;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
               workLogId = rs.getLong(1);
               System.out.println("-----complaint_id  = "+workLogId);
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
    
     public Complaint retrieveById(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Complaint complaint= null;
        try {
            sql = "SELECT * from complaint where complaint_id=" + id;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
           while(rs.next()){
                complaint = new Complaint();
                complaint.setComplaintId(rs.getLong(1));
                complaint.setReferenceNumber(rs.getLong(2));
                complaint.setStudentId(rs.getLong(3));
                complaint.setStudentName(rs.getString(4)); 
                complaint.setParentName(rs.getString(5));
                complaint.setClassName(rs.getString(6));
                complaint.setComplaintNotes(rs.getString(7));
                complaint.setLogDate(rs.getDate(8));
                complaint.setResolutionDate(rs.getDate(9));
                complaint.setStatus(rs.getString(10));
                complaint.setCreateTS(rs.getTimestamp(11));
                complaint.setUpdateTS(rs.getTimestamp(12));                 
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(WorkLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return complaint;
    }
     
     public Complaint retrieveByRefNumber(String refNumber) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Complaint complaint= null;
        //WorkLogDetails workLogDetails = null;
        List<WorkLogDetails> workLogDetailsList = new ArrayList<>();
        try {
            sql = "SELECT * from complaint where reference_number='" + refNumber+"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                complaint = new Complaint();
                complaint.setComplaintId(rs.getLong(1));
                complaint.setReferenceNumber(rs.getLong(2));
                complaint.setStudentId(rs.getLong(3));
                complaint.setStudentName(rs.getString(4)); 
                complaint.setParentName(rs.getString(5));
                complaint.setClassName(rs.getString(6));
                complaint.setComplaintNotes(rs.getString(7));
                complaint.setLogDate(rs.getDate(8));
                complaint.setResolutionDate(rs.getDate(9));
                complaint.setStatus(rs.getString(10));
                complaint.setCreateTS(rs.getTimestamp(11));
                complaint.setUpdateTS(rs.getTimestamp(12));       
             }
            
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return complaint;
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
    
    public void insertIntoDB(Complaint complaint) {
        try {            
            String sql = "INSERT INTO complaint (reference_number, student_id, student_name, parent_name, class_name"
                    + ", complaint_notes, log_date, resolution_date, status, create_ts)"
                    + " values (?,?,?,?,?,?,?,?,?,NOW())";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("---"+complaint.getLogDate().getTime());
            java.sql.Date logDate = new java.sql.Date( complaint.getLogDate().getTime());
            java.sql.Date resolutionDate = new java.sql.Date( complaint.getResolutionDate().getTime());
            java.sql.Date createTS = new java.sql.Date( complaint.getCreateTS().getTime());
            java.sql.Date updateTS = new java.sql.Date( complaint.getUpdateTS().getTime());
            //java.sql.Date updateTS = new java.sql.Date( sales.getSalesDate().getTime() );
            ps.setLong(1, complaint.getReferenceNumber());
            ps.setLong(2, complaint.getStudentId());
            ps.setString(3, complaint.getStudentName());
            ps.setString(4, complaint.getParentName());
            ps.setString(5, complaint.getClassName());
            ps.setString(6, complaint.getComplaintNotes());
            ps.setDate(7, logDate);
            ps.setDate(8, resolutionDate);
            ps.setString(9, complaint.getStatus());

            //ps.setDate(3, createTS);
            //ps.setDate(17, updateTS);
            ps.executeUpdate();
   
            //updateStockAfterPurchase(workLog,workLogDetailsList);
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePurchaseAfterReturn(WorkLog workLog, List<PurchaseReturn> returnList) {
       
    }
    
    public void updateStockAfterPurchase(WorkLog purchase,List<WorkLogDetails> purchaseDetailsList) {
      
    }
    
    public void updateStockAfterPurchaseReturn(WorkLog purchase,List<PurchaseReturn> returnList) {
        
    }

    public void deleteRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteRecordByCode(String code) {
        try {            
            String sql = "DELETE FROM supplier WHERE supplier_code = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRecord(Complaint complaint) {
        try {            
            String sql = "UPDATE complaint SET reference_number=?, student_id=?, student_name=?, parent_name=?, class_name=?"
                    + ", complaint_notes=?, log_date=?, resolution_date=?, status=?, update_ts=NOW() WHERE complaint_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("--::"+sql);
             java.sql.Date logDate = new java.sql.Date( complaint.getLogDate().getTime());
            java.sql.Date resolutionDate = new java.sql.Date( complaint.getResolutionDate().getTime());

            //java.sql.Date updateTS = new java.sql.Date( sales.getSalesDate().getTime() );
            ps.setLong(1, complaint.getReferenceNumber());
            ps.setLong(2, complaint.getStudentId());
            ps.setString(3, complaint.getStudentName());
            ps.setString(4, complaint.getParentName());
            ps.setString(5, complaint.getClassName());
            ps.setString(6, complaint.getComplaintNotes());
            ps.setDate(7, logDate);
            ps.setDate(8, resolutionDate);
            ps.setString(9, complaint.getStatus());
            ps.setLong(10, complaint.getComplaintId());
            System.out.println("QUERY ::"+ps.toString());
            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
