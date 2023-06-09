/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.GST;
import com.essar.pojos.PricingTier;
import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
import com.essar.pojos.Supplier;
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
public class GstDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<GST> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<GST>  gstList= null;
        try {
            sql = "SELECT * from gst";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            GST gst = null;
            gstList = new ArrayList<GST>();
            while(rs.next()){
                gst = new GST();
                gst.setGstId(rs.getLong(1));
                gst.setGstValue(rs.getDouble(2));
                gst.setSgst(rs.getDouble(3));
                gst.setCgst(rs.getDouble(4));
                gst.setDescription(rs.getString(5));
                
                //Adding to List
                gstList.add(gst);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return gstList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public GST retrieveById(long id) {
        GST  gst= null;
        try {
            sql = "SELECT * from gst where gst_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                gst = new GST();
                gst.setGstId(rs.getLong(1));
                gst.setGstValue(rs.getDouble(2));
                gst.setSgst(rs.getDouble(3));
                gst.setCgst(rs.getDouble(4));
                gst.setDescription(rs.getString(5));                                                    
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return gst;
    }

    public void insertIntoDB(GST gst) {
        try {            
            String sql = "INSERT INTO gst (gst_value, sgst, cgst, description)  values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, gst.getGstValue());
            ps.setDouble(2, gst.getSgst());
            ps.setDouble(3, gst.getCgst());
            ps.setString(4, gst.getDescription());
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
            String sql = "DELETE FROM gst WHERE gst_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            System.out.println("--"+ps.toString());
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(GST gst) {
        try {            
            String sql = "UPDATE gst set gst_value = ? "
                    + ", sgst=? , cgst=?, description = ?   WHERE gst_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            

            ps.setDouble(1, gst.getGstValue());
            ps.setDouble(2, gst.getSgst());
            ps.setDouble(3, gst.getCgst());
            ps.setString(4, gst.getDescription());
            ps.setLong(5, gst.getGstId());
            ps.executeUpdate();
            System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
