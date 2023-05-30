/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.CustomerAccountItem;
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
public class CustomerAccountItemDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<CustomerAccountItem> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<CustomerAccountItem>  CustomerAccountItemList= null;
        try {
            sql = "SELECT * from customer_account_items";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            CustomerAccountItem CustomerAccountItem = null;
            CustomerAccountItemList = new ArrayList<CustomerAccountItem>();
            while(rs.next()){
                CustomerAccountItem = new CustomerAccountItem();
                CustomerAccountItem.setCustomerAccountItemId(rs.getLong(1));
                CustomerAccountItem.setCustomerAccountItemName(rs.getString(2));
                CustomerAccountItem.setType(rs.getString(3));
                CustomerAccountItem.setRemarks(rs.getString(4));  
                
                //Adding to List
                CustomerAccountItemList.add(CustomerAccountItem);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return CustomerAccountItemList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CustomerAccountItem retrieveById(long id) {
        CustomerAccountItem  CustomerAccountItem= null;
        try {
            sql = "SELECT * from customer_account_items where customer_account_item_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                CustomerAccountItem = new CustomerAccountItem();
                CustomerAccountItem.setCustomerAccountItemId(rs.getLong(1));
                CustomerAccountItem.setCustomerAccountItemName(rs.getString(2));
                CustomerAccountItem.setType(rs.getString(3));
                CustomerAccountItem.setRemarks(rs.getString(4));                                                      
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return CustomerAccountItem;
    }

    public void insertIntoDB(CustomerAccountItem CustomerAccountItem) {
        try {            
            String sql = "INSERT INTO customer_account_items (customer_account_item_name,type,remarks)  values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, CustomerAccountItem.getCustomerAccountItemName());
            ps.setString(2, CustomerAccountItem.getType());
            ps.setString(3, CustomerAccountItem.getRemarks());
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
            String sql = "DELETE FROM customer_account_items WHERE customer_account_item_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(CustomerAccountItem CustomerAccountItem) {
        try {            
            String sql = "UPDATE customer_account_items set customer_account_item_name = ? "
                    + ", type=? ,remarks=?  WHERE customer_account_item_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, CustomerAccountItem.getCustomerAccountItemName());
            ps.setString(2, CustomerAccountItem.getType());
            ps.setString(3, CustomerAccountItem.getRemarks());
            ps.setLong(4, CustomerAccountItem.getCustomerAccountItemId());
            ps.executeUpdate();
            System.out.println("--::"+ps.toString());
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
