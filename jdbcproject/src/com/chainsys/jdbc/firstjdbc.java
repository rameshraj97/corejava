package com.chainsys.jdbc;
import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Blob;

public class firstjdbc {
	public static void main(String[] args) throws SQLException {
		firstjdbc f=new firstjdbc();
  //    f.delete();
  //    f.insert();
 //	    f.view();
 //		f.update();
 //		f.Drop();
//		f.create();
//	    f.insertimage();
		f.resultSetMetaData();
 	}

	public void create() {
	
		
		  try { 
			  
		  Connection myCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "oracle");
		  Statement mystat = myCon.createStatement();
		//  ResultSet myRs =  mystat.executeQuery("create table student2 (id number, name varchar(20), dept varchar(20), year number, mark number)");
		//  myRs.close();
		  mystat.close();
		  myCon.close();
		  }
		  catch(Exception err) {
		  err.printStackTrace();
		  
		 
		  
		 }
	}
		  public void insert() {
		 
	      try {
	    	  Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	    	  Statement  mystat = con.createStatement();
  //  	      ResultSet myRs =mystat.executeQuery ("create table Student2 "+ "(id number, name varchar(20),dept varchar(20),year number, mark number)");
	          PreparedStatement stmt =con.prepareStatement("insert into Student2"+" values(?,?,?,?,?)"); 
              Scanner sc= new  Scanner(System.in);
              Scanner scan =new Scanner(System.in);
           System.out.println("please enter the Student2 rollno: ");
           int rollno= sc.nextInt();
           System.out.println("entern name:");
           String name= sc.next();
           System.out.println("enter dept");
           String dept=sc.next();
           System.out.println("enter year");
           int year=sc.nextInt();
           System.out.println("mark:");
           int mark=sc.nextInt();
           
           stmt.setInt(1, rollno);
           stmt.setString(2, name);
           stmt.setString(3,dept);
           stmt.setInt(4,year);
           stmt.setInt(5,mark);
           int rows=stmt.executeUpdate();
           System.out.println(rows+"updated....");
           //myRs.close();
           con.close();
           mystat.close();
          
	       }catch(Exception err) {
	           err.printStackTrace();
	           
	      }  
	      
 
}
	public void delete() throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
  	    PreparedStatement stmt =con.prepareStatement("delete Student2 where id=?"); 
  	    stmt.setInt(1, 2021);
  	    int i=stmt.executeUpdate();
  	    System.out.println(i+"record deleted");
  	    stmt.close();
  	    con.close();
  	  
    }
	public void view() throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	    Statement  mystat = con.createStatement(); 
		ResultSet myRs =mystat.executeQuery ("select* from Student2 ");
		while(myRs.next()) {
		System.out.println(myRs.getInt(1)+myRs.getString(2)+myRs.getString(3)); 
		 }
	}
   public void update() throws SQLException {
	     Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		 PreparedStatement stmt =con.prepareStatement("update Student2 set year =? where   id=?"); 
		 stmt.setInt(1,2021);
		 stmt.setInt(2, 101);
		 int i=stmt.executeUpdate();
		 System.out.println(i+"record update");
		 stmt.close();
		 con.close();
		
	}
   public void Drop() throws SQLException {
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	  Statement stmt = con.createStatement();
	  String query ="drop table Student2";
	  ResultSet Rs =  stmt.executeQuery("drop table Student2");
	  int ss=stmt.executeUpdate(query);
	  System.out.println(ss+"table droped!");
      if(ss==0) {
    	System.out.println("table is dropped");
	    	}
	    else {
    	System.out.println("table is not drop");   
    	}
	    con.close();
	    }
   public void insertimage() throws SQLException{
	   try{
		   Class.forName("oracle.jdbc.driver.OracleDriver");  
		   Connection con=DriverManager.getConnection(  
		   "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		                 
		   PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");  
		   ps.setString(1,"group");  
		     
		   FileInputStream fin=new FileInputStream("D:\\photo.jpg");  
		   ps.setBinaryStream(2,fin,fin.available());  
		   int i=ps.executeUpdate();  
		   if(i==1)
		      {
			   System.out.println("success full");
			  }
		   con.close();  
		     }
	   catch (Exception e) 
	           {
			   System.out.println("please check your code!");
		      } 
             }
   
   
	  public void resultSetMetaData()throws SQLException  {
		   try{  
			   Class.forName("oracle.jdbc.driver.OracleDriver");  
			   Connection con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
			     
			   PreparedStatement ps=con.prepareStatement("select * from Student2");  
			   ResultSet rs=ps.executeQuery();  
			   ResultSetMetaData rsmd=rs.getMetaData();  
			     
			   System.out.println("Total columns: "+rsmd.getColumnCount());  
			   System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			   System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
			     
			   con.close();  
			   }catch(Exception e)
		       { 
				   e.printStackTrace();
		       }  
			   }  
			    
	   
		   }  

   
  
   
  
 

