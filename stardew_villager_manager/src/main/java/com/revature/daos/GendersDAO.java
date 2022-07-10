package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Genders;
import com.revature.utils.ConnectionUtil;

public class GendersDAO implements GenderDAOInterface {

	@Override
	public Genders getGenderById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from genders where gender_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Genders gender = new Genders(
						rs.getInt("gender_id"),
						rs.getString("gender")
						);
				return gender;
			}
		} catch (SQLException e) {
			System.out.println("Get Gender Failed");
			e.printStackTrace();
		}
		
		return null;
	}

}
