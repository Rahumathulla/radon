/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.Attendance;
import com.essar.pojos.AttendanceDetails;
import com.essar.pojos.GST;
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
public class AttendanceDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Attendance> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Attendance>  attendanceList= null;
        try {
            sql = "SELECT * from attendance";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Attendance attendance = null;
            attendanceList = new ArrayList<>();
            while(rs.next()){
                attendance = new Attendance();
                attendance.setAttendanceId(rs.getLong(1));
                attendance.setClassId(rs.getLong(2));
                attendance.setTakenBy(rs.getString(3));
                attendance.setAttendanceDate(rs.getDate(4));
                attendance.setCreateTS(rs.getDate(5));
                attendance.setUpdateTS(rs.getDate(6));
                
                //Adding to List
                attendanceList.add(attendance);                       
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return attendanceList;
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

    public void insertIntoDB(Attendance attendance, boolean trackActivity) {
        try {            
            String sql = "INSERT INTO attendance (class_id, taken_by, attendance_date, create_ts)"
                    + " values (?,?,?,NOW())";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("---"+attendance.getAttendanceDate().getTime());
            java.sql.Date attDate = new java.sql.Date( attendance.getAttendanceDate().getTime() );

            ps.setLong(1, attendance.getClassId());
            ps.setString(2, attendance.getTakenBy());
            ps.setDate(3, attDate);           
            ps.executeUpdate();
                        
            /*AttendanceDetails attendanceDetails = new AttendanceDetails();
            List<AttendanceDetails> attendanceDetailsList = attendance.getAttendanceDetails();
            PreparedStatement detailStatement = null;
            String detailSql = "INSERT INTO attendance_details (attendance_id, student_id, status )"
                    + " values (?,?,?)";
            for (int i=0; i<attendanceDetailsList.size(); i++){
                attendanceDetails = attendanceDetailsList.get(i);
                detailStatement = con.prepareStatement(detailSql);
                AttendanceDAO attendanceDAO =  new AttendanceDAO();
                detailStatement.setLong(1, attendanceDAO.maxOfAttendanceId());
                detailStatement.setLong(2, attendanceDetails.getStudentId());
                detailStatement.setString(3, attendanceDetails.getStatus());
                detailStatement.executeUpdate();   
                
            }*/
            //updateStockAfterSales(sales,salesDetailsList, trackActivity);
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
    

     public long maxOfAttendanceId() {
        long maxAttId = 0;
        try {           
            String sql = " SELECT max(attendance_id) from attendance ";
            Statement st = con.createStatement();  
            rs = st.executeQuery(sql);
            while (rs.next()){
                maxAttId = rs.getLong(1);
            }                
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxAttId;
    }      
}
