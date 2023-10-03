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
public class Theme {
    String name;
    String mobilenum;
    String email;
    String themep;
    int nop;
    Connection con;
    public Theme(String name, String emailid,String themep,int nop,String mobilenum, Connection con)
    {
        this.email=emailid;
        this.name=name;
        this.themep=themep;
        this.nop=nop;
        this.mobilenum=mobilenum;
        this.con=con;
        
    }
    public Theme(Connection con)
    {
         themep="";
        name="";
        email="";
        nop=0;
        mobilenum="";
        this.con=con;   
    }
    public boolean insert() throws Exception
    {
        PreparedStatement ps= con.prepareStatement("Insert into theme1 (name ,email,themep,nop,mobilenum) values(?,?,?,?,?)");
        ps.setInt(4,nop );
        ps.setString(1, name);
        ps.setString(5, mobilenum);
        ps.setString(2, email);
        ps.setString(3,themep);
        if(ps.executeUpdate()>0)
            return true;
        else 
            return false;
    }
    public boolean delete(String d) throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from theme1 where mobilenum=?");
        ps.setString(1,d);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    public boolean clear() throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from theme1");
        //ps.setString(1,d);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
}
