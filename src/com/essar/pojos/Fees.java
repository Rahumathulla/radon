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
public class Fees {
    long feesId;
    long studentId;
    Double amount;
    Date feesDate;
    String description;
    Date createTS;
    Date updateTS;
    long receiptNumber;
    public long getFeesId() {
        return feesId;
    }

    public void setFeesId(long feesId) {
        this.feesId = feesId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }   

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getFeesDate() {
        return feesDate;
    }

    public void setFeesDate(Date feesDate) {
        this.feesDate = feesDate;
    }
   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(long receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    
    
}
