/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.pojos;

/**
 *
 * @author essaar
 */
public class AttendanceDetails {
    long attendanceDetailsId;
    long attendanceId;
    long studentId;
    String status;

    public long getAttendanceDetailsId() {
        return attendanceDetailsId;
    }

    public void setAttendanceDetailsId(long attendanceDetailsId) {
        this.attendanceDetailsId = attendanceDetailsId;
    }

    public long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
