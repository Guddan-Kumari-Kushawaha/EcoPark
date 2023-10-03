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
public class FoodCourt {
    String name,restaurant,fooditem,address;
    int mobilenum;
    Connection con;
    public FoodCourt(String name,int mobile_number,String restaurant,String fooditem,String address, Connection con)
    {
         this.restaurant=restaurant;
        this.name=name;
        this.fooditem=fooditem;
        this.address=address;
        this.mobilenum=mobile_number;
        this.con=con;
        
    }
    public FoodCourt(Connection con)
    {
         restaurant="";
        name="";
        fooditem="";
        address="";
        mobilenum=0;
        this.con=con;   
    }
    public boolean insert() throws Exception
    {
        PreparedStatement ps= con.prepareStatement("Insert into FOODCOURT (name ,mobilenum,restaurant,fooditem,address) values(?,?,?,?,?)");
        ps.setString(5,address );
        ps.setString(1, name);
        ps.setInt(2, mobilenum);
        ps.setString(3, restaurant);
        ps.setString(4, fooditem);
        if(ps.executeUpdate()>0)
            return true;
        else 
            return false;
    }
    public boolean delete(int d) throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from FOODCOURT where mobilenum=?");
        ps.setInt(1,d);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    public boolean clear() throws Exception {
        PreparedStatement ps=con.prepareStatement("delete from FOODCOURT");
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
}
