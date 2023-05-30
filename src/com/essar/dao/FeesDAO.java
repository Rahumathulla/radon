/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;


import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
import com.essar.pojos.Fees;
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
public class FeesDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Fees> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Fees>  feesList= null;
        try {
            sql = "SELECT * from fees";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Fees fees = null;
            feesList = new ArrayList<Fees>();
            while(rs.next()){
                fees = new Fees();
                fees.setFeesId(rs.getLong("fees_id"));
                fees.setStudentId(rs.getLong("student_id"));
                fees.setAmount(rs.getDouble("amount"));
                fees.setFeesDate(rs.getDate("fees_date"));
                fees.setDescription(rs.getString("description"));
                fees.setCreateTS(rs.getDate("create_ts")); 
                fees.setUpdateTS(rs.getDate("update_ts"));
                fees.setReceiptNumber(rs.getLong("receipt_number"));
                
                //Adding to List
                feesList.add(fees);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return feesList;
    }
    
    public List<Fees> retrieveByQuery(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Fees>  feesList= null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            Fees fees;
            feesList = new ArrayList<>();
            while(rs.next()){
                fees = new Fees();
                fees.setFeesId(rs.getLong("fees_id"));
                fees.setStudentId(rs.getLong("student_id"));
                fees.setAmount(rs.getDouble("amount"));
                fees.setFeesDate(rs.getDate("fees_date"));
                fees.setDescription(rs.getString("description"));
                fees.setCreateTS(rs.getDate("create_ts")); 
                fees.setUpdateTS(rs.getDate("update_ts")); 
                fees.setReceiptNumber(rs.getLong("receipt_number"));
                
                //Adding to List
                feesList.add(fees);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return feesList;
    }
      

    public Fees retrieveById(long id) {
        Fees  fees= null;
        try {
            sql = "SELECT * from fees where fees_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                fees = new Fees();
                fees.setFeesId(rs.getLong("fees_id"));
                fees.setStudentId(rs.getLong("student_id"));
                fees.setAmount(rs.getDouble("amount"));
                fees.setFeesDate(rs.getDate("fees_date"));
                fees.setDescription(rs.getString("description"));
                fees.setCreateTS(rs.getDate("create_ts")); 
                fees.setUpdateTS(rs.getDate("update_ts")); 
                fees.setReceiptNumber(rs.getLong("receipt_number"));
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fees;
    }
        

    public void insertIntoDB(Fees fees) {
        try {            
            String sql = "INSERT INTO fees (student_id, amount, fees_date, description, create_ts, receipt_number)  values (?,?,?,?,NOW(),?)";
            System.out.println("insert query : " + sql);
            java.sql.Date feesDate = new java.sql.Date( fees.getFeesDate().getTime());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, fees.getStudentId());
            ps.setDouble(2, fees.getAmount());
            ps.setDate(3, feesDate);
            ps.setString(4, fees.getDescription());
            ps.setLong(5, fees.getReceiptNumber());
            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteRecordById(Long id) {
        try {            
            String sql = "DELETE FROM fees WHERE fees_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(Fees fees) {
        try {            
            String sql = "UPDATE fees set student_id = ? "
                    + ", amount=? ,fees_date=? "
                    + ", description=? update_ts = NOW() WHERE fees_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            java.sql.Date feesDate = new java.sql.Date(fees.getFeesDate().getTime());
            ps.setLong(1, fees.getStudentId());
            ps.setDouble(2, fees.getAmount());
            ps.setDate(3, feesDate);
            ps.setString(4, fees.getDescription());
            ps.executeUpdate();
            //System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
