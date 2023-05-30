/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.pojos;

import java.util.Date;

/**
 *
 * @author essaar
 */
public class Complaint {
    long complaintId;
    long referenceNumber;
    long studentId;
    String studentName;
    String parentName;
    String className;
    String complaintNotes;
    Date logDate;
    Date resolutionDate;
    String status;
    Date createTS;
    Date updateTS;

    public long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    public long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getComplaintNotes() {
        return complaintNotes;
    }

    public void setComplaintNotes(String complaintNotes) {
        this.complaintNotes = complaintNotes;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTS() {
        return createTS;
    }

    public void setCreateTS(Date createTS) {
        this.createTS = createTS;
    }

    public Date getUpdateTS() {
        return updateTS;
    }

    public void setUpdateTS(Date updateTS) {
        this.updateTS = updateTS;
    }
    
    
}
