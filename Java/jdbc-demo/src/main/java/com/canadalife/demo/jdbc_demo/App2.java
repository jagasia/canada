package com.canadalife.demo.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App2 {
    public static void main(String[] args) throws SQLException {
//        System.out.println("Hello World!");
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your username:");
        String username=sc.nextLine();
        System.out.print("Enter your password:");
        String password=sc.nextLine();
        
        String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "sys as sysdba", "password");
//		System.out.println("Oracle details are correct");
//		String sql="";
//		sql+="SELECT * FROM USER_MASTER WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
//		System.out.println("The sql statement was:\n"+sql);
//		ResultSet rs = con.createStatement().executeQuery(sql);
		
		PreparedStatement st = con.prepareStatement("SELECT * FROM USER_MASTER WHERE USERNAME=? AND PASSWORD=?");
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			System.out.println("Login is successful");
		}else {
			System.out.println("Login has failed");
		}
    }
}
