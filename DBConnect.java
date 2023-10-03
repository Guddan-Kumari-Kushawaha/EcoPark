/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guddan;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Guddan
 */
public class DBConnect {
    public static void main(String arg []){
           new Connect();
        }
    Connection con;
    public  DBConnect(){
        
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver"); 
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/Login");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
