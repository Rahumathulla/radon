/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.Staff;
import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
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
public class StaffDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Staff> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Staff>  staffList= null;
        try {
            sql = "SELECT * from staff";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Staff staff = null;
            staffList = new ArrayList<Staff>();
            while(rs.next()){
                staff = new Staff();
                staff.setStaffId(rs.getLong("staff_id"));
                staff.setStaffType(rs.getString("staff_type"));
                staff.setRatePerHour(rs.getDouble("rate_per_hour"));
                staff.setStaffName(rs.getString("staff_name"));
                staff.setPhoneNumber(rs.getString("phone"));
                staff.setAddress(rs.getString("address")); 
                staff.setJoiningDate(rs.getDate("joining_date")); 
                
                //Adding to List
                staffList.add(staff);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staffList;
    }
    
    public static List<String> retrieveAllStaffs() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<String>  staffList= null;
        try {
            String sql = "SELECT staff_name from staff";
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            staffList = new ArrayList<String>();
            while(rs.next()){                
                staffList.add(rs.getString(1));
 
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staffList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Staff retrieveById(long id) {
        Staff  staff= null;
        try {
            sql = "SELECT * from staff where staff_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                staff = new Staff();
                staff.setStaffId(rs.getLong("staff_id"));
                staff.setStaffType(rs.getString("staff_type"));
                staff.setRatePerHour(rs.getDouble("rate_per_hour"));
                staff.setStaffName(rs.getString("staff_name"));
                staff.setPhoneNumber(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));   
                staff.setJoiningDate(rs.getDate("joining_date"));
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staff;
    }
    
    public Staff retrieveByName(String staffName) {
        Staff  staff= null;
        try {
            sql = "SELECT * from staff where staff_name = '" + staffName +"'";
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                staff = new Staff();
                staff.setStaffId(rs.getLong("staff_id"));
                staff.setStaffType(rs.getString("staff_type"));
                staff.setRatePerHour(rs.getDouble("rate_per_hour"));
                staff.setStaffName(rs.getString("staff_name"));
                staff.setPhoneNumber(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));
                staff.setJoiningDate(rs.getDate("joining_date"));
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staff;
    }

    public void insertIntoDB(Staff staff) {
        try {            
            String sql = "INSERT INTO staff (staff_name, staff_type, rate_per_hour, phone ,address, joining_date)  values (?,?,?,?,?,?)";
            java.sql.Date joiningDate = new java.sql.Date( staff.getJoiningDate().getTime());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getStaffType());
            ps.setDouble(3, staff.getRatePerHour());
            ps.setString(4, staff.getPhoneNumber());
            ps.setString(5, staff.getAddress());
            ps.setDate(6, joiningDate);
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
            String sql = "DELETE FROM staff WHERE staff_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(Staff staff) {
        try {            
            String sql = "UPDATE staff set staff_name = ? "
                    + ", staff_type=? ,rate_per_hour=? "
                    + ", phone=? ,address=?, joining_date=?  WHERE staff_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            java.sql.Date joiningDate = new java.sql.Date(staff.getJoiningDate().getTime());
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getStaffType());
            ps.setDouble(3, staff.getRatePerHour());
            ps.setString(4, staff.getPhoneNumber());
            ps.setString(5, staff.getAddress());
            ps.setDate(6, joiningDate);
            ps.setLong(7, staff.getStaffId());
            ps.executeUpdate();
            System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
