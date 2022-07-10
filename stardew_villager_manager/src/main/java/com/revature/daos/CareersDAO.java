package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Careers;
import com.revature.utils.ConnectionUtil;

public class CareersDAO implements CareersDAOInterface{

	@Override
	public Careers getCareerById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from careers where career_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Careers career = new Careers(
						rs.getInt("career_id"),
						rs.getString("career")
						);
				return career;
			}
		} catch (SQLException e) {
			System.out.println("Get Career Failed");
			e.printStackTrace();
		}
		return null;
	}

}
