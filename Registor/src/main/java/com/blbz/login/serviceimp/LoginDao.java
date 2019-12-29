package com.blbz.login.serviceimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	private static String URL = "jdbc:mysql://localhost:3306/Users";
	private static String USERNAME = "appuser";
	private static String PASSWORD = "appuser";
	private static String sql = "select * from User where UserName=? and Password=?";

	public static boolean validate(String UserName, String Password) {
		boolean status = false;
		try {
			//1.load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.establish the connection between jdbc and database
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//3.prepare the sql statement
			//4.create the jdbc statement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, UserName);
			ps.setString(2, Password);
			//5.submit the sql statement to database using jdbc cstatement
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
