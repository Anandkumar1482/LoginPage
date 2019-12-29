package com.blbz.login.serviceimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blbz.login.model.UserModel;

public class UserDao {
	private static  String URL = "jdbc:mysql://localhost:3306/Users";
	private static String USERNAME = "appuser";
	private static String PASSWORD = "appuser";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int save(UserModel user) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			System.out.println("Connection is established");
			PreparedStatement ps = con.prepareStatement("insert into User"
					+ "(FirstName,LastName,UserName,Password,Email) values " + "(?,?,?,?,?)");
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			System.out.println(user.toString());
			//1.ps.executeUpdate();

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(UserModel user) {
		int update=0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update User set FirstName=?,LastName=?,UserName=?,Email=? where id=?;");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getId());
			update = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return update;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from User where Id=?;");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			System.out.println("delete user status");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static UserModel getUserById(int id) {
		UserModel user = new UserModel();

		try {
			Connection con = UserDao.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from User where Id=?");
			System.out.println("Connection is established");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setEmail(rs.getString(6));

			}
			UserDao.getConnection().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	public static List<UserModel> getAllUsers() {
		ArrayList<UserModel> list = new ArrayList<UserModel>();

		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from User");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				int id=rs.getInt("Id");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String username = rs.getString("UserName");
				String email = rs.getString("Email");
				
				user.setId(id);
				user.setFirstName(fname);
				user.setLastName(lname);
				user.setUserName(username);
				user.setEmail(email);
				
				list.add(user);
				
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
