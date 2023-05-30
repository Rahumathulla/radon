/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

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
public class ClassMasterDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ClassMaster>  cList= null;
        
    public List<ClassMaster> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ClassMaster>  classMasterList= null;
        try {
            sql = "SELECT * from class_master";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            ClassMaster classMaster = null;
            classMasterList = new ArrayList<ClassMaster>();
            while(rs.next()){
                classMaster = new ClassMaster();
                classMaster.setClassMasterId(rs.getLong(1));
                classMaster.setClassName(rs.getString(2));
                classMaster.setFees(rs.getDouble(3));              
                
                //Adding to List
                classMasterList.add(classMaster);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+classMasterList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return classMasterList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public ClassMaster retrieveById(long id) {
        ClassMaster  classMaster= null;
        try {
            sql = "SELECT * from class_master where class_master_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                classMaster = new ClassMaster();
                classMaster.setClassMasterId(rs.getLong(1));
                classMaster.setClassName(rs.getString(2));
                classMaster.setFees(rs.getDouble(3));                                    
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+classMasterList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return classMaster;
    }


    public void insertIntoDB(ClassMaster classMaster) {
        try {            
            String sql = "INSERT INTO class_master (class_name,fees)  values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, classMaster.getClassName());
            ps.setDouble(2, classMaster.getFees());
            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateClassMaster(ClassMaster classMaster) {
        try {            
            String sql = "UPDATE class_master SET class_name= ?, fees = ?"
                    + " WHERE class_master_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, classMaster.getClassName());
            ps.setDouble(2, classMaster.getFees());
            ps.setLong(3, classMaster.getClassMasterId());
            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteRecordByCode(String code) {
        try {            
            String sql = "DELETE FROM class_master WHERE class_name = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
