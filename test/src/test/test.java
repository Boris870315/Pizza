package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
	
	
public class test {


	    public static void main(String[] args) {
	        JDBConnection newConnection = new JDBConnection();
	        newConnection.getConnection();
	    }
	}

	class JDBConnection {
	    public static void getConnection() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nofreeride", "root", "Boris97445028");
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from student");
	        while(rs.next())
	        {
	            System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " "+ rs.getString(3));
	        }
	        rs.close();
	        stmt.close();
	        conn.close();
	    }
	    catch(Exception e){System.out.println(e);}
	    }
	    
	}


