/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.School;
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
public class SchoolDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<School> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<School>  schoolList= null;
        try {
            sql = "SELECT * from school";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            School school = null;
            schoolList = new ArrayList<School>();
            while(rs.next()){
                school = new School();
                school.setSchoolId(rs.getLong(1));
                school.setSchoolName(rs.getString(2));
                school.setSchoolAddress(rs.getString(3));
                school.setComments(rs.getString(4));  
                System.out.println("---!@# ::"+rs.getLong(1));
                
                //Adding to List
                schoolList.add(school);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return schoolList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public School retrieveById(long id) {
        School  school= null;
        try {
            sql = "SELECT * from school where school_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                school = new School();
                school.setSchoolId(rs.getLong(1));
                school.setSchoolName(rs.getString(2));
                school.setSchoolAddress(rs.getString(3));
                school.setComments(rs.getString(4));                                             
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return school;
    }

    public void insertIntoDB(School school) {
        try {            
            String sql = "INSERT INTO school (school_name ,school_address, comments)  values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, school.getSchoolName());
            ps.setString(2, school.getSchoolAddress());
            ps.setString(3, school.getComments());
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
            String sql = "DELETE FROM school WHERE school_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(School school) {
        try {            
            String sql = "UPDATE school set school_name = ? "
                    + ", school_address=? , comments=?  WHERE school_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, school.getSchoolName());
            ps.setString(2, school.getSchoolAddress());
            ps.setString(3, school.getComments());
            ps.setLong(4, school.getSchoolId());
            ps.executeUpdate();
            System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
