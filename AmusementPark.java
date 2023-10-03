 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guddan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Guddan
 */
public class AmusementPark {
    String name,address,emailID,pass,uid;
    int mobile_number;
    Connection con;
    public AmusementPark( String uid,String name,String pass,String emailID,String address,int mobile_number, Connection con)
    {
        this.uid=uid;
        this.pass=pass;
        this.name=name;
        this.address=address;
        this.emailID=emailID;
        this.mobile_number=mobile_number;
        this.con=con;
    }
    public AmusementPark(Connection con)
    {
        mobile_number=0;
        name="";
        address="";
        emailID="";
        pass="";
        uid="";
        this.con=con;
    }
    public boolean insert() throws Exception
    {
        PreparedStatement ps= con.prepareStatement("Insert into amusementparklogin (userid,uname,password,emailID,address,mobilenum) values(?,?,?,?,?,?)");
        ps.setString(3, pass);
        ps.setString(1,uid);
        ps.setString(2, name);
        ps.setInt(6, mobile_number);
        ps.setString(4, emailID);
        ps.setString(5, address);
        if(ps.executeUpdate()>0)
            return true;
        else 
            return false;
    }
    
   public boolean delete(int d) throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from dept where did=?");
        ps.setInt(1,d);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
}

