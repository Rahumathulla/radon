/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;


import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
import com.essar.pojos.Payment;
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
public class PaymentDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Payment> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Payment>  paymentList= null;
        try {
            sql = "SELECT * from payment";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Payment payment = null;
            paymentList = new ArrayList<Payment>();
            while(rs.next()){
                payment = new Payment();
                payment.setPaymentId(rs.getLong("payment_id"));
                payment.setStaffId(rs.getLong("staff_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
                payment.setCreateTS(rs.getDate("create_ts")); 
                payment.setUpdateTS(rs.getDate("update_ts")); 
                
                //Adding to List
                paymentList.add(payment);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return paymentList;
    }
    
    public List<Payment> retrieveByQuery(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Payment>  paymentList= null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            Payment payment;
            paymentList = new ArrayList<>();
            while(rs.next()){
                payment = new Payment();
                payment.setPaymentId(rs.getLong("payment_id"));
                payment.setStaffId(rs.getLong("staff_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
                payment.setCreateTS(rs.getDate("create_ts")); 
                payment.setUpdateTS(rs.getDate("update_ts")); 
                
                //Adding to List
                paymentList.add(payment);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return paymentList;
    }
      

    public Payment retrieveById(long id) {
        Payment  payment= null;
        try {
            sql = "SELECT * from payment where payment_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                payment = new Payment();
                payment.setPaymentId(rs.getLong("payment_id"));
                payment.setStaffId(rs.getLong("staff_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
                payment.setCreateTS(rs.getDate("create_ts")); 
                payment.setUpdateTS(rs.getDate("update_ts")); 
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return payment;
    }
        

    public void insertIntoDB(Payment payment) {
        try {            
            String sql = "INSERT INTO payment (staff_id, amount, payment_date, description, create_ts)  values (?,?,?,?,NOW())";
            java.sql.Date paymentDate = new java.sql.Date( payment.getPaymentDate().getTime());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, payment.getStaffId());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, paymentDate);
            ps.setString(4, payment.getDescription());
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
            String sql = "DELETE FROM payment WHERE payment_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(Payment payment) {
        try {            
            String sql = "UPDATE payment set staff_id = ? "
                    + ", amount=? ,payment_date=? "
                    + ", description=? update_ts = NOW() WHERE payment_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            java.sql.Date paymentDate = new java.sql.Date(payment.getPaymentDate().getTime());
            ps.setLong(1, payment.getStaffId());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, paymentDate);
            ps.setString(4, payment.getDescription());
            ps.executeUpdate();
            //System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
