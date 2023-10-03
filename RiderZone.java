/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guddan;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Guddan
 */
public class RiderZone {
  
/**
 *
 * @author Guddan
 */
    String name,riden,email,date;
    String mobilenumr;
    Connection con;
    public RiderZone(String name,String mobilenumr,String email,String riden,String date, Connection con)
    {
        this.date=date;
        this.name=name;
        this.riden=riden;
        this.email=email;
        this.mobilenumr=mobilenumr;
        this.con=con;
    }
    public RiderZone(Connection con)
    {
        name="";
        mobilenumr="";
        riden="";
        email="";
        date="";
        this.con=con;
    }
    public boolean insert() throws Exception
    {
        PreparedStatement ps= con.prepareStatement("insert into RIDES (name,mobilenumr,email,riden,date) values (?,?,?,?,?)");
        ps.setString(5,date);
        ps.setString(1, name);
        ps.setString(2, mobilenumr);
        ps.setString(3, email);
        ps.setString(4, riden);
        if(ps.executeUpdate()>0)
            return true;
        else 
            return false;
    }
    public boolean delete(String d) throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from rides where mobilenumr=?");
        ps.setString(1,d);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    public boolean clear() throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from rides");
       // ps.setString(1,d);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
}
