/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_project;

import java.awt.Polygon;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JCheckBox;

/**
 *
 * @author Sayali Sakhalkar
 */
public class Whole_Region 
{
        Connection mainConnection = null;
        Statement mainStatement = null;
        PreparedStatement SecondStatement = null;
        Statement ThirdStatement = null;
        ResultSet mainResultSet = null;
        Polygon poly[] = new Polygon[123];
       public static void main(String args[])throws Exception
       {
           
       }

    public Whole_Region() throws IOException, SQLException 
       {
           Populate d=new Populate();
           d.ConnectToDB();
       }    
    public void qry_execute()
    {
        int counter=0;
        while(counter==poly.length)
        {
            poly[counter] = new Polygon();
        }
        Hw2 e = new Hw2();
        if(e.build==true)
        {
            String store1 = "Select * from buildings";
            try {
                    mainConnection.prepareStatement(store1);
                    mainStatement = mainConnection.createStatement();
                    ResultSet rs = mainStatement.executeQuery(store1);
                    while(rs.next())
                    {
                        rs.getString(0);
                        
                    }
                } 
            catch (SQLException ex) 
                {
                    Logger.getLogger(Hw2.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if(e.student==true)
        {
             
        }
        if(e.anouncement_sys==true)
        {
                    
        }
       }
}
