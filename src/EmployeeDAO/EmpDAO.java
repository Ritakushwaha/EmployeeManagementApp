/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDAO;

import EmployeeDButil.DbConnection;
import EmployeePOJO.EmpPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rita
 */
public class EmpDAO {
    
    //Add Employee in the database
    public static boolean addEmployee(EmpPOJO e)throws SQLException{
            Connection conn = DbConnection.getConnection();                                      
            PreparedStatement ps = conn.prepareStatement("insert into employee values (?,?,?,?)");
            ps.setInt(1, e.geteId());
            ps.setString(2, e.geteName());
            ps.setDouble(3, e.geteSal());
            ps.setInt(4, e.geteDept());
            if(ps.executeUpdate()>0)
                return true;
            else 
                return false;
    }
    
    //View All Employees on the screen 
    public static ArrayList<EmpPOJO> getAllEmployee () throws SQLException{
       ArrayList<EmpPOJO> empList = new ArrayList<>();
       Connection conn = DbConnection.getConnection();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("Select * from employee");
       while(rs.next()){
           EmpPOJO e = new EmpPOJO();
           e.seteId(rs.getInt(1));
           e.seteName(rs.getString(2));
           e.seteSal(rs.getDouble(3));
           e.seteDept(rs.getInt(4));
           empList.add(e);
       } return empList;
    }       


    
    //delete Employee data frpm the database
    public static boolean deleteEmp(int empno)throws SQLException{
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from employee where EID=?");
        ps.setInt(1, empno);
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;
    } 
    
    //Update Employees details 
    public static boolean updateEmp(EmpPOJO e , int empno)throws SQLException{
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update employee set ENAME=?,SAL=?,DEPTNO=? where EID=?");
        ps.setString(1,e.geteName());
            ps.setDouble(2, e.geteSal());
            ps.setInt(3, e.geteDept());
            ps.setInt(4, empno);
            if(ps.executeUpdate()>0)
                return true;
            else 
                return false;
    }
    
    //find an employee data from the table
    public static EmpPOJO searchEmp(int empno) throws SQLException{
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from employee where EID =?");
        ps.setInt(1, empno);
        EmpPOJO e =null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e = new EmpPOJO();
           e.seteName(rs.getString("ENAME"));
           e.seteSal(rs.getDouble("SAL"));
           e.seteDept(rs.getInt("DEPTNO"));
       } 
        return e;
    }
}