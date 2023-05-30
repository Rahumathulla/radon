/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.pojos;

import java.util.Date;

/**
 *
 * @author rahumathulla
 */
public class WorkLogReturn {
    
    long workLogId;
    long workLogDetailsId;
    long referenceNumber;
    Date workDate;
    Date createTS;
    Date updateTS;
    double totalAmount;
    String status;

    public long getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(long workLogId) {
        this.workLogId = workLogId;
    }

    public long getWorkLogDetailsId() {
        return workLogDetailsId;
    }

    public void setWorkLogDetailsId(long workLogDetailsId) {
        this.workLogDetailsId = workLogDetailsId;
    }

    public long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
