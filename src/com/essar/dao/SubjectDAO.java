/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.Subject;
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
public class SubjectDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Subject> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Subject>  subjectList= null;
        try {
            sql = "SELECT * from subject";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Subject subject = null;
            subjectList = new ArrayList<Subject>();
            while(rs.next()){
                subject = new Subject();
                subject.setSubjectId(rs.getLong(1));
                subject.setSubjectName(rs.getString(2));
                subject.setComments(rs.getString(3));  
                System.out.println("---!@# ::"+rs.getLong(1));
                
                //Adding to List
                subjectList.add(subject);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return subjectList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Subject retrieveById(long id) {
        Subject  subject= null;
        try {
            sql = "SELECT * from subject where subject_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                subject = new Subject();
                subject.setSubjectId(rs.getLong(1));
                subject.setSubjectName(rs.getString(2));
                subject.setComments(rs.getString(3));                                             
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return subject;
    }

    public void insertIntoDB(Subject subject) {
        try {            
            String sql = "INSERT INTO subject (subject_name , comments)  values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subject.getSubjectName());
            ps.setString(2, subject.getComments());
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
            String sql = "DELETE FROM subject WHERE subject_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(Subject subject) {
        try {            
            String sql = "UPDATE subject set subject_name = ? "
                    + ", comments=?  WHERE subject_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, subject.getSubjectName());
            ps.setString(2, subject.getComments());
            ps.setLong(3, subject.getSubjectId());
            ps.executeUpdate();
            System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
