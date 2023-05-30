/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.pojos;


/**
 *
 * @author rahumathulla
 */
public class CustomerAccountItem {
    long CustomerAccountItemId;
    String CustomerAccountItemName;
    String type;
    String remarks;

    public long getCustomerAccountItemId() {
        return CustomerAccountItemId;
    }

    public void setCustomerAccountItemId(long CustomerAccountItemId) {
        this.CustomerAccountItemId = CustomerAccountItemId;
    }

    public String getCustomerAccountItemName() {
        return CustomerAccountItemName;
    }

    public void setCustomerAccountItemName(String CustomerAccountItemName) {
        this.CustomerAccountItemName = CustomerAccountItemName;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
   

    @Override
    public String toString() { 
        return CustomerAccountItemName; 
    } 
    
    
}
