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
public class ClassMaster {
    long classMasterId;
    String className;
    double fees;

    public long getClassMasterId() {
        return classMasterId;
    }

    public void setClassMasterId(long classMasterId) {
        this.classMasterId = classMasterId;
    }    

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
   

    @Override
    public String toString() {
        return this.className; //To change body of generated methods, choose Tools | Templates.
    }
    
}
