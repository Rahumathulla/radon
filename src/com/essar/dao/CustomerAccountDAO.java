/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.CustomerAccount;
import com.essar.utils.ConnectionManager;
import com.essar.pojos.ClassMaster;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahumathulla
 */
public class CustomerAccountDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<CustomerAccount> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<CustomerAccount>  customerAccountList= null;
        try {
            sql = "SELECT * from customer_accounts order by event_date";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            CustomerAccount customerAccount = null;
            customerAccountList = new ArrayList<CustomerAccount>();
            while(rs.next()){
                customerAccount = new CustomerAccount();
                customerAccount.setCustomerAccountId(rs.getLong(1));
                customerAccount.setCustomerId(rs.getLong(2));
                customerAccount.setCustomerAccountItemId(rs.getLong(3));
                customerAccount.setEventDate(rs.getDate(4));
                customerAccount.setParticularName(rs.getString(5));  
                customerAccount.setType(rs.getString(6));
                customerAccount.setCreditAmount(rs.getDouble(7));
                customerAccount.setDebitAmount(rs.getDouble(8));
                customerAccount.setRemarks(rs.getString(9));
                customerAccount.setCreateTS(rs.getTimestamp(10));
                customerAccount.setUpdateTS(rs.getTimestamp(11));
                customerAccount.setVoucherType(rs.getString(12));
                customerAccount.setVoucherNumber(rs.getString(13));
                //Adding to List
                customerAccountList.add(customerAccount);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerAccountList;
    }
    
    public List<CustomerAccount> retrieveByQuery(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<CustomerAccount>  customerAccountList= null;
        try {
            sql = query;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            CustomerAccount customerAccount = null;
            customerAccountList = new ArrayList<CustomerAccount>();
            while(rs.next()){
                customerAccount = new CustomerAccount();
                customerAccount.setCustomerAccountId(rs.getLong(1));
                customerAccount.setCustomerId(rs.getLong(2));
                customerAccount.setCustomerAccountItemId(rs.getLong(3));
                customerAccount.setEventDate(rs.getDate(4));
                customerAccount.setParticularName(rs.getString(5));  
                customerAccount.setType(rs.getString(6));
                customerAccount.setCreditAmount(rs.getDouble(7));
                customerAccount.setDebitAmount(rs.getDouble(8));
                customerAccount.setRemarks(rs.getString(9));
                customerAccount.setCreateTS(rs.getTimestamp(10));
                customerAccount.setUpdateTS(rs.getTimestamp(11));
                customerAccount.setVoucherType(rs.getString(12));
                customerAccount.setVoucherNumber(rs.getString(13));
                //Adding to List
                customerAccountList.add(customerAccount);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerAccountList;
    }
    public List<CustomerAccount> retrieveCustomerAccountEntriesInDateRange(java.util.Date stDate, java.util.Date endDate) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<CustomerAccount>  customerAccountList= null;
        String sqlPattern = "yyyy-MM-dd";
        SimpleDateFormat sqlDateFormat = new SimpleDateFormat(sqlPattern);
        String fromDate = sqlDateFormat.format(stDate);
        String toDate = sqlDateFormat.format(endDate);
        try {
            sql = "SELECT customer_account_id, income_expense_id, event_date, particular_name"
                    + " ,type, credit_amount, debit_amount, remarks, create_ts, update_ts, voucher_type, voucher_number from customer_accounts WHERE event_date BETWEEN "
                    + "'"+fromDate +" 00:00:00' AND '"+toDate+ " 23:59:59'" + "  #order by event_date \n"
                    + " UNION SELECT 11111, 22222,'"+toDate+"', 'Sales in the Period','Credit' "
                        + ", ROUND(SUM(payable_amount),2), 0, '', '2020-01-01 00:00:00', '2020-01-01 00:00:00' "
                        + " FROM sales WHERE sales_date BETWEEN"
                        + " '"+fromDate +" 00:00:00' AND '"+toDate+ " 23:59:59'"
                    + " UNION SELECT 333333, 555555,'"+toDate+"', 'Purchase in the Period','Debit' "
                        + ", 0, ROUND(SUM(payable_amount),2), '', '2020-01-01 00:00:00', '2020-01-01 00:00:00' "
                        + " FROM purchase WHERE purchase_date BETWEEN"
                        + " '"+fromDate +" 00:00:00' AND '"+toDate+ " 23:59:59'"
            
                    + " UNION SELECT 666666, 77777,'"+toDate+"', 'Closing Stock','Credit' "
                        + ", ROUND(SUM((purchase_price+(purchase_price*gst_percentage*0.01))*quantity),2), 0, '', '2020-01-01 00:00:00', '2020-01-01 00:00:00' "
                        + " FROM stock WHERE quantity >= 0";
            System.out.println("SQL :: "+sql);
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            CustomerAccount customerAccount = null;
            customerAccountList = new ArrayList<CustomerAccount>();
            while(rs.next()){
                customerAccount = new CustomerAccount();
                customerAccount.setCustomerAccountId(rs.getLong(1));
                customerAccount.setCustomerId(rs.getLong(2));
                customerAccount.setCustomerAccountItemId(rs.getLong(3));
                customerAccount.setEventDate(rs.getDate(4));
                customerAccount.setParticularName(rs.getString(5));  
                customerAccount.setType(rs.getString(6));
                customerAccount.setCreditAmount(rs.getDouble(7));
                customerAccount.setDebitAmount(rs.getDouble(8));
                customerAccount.setRemarks(rs.getString(9));
                customerAccount.setCreateTS(rs.getTimestamp(10));
                customerAccount.setUpdateTS(rs.getTimestamp(11));
                customerAccount.setVoucherType(rs.getString(12));
                customerAccount.setVoucherNumber(rs.getString(13));
                //Adding to List
                customerAccountList.add(customerAccount);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerAccountList;
    }

   
    public CustomerAccount retrieveById(long id) {
        CustomerAccount  customerAccount= null;
        try {
            sql = "SELECT * from customer_accounts where customer_account_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                customerAccount = new CustomerAccount();
                customerAccount.setCustomerAccountId(rs.getLong(1));
                customerAccount.setCustomerId(rs.getLong(2));
                customerAccount.setCustomerAccountItemId(rs.getLong(3));
                customerAccount.setEventDate(rs.getDate(4));
                customerAccount.setParticularName(rs.getString(5));  
                customerAccount.setType(rs.getString(6));
                customerAccount.setCreditAmount(rs.getDouble(7));
                customerAccount.setDebitAmount(rs.getDouble(8));
                customerAccount.setRemarks(rs.getString(9));
                customerAccount.setCreateTS(rs.getTimestamp(10));
                customerAccount.setUpdateTS(rs.getTimestamp(11));  
                customerAccount.setVoucherType(rs.getString(12));
                customerAccount.setVoucherNumber(rs.getString(13));
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerAccount;
    }

    public void insertIntoDB(CustomerAccount customerAccount) {
        try {            
            String sql = "INSERT INTO customer_accounts (customer_id, customer_account_item_id, event_date, particular_name "
                    + ", type, credit_amount, debit_amount, remarks, create_ts, voucher_type, voucher_number)"
                    + "  values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            java.sql.Date eventDate = new java.sql.Date( customerAccount.getEventDate().getTime());
            java.sql.Date createTS = new java.sql.Date( Calendar.getInstance().getTime().getTime() );
            //java.sql.Date updateTS = new java.sql.Date( Calendar.getInstance().getTime().getTime() );
            ps.setLong(1, customerAccount.getCustomerId());
            ps.setLong(2, customerAccount.getCustomerAccountItemId());
            ps.setDate(3, eventDate);
            ps.setString(4, customerAccount.getParticularName());
            ps.setString(5, customerAccount.getType());
            ps.setDouble(6, customerAccount.getCreditAmount());
            ps.setDouble(7, customerAccount.getDebitAmount());
            ps.setString(8, customerAccount.getRemarks());
            ps.setDate(9, createTS);
            //ps.setTimestamp(9, customerAccount.getCreateTS().getTime());
            ps.setString(11, customerAccount.getVoucherType());
            ps.setString(12, customerAccount.getVoucherNumber());
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
            String sql = "DELETE FROM customer_accounts WHERE customer_account_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void updateRecord(CustomerAccount customerAccount) {
        try {            
             String sql = "UPDATE customer_accounts SET customer_id = ?, customer_account_item_id = ?, event_date = ?, particular_name =?"
                    + ", type=?, credit_amount=?, debit_amount=?, remarks=?, update_ts=?, voucher_type=?, voucher_number=?"
                    + "  WHERE customer_account_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            java.sql.Date eventDate = new java.sql.Date( customerAccount.getEventDate().getTime());
            //java.sql.Date createTS = new java.sql.Date( Calendar.getInstance().getTime().getTime() );
            java.sql.Date updateTS = new java.sql.Date( Calendar.getInstance().getTime().getTime() );
            ps.setLong(1, customerAccount.getCustomerId());
            ps.setLong(2, customerAccount.getCustomerAccountItemId());
            ps.setDate(3, eventDate);
            ps.setString(4, customerAccount.getParticularName());
            ps.setString(5, customerAccount.getType());
            ps.setDouble(6, customerAccount.getCreditAmount());
            ps.setDouble(7, customerAccount.getDebitAmount());
            ps.setString(8, customerAccount.getRemarks());
            ps.setDate(9, updateTS);
            ps.setLong(10, customerAccount.getCustomerAccountId());
            ps.setString(11, customerAccount.getVoucherType());
            ps.setString(12, customerAccount.getVoucherNumber());
            //ps.setTimestamp(9, customerAccount.getCreateTS().getTime());
            ps.executeUpdate();
            con.close();                      
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
