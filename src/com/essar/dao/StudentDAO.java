/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.pojos.ClassMaster;
import com.essar.utils.ConnectionManager;
import com.essar.pojos.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahumathulla
 */
public class StudentDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<Student>  cList= null;
        
    public List<Student> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Student>  studentList= null;
        try {
            sql = "SELECT * from student";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Student student = null;
            studentList = new ArrayList<Student>();
            while(rs.next()){
                student = new Student();
                student.setStudentId(rs.getLong(1));
                student.setStudentName(rs.getString(2));
                student.setAddress(rs.getString(3));     
                student.setGender(rs.getString(4));
                student.setDateOfBirth(rs.getDate(5));
                student.setAdmissionDate(rs.getDate(6));
                student.setGuardian(rs.getString(7));
                student.setRelationship(rs.getString(8));
                student.setContactNumber(rs.getString(9));
                student.setSchoolId(rs.getLong(10));
                student.setClassId(rs.getLong(11));
                student.setFeesPercentage(rs.getDouble(12));
                student.setCreateTS(rs.getTime(13));
                student.setUpdateTS(rs.getTime(14));
                student.setExtraCurricular(rs.getString(15));
                //Adding to List
                studentList.add(student);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+studentList.size());
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studentList;
    }
    
    public Student retrieveByName(String studentName) {
        Student  student= null;
        try {
            sql = "SELECT * from student where student_name = '" + studentName +"'";
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            rs = st.executeQuery(sql);
            while(rs.next()){
                student = new Student();
                student.setStudentId(rs.getLong(1));
                student.setStudentName(rs.getString(2));
                student.setAddress(rs.getString(3));     
                student.setGender(rs.getString(4));
                student.setDateOfBirth(rs.getDate(5));
                student.setAdmissionDate(rs.getDate(6));
                student.setGuardian(rs.getString(7));
                student.setRelationship(rs.getString(8));
                student.setContactNumber(rs.getString(9));
                student.setSchoolId(rs.getLong(10));
                student.setClassId(rs.getLong(11));
                student.setFeesPercentage(rs.getDouble(12));
                student.setCreateTS(rs.getTime(13));
                student.setUpdateTS(rs.getTime(14));
                student.setExtraCurricular(rs.getString(15));
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return student;
    }

    
    public List<Student> retrieveByQuery(String sql) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Student>  studentList= null;
        try {
            //sql = "SELECT * from student";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Student student = null;
            studentList = new ArrayList<>();
            while(rs.next()){
                student = new Student();
                student.setStudentId(rs.getLong(1));
                student.setStudentName(rs.getString(2));
                student.setAddress(rs.getString(3));     
                student.setGender(rs.getString(4));
                student.setDateOfBirth(rs.getDate(5));
                student.setAdmissionDate(rs.getDate(6));
                student.setGuardian(rs.getString(7));
                student.setRelationship(rs.getString(8));
                student.setContactNumber(rs.getString(9));
                student.setSchoolId(rs.getLong(10));
                student.setClassId(rs.getLong(11));
                student.setFeesPercentage(rs.getDouble(12));
                student.setCreateTS(rs.getTime(13));
                student.setUpdateTS(rs.getTime(14));
                student.setExtraCurricular(rs.getString(15));
                //Adding to List
                studentList.add(student);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+studentList.size());
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studentList;
    }

    
    public Student retrieveById(long id) {
        Student  student= null;
        try {
            sql = "SELECT * from student where student_id = " + id;
            Statement st = con.createStatement();            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ps.setLong(1, id);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            rs = st.executeQuery(sql);
            while(rs.next()){
                student = new Student();
                student.setStudentId(rs.getLong(1));
                student.setStudentName(rs.getString(2));
                student.setAddress(rs.getString(3));     
                student.setGender(rs.getString(4));
                student.setDateOfBirth(rs.getDate(5));
                student.setAdmissionDate(rs.getDate(6));
                student.setGuardian(rs.getString(7));
                student.setRelationship(rs.getString(8));
                student.setContactNumber(rs.getString(9));
                student.setSchoolId(rs.getLong(10));
                student.setClassId(rs.getLong(11));
                student.setFeesPercentage(rs.getDouble(12));
                student.setCreateTS(rs.getTime(13));
                student.setUpdateTS(rs.getTime(14));
                student.setExtraCurricular(rs.getString(15));
                
                                      
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+studentList.size());
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return student;
    }


    public void insertIntoDB(Student student) {
        try {            
            String sql = "INSERT INTO student (student_name, address, gender, date_of_birth, admission_date, guardian, relationship, contact_number"
                    + ", school_id, class_id, fees_percentage, create_ts, update_ts, extra_curricular )  values (?,?,?,?,?,?,?,?,?,?,?,NOW(), NOW(),?)";
            java.sql.Date dob = new java.sql.Date( student.getDateOfBirth().getTime());
            java.sql.Date admissionDate = new java.sql.Date( student.getAdmissionDate().getTime());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getAddress());
            ps.setString(3, student.getGender());
            ps.setDate(4, dob);
            ps.setDate(5, admissionDate);
            ps.setString(6, student.getGuardian());
            ps.setString(7, student.getRelationship());
            ps.setString(8, student.getContactNumber());
            ps.setLong(9, student.getSchoolId());
            ps.setLong(10, student.getClassId());
            ps.setDouble(11, student.getFeesPercentage());
            ps.setString(12, student.getExtraCurricular());
            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStudent(Student student) {
        try {            
            String sql = "UPDATE student SET student_name=?, address=?, gender=?, date_of_birth=?, admission_date=?, guardian=?, relationship=?, contact_number=?"
                    + ", school_id=?, class_id=?, fees_percentage=?, update_ts =NOW(), extra_curricular = ? "
                    + " WHERE student_id = ?";
            java.sql.Date dob = new java.sql.Date( student.getDateOfBirth().getTime());
            java.sql.Date admissionDate = new java.sql.Date( student.getAdmissionDate().getTime());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getAddress());
            ps.setString(3, student.getGender());
            ps.setDate(4, dob);
            ps.setDate(5, admissionDate);
            ps.setString(6, student.getGuardian());
            ps.setString(7, student.getRelationship());
            ps.setString(8, student.getContactNumber());
            ps.setLong(9, student.getSchoolId());
            ps.setLong(10, student.getClassId());
            ps.setDouble(11, student.getFeesPercentage());
            ps.setString(12, student.getExtraCurricular());
            ps.setLong(13, student.getStudentId());

            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteRecordById(long id) {
        try {            
            String sql = "DELETE FROM student WHERE student_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<String> retrieveAllStudents() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<String>  studentList= null;
        try {
            String sql = "SELECT student_name from student";
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            studentList = new ArrayList<>();
            while(rs.next()){                
                studentList.add(rs.getString(1));
 
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ClassMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studentList;
    }
    public void updateRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
