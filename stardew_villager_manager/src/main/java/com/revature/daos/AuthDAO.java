package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class AuthDAO {

	//I should've made an interface,. but it's okay
	
	//This DAO would likely have other method like register user, or update user info
	//but we just need a login for p0 and p1
	
	public boolean login(String username, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from users where username = ? and password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			//if anything gets returned at all, we know a user exists with that username/password pair, so we can return true
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Login failed");
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}