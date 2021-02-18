/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeePOJO;

/**
 *
 * @author Rita
 */
public class EmpPOJO {
    private int eId;
    private String eName;
    private double eSal;
    private int eDept;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double geteSal() {
        return eSal;
    }

    public void seteSal(double eSal) {
        this.eSal = eSal;
    }

    public int geteDept() {
        return eDept;
    }

    public void seteDept(int eDept) {
        this.eDept = eDept;
    }
    
    public EmpPOJO(){
    
    }
}
