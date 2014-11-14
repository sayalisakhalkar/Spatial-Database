/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_project;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;
import oracle.sdoapi.OraSpatialManager;
import oracle.sdoapi.geom.*;
import oracle.sdoapi.adapter.*;
import oracle.sdoapi.sref.*;
import oracle.sql.STRUCT;
/**
 *
 * @author Sayali Sakhalkar
 */
public class Populate {
    /**
     * @param args the command line arguments
     */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
	//Connection Variables
  	Connection mainConnection = null;
  	Statement mainStatement = null;
  	ResultSet mainResultset1 = null;
        static int num_of_args=0;
        static String[] args_store=new String[100];
        static int copy_store=0;
        List<String> record_val;
        String[] a;
        
  	public static void main(String[] args) throws IOException, SQLException
        {
            int i=0;
            
            num_of_args=args.length;
            System.out.println("num of args"+num_of_args);
            copy_store=num_of_args;
                while(copy_store!=0)
                {
                    System.out.println("args[i]"+args[i]);
                    args_store[i]=args[i];
                    System.out.println("args_store[i]"+args_store[i]+"copy_store[i]"+copy_store);
                    i++;
                    --copy_store;
                }
            Populate k=new Populate();
        }
	/********************************************/
	/* constructore								*/
	/********************************************/
 	public Populate() throws IOException, SQLException
        {
                //Map p=new Map();
		System.out.println("constructor entered..");
                ConnectToDB();
                //PublishData();	
                ReadData();
                //ShowMetaData();			// show meta data
		//ShowAllTuples();		// show results of the search

        }
	/********************************************/
	/* Connecting to DB							*/
	/********************************************/
	public void ConnectToDB()
 	{
		try
		{
			// loading Oracle Driver
    		System.out.print("Looking for Oracle's jdbc-odbc driver ... ");
	    	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    	System.out.println(", Loaded.");
                String URL = "jdbc:oracle:thin:@localhost:1523:sysdba5";
	    	String userName = "sys as sysdba";
	    	String password = "Oracle94";
                System.out.print("Connecting to DB...");
	    	mainConnection = DriverManager.getConnection(URL, userName, password);
	    	System.out.println(", Connected!");

    		mainStatement = mainConnection.createStatement();

   		}
   		catch (Exception e)
   		{
     		System.out.println( "Error while connecting to DB: "+ e.toString() );
     		e.printStackTrace();
     		System.exit(-1);
   		}
 	}
        public void PublishData(int par1,int par2,int par3) throws IOException, SQLException
        {
                int j=par1;
                int count_students=0;
                int publish_data_count=par3;
                System.out.println("Publish Data entered");
                try
                {
                   if(publish_data_count==0)
                    {
                        System.out.print( "\n ** Deleting previous tuples ..." );
                        System.out.println("query: delete from "+args_store[j]);
                      mainStatement.executeUpdate( "delete from "+args_store[j]);
                        System.out.println( ", Deleted. **" ); 
                        publish_data_count++;
                    }
                   // while(args_store[j]!=null)
                    {
                                
                        System.out.print( " ** Inserting Data ..." );
                        a = record_val.get(0).split(",");
                        System.out.println("array len"+a.length);
                        //System.out.println("array "+a[0]);
                        int k=0;
                        String qry="insert into " +args_store[j]+" values (";
                        String temp=qry;
                        String qry1="insert into " +args_store[j]+" values (";
                        int count=0;
                        int flag=0;
                        int point_count=0;
                        while(k!=(a.length))
                        {
                        if(args_store[j].equals("buildings"))
                        {
                            if(count<2)
                            {   
                                System.out.println("%%%%%%%First val "+a[k]);
                                qry = qry + "'" + a[k] + "',";
                                
                            }
                            if(count==2)
                            {
                                System.out.println("%%%%% 2"+a[k]);
                                qry = qry + "" + a[k] + ",";
                            }
                            if(count==3)
                            {
                               // if(args_store[j].equals("buildings"))
                                System.out.println("%%%%%%% 3"+a[k]);
                                qry = qry + "SDO_GEOMETRY (2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+a[k]+",";
                             //   k++;
                            }
                            if(count>3)
                            {
                                System.out.println("%%%%%%% > 3"+a[k]);
                                if(point_count==0)
                                {
                                    qry = qry + "" + a[k] + ",";
                                    point_count++;
                             //       k++;
                                }    
                                else
                                {
                                    qry = qry + a[k] + ",";
                                    point_count=0;
                           //         k++;
                                }    
                            }
                            count++;
                        }
                        if(args_store[j].equals("students"))
                        {
                            
                            System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                {    
                               // ReadData
                                //System.out.println("##########Entered");
                                if(k==0)
                                    {
                                        //qry="";
                                        qry="";
                                        qry=temp;
                                        System.out.println("#######Entered..");
                                        qry = qry + "'" + a[k] + "',";
                                        System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                     
                                    }
                                if(k==1) 
                                    {
                                        qry = qry + "SDO_GEOMETRY (2001,NULL,MDSYS.SDO_POINT_TYPE(";
                                        qry = qry + "" + a[k] + ",";
                                        System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                    }
                                if(k==2)
                                {
                                 qry = qry + "" + a[k] + ",NULL),NULL,NULL))";
                                 System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                }
                                //count_students++;
                                }
                        }
                        if(args_store[j].equals("announcementSystems"))
                        {
                            int store1=0;
                            int store2=0;
                            System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                if(k==0)
                                    {
                                        //qry="";
                                        qry="";
                                        qry=temp;
                                        System.out.println("#######Entered..");
                                        qry = qry + "'" + a[k] + "',";
                                        System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                     
                                    }
                                if(k==1) 
                                    {
                                        qry = qry + "SDO_GEOMETRY (2001, NULL, MDSYS.SDO_POINT_TYPE(";                                        
                                        qry = qry + "" + a[k] +",";
                                        System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                    }
                                if(k==2) 
                                    {
                                        qry = qry + "" + a[k] +",NULL),NULL,NULL),";
                                        System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                    }
                                if(k==3)
                                    {
                                        qry = qry + "" + a[k] +")";
                                        System.out.println("!!!!!Value of k="+k+"qry="+qry);
                                    }
                        }
                        k++;
                        }
                        System.out.println("Reached query...");
                        //if(args_store[j].equals("announcementSystems"))
                         //   qry = qry.substring(0, (qry.lastIndexOf(","))) + "))";
                        if(args_store[j].equals("buildings"))
                            qry = qry.substring(0, (qry.lastIndexOf(","))) + ")))";
                        
                       /* if(args_store[j].equals("announcementSystems"))
                        {
                            qry1 = qry1.substring(0, (qry1.lastIndexOf(",")-1)) + ")))";
                            System.out.println("qry1 "+qry1);
                        }*/  
                        System.out.println("qry "+qry);
                        mainStatement.executeUpdate(qry);
                        /*if(flag==1)
                             mainStatement.executeUpdate(qry1);    
                        */
                        /*mainStatement.executeUpdate( "insert into " +args_store[j]+" values ('Doll, Bob', '123-456-7890', 100000)" );
                        mainStatement.executeUpdate( "insert into " +args_store[j]+" values ('Bush, George', '654-321-0987', 450000)" );
                        mainStatement.executeUpdate( "insert into " +args_store[j]+" values ('Gore, Al', '321-098-7654', 200000)" );
                        mainStatement.executeUpdate( "insert into " +args_store[j]+" values ('Bing, Chandler', '432-105-6789', 750000)" );
                                */
                        System.out.println( ", Done.\n **" );
                        //num_of_args--;
                     //   j++;
                    }
                }
                catch( Exception e )
                { 
                    System.out.println( " Error 2: " + e.toString() ); 
                }
                System.out.println("Publish Data exited");
        }
        public void ReadData() throws IOException, SQLException
        {
            System.out.println("Read Data entered");
            int j=0;
            int count_students=0;
            int publish_data_count=0;    
            String line=null;
            int length_copy1 = args_store.length;
            int i=0;
            while(args_store[i]!=null)
            {
                publish_data_count=0;
                System.out.println("readDATA$$$$$"+args_store[i]);
                try 
                {   
                BufferedReader reader = new BufferedReader(new FileReader((args_store[i]+".xy")));
                while ((line = reader.readLine()) != null)
                {
                    //line = reader.readLine();
                    record_val = new ArrayList<String>();
                    record_val.add(line);
                    PublishData(i,count_students,publish_data_count);
                    publish_data_count++;
                    System.out.println("line"+record_val);
                }
                reader.close();
                }
                catch (Exception ex) 
                {
                    System.out.println(ex);
                }
                length_copy1--;
                i++;
            }
            System.out.println("Read Data exited");
        }
        /*
        public void ShowMetaData()
    {
    	try
		{
                                // shows meta data
    	    System.out.println("\n ** Obtaining Meta Data ** " );
	        ResultSetMetaData meta = mainResultSet.getMetaData();
	        for( int col=1; col<=meta.getColumnCount(); col++ )
		        System.out.println( "Column: " + meta.getColumnName(col) + "\t, Type: " + meta.getColumnTypeName(col) );
    	}
		catch( Exception e )
    	{ System.out.println( " Error : " + e.toString() ); }
    }
*/
            public void ShowAllTuples()
        {
                System.out.println("Show All Tuples Entered");
                STRUCT point;		//Structure to handle Geometry Objects
		Geometry geom;     	//Structure to handle Geometry Objects
		try
		{
                // shows result of the query
                System.out.println("\n ** Showing all Tuples ** " );
	        int tupleCount=1;
                GeometryAdapter sdoAdapter = OraSpatialManager.getGeometryAdapter("SDO", "9",STRUCT.class, null, null, mainConnection);
 	        while( mainResultset1.next() )
    	    {
	    	    System.out.print( "Tuple " + tupleCount++ + " : " );
	    	    int Point_ID = mainResultset1.getInt( 1 );
	    	    System.out.print( "\"" + Point_ID + "\"," );
	    	    point = (STRUCT)mainResultset1.getObject(2);
				geom = sdoAdapter.importGeometry( point );
      			if ( (geom instanceof oracle.sdoapi.geom.Point) )
      			{
					oracle.sdoapi.geom.Point point0 = (oracle.sdoapi.geom.Point) geom;
					double X = point0.getX();
					double Y = point0.getY();
					System.out.print( "\"(X = " + X + ", Y = " + Y + ")\"" );
				}

		        System.out.println();
       	    }
        }
		catch( Exception e )
	    { System.out.println(" Error : " + e.toString() ); }

		System.out.println();
                System.out.println("Show All tuples Exited...");
    }

  }


   
